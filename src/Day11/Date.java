package Day11;

import java.util.Calendar;
import java.util.Scanner;

class CalendarToPrint {
    Calendar cal = Calendar.getInstance();
    int todaysDate;
    int year;
    int month;
    int dayToStart;
    int lastDay;

    public CalendarToPrint() {
        cal = Calendar.getInstance();
        this.todaysDate = cal.get(Calendar.DATE);
        this.year = cal.get(Calendar.YEAR);
        this.month = cal.get(Calendar.MONTH) + 1;
        cal.set(Calendar.DATE, 1);
        this.dayToStart = cal.get(Calendar.DAY_OF_WEEK);
        this.lastDay = cal.getActualMaximum(Calendar.DATE);
    }

    public CalendarToPrint(int year, int month, int date) {
        cal.set(year, month - 1, date);
        this.year = year;
        this.month = month;
        this.todaysDate = date;
        cal.set(Calendar.DATE, 1);
        this.dayToStart = cal.get(Calendar.DAY_OF_WEEK);
        this.lastDay = cal.getActualMaximum(Calendar.DATE);
    }
}

class Printer {
    String[] days = {"S", "M", "T", "W", "TH", "F", "S"};

    public Printer(CalendarToPrint today) {
        System.out.printf("%13d년 %4d월%n", today.year, today.month);
        for (String day : days) {
            System.out.printf("%4s", day);
        }
        System.out.println();

        int dayCounter = today.dayToStart;

        for (int i = 1; i < today.lastDay + 1; i++) {

            if (i == 1) {
                for (int j = today.dayToStart; j > 1; j--) {
                    System.out.printf("%4s", " ");
                }
            }

            if (i == today.todaysDate) {
                String temp = "\u001B[31m" + today.todaysDate + "\u001B[0m";
                System.out.printf("%13s", temp);
            } else {
                System.out.printf("%4d", i);
            }


            if (dayCounter % 7 == 0) {
                System.out.println();
                dayCounter = 0;
            }

            dayCounter++;
        }
    }
}

public class Date {
    static CalendarToPrint calendar;
    static Printer printer;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please select");
        System.out.println("1. Today | 2. Choose A Day");
        String choice = input.nextLine();

        if (choice.equals("1")) {
            calendar = new CalendarToPrint();
            printer = new Printer(calendar);
        } else if (choice.equals("2")) {
            System.out.println("Please enter date in form of: YYYY/MM/DD");
            String[] chosenDate = input.nextLine().split("/");

            calendar = new CalendarToPrint(Integer.parseInt(chosenDate[0]), Integer.parseInt(chosenDate[1]), Integer.parseInt(chosenDate[2]));
            printer = new Printer(calendar);
        }
    }

}

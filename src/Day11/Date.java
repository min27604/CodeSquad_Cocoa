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
        this.month = cal.get(Calendar.MONTH);
        cal.set(Calendar.DATE, 1);
        this.dayToStart = cal.get(Calendar.DAY_OF_WEEK);
        this.lastDay = cal.getActualMaximum(Calendar.DATE);
    }

    public CalendarToPrint(int year, int month, int date) {
        cal.set(year, month, date);
        this.year = cal.get(Calendar.YEAR);
        this.month = cal.get(Calendar.MONTH);
        this.todaysDate = cal.get(Calendar.DATE);
        cal.set(Calendar.DATE, 1);
        this.dayToStart = cal.get(Calendar.DAY_OF_WEEK);
        this.lastDay = cal.getActualMaximum(Calendar.DATE);
    }
}

class Printer {
    public Printer(CalendarToPrint today) {
        System.out.println("   S   M   T   W  TH   F   S");
        for (int i = today.dayToStart; i > 1; i--) {
            System.out.printf("%4s", " ");
        }

        for (int i = 1; i < today.lastDay + 1; i++) {
            if (i == today.todaysDate) {
                String temp = "\u001B[31m" + today.todaysDate + "\u001B[0m";
                System.out.printf("%13s", temp);
                continue;
            }
            System.out.printf("%4d", i);
            if (i % 7 == 0) {
                System.out.println();
            }

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

package Day1;

import java.util.Scanner;

public class if_2884_Alarm {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int hour = input.nextInt();
        int minute = input.nextInt();

        if (minute >= 45) {
            System.out.println(hour + " " + (minute - 45));
        } if (minute < 45) {
            if (hour == 0){
                hour = 24;
            }
            minute -= 45;
            System.out.println(hour - 1 + " " + (60 + minute));
        }
    }
}

package Day11;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Time {
    int hour;
    int minute;
    String period;
    String timeNow;

    public void setHourMinutePeriod() {
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH mm");
        this.timeNow = time.format(formatter);
        Scanner scan = new Scanner(timeNow);
        this.hour = scan.nextInt();
        this.minute = scan.nextInt();
        if (this.hour > 12) {
            this.period = "PM";
            this.hour -= 12;
            return;
        }
        this.period = "PM";
    }
}

class Checker {
    boolean[] checker = new boolean[36];

    public void isMidDayOrNight(int hour, int minute, String period) {
        if (hour == 0 && minute == 0) { // 자정, 정오
            checker[24] = true;
            if (period.equals("AM")) {
                checker[18] = true;
            }
            if (period.equals("PM")) {
                checker[30] = true;
            }
        }
    }

    public void checkHour(int hour) {
        checker[17] = true; // '시'
        switch (hour) {
            case 1 :
                checker[0] = true;
                break;
            case 2 :
                checker[1] = true;
                break;
            case 3 :
                checker[2] = true;
                break;
            case 4 :
                checker[3] = true;
                break;
            case 5 :
                checker[4] = checker[5] = true;
                break;
            case 6 :
                checker[6] = checker[7] = true;
                break;
            case 7 :
                checker[8] = checker[9] = true;
                break;
            case 8 :
                checker[10] = checker[11] = true;
                break;
            case 9 :
                checker[12] = checker[13] = true;
                break;
            case 10 :
                checker[14] = true;
                break;
            case 11:
                checker[14] = checker[15] = true;
                break;
            case 12:
                checker[14] = checker[16] = true;
        } // 해당 시(number)
    }

    public void checkMinute(int minute) {
        checker[35] = true; // '분'
        switch (minute % 10) {
            case 1:
                checker[25] = true;
                break;
            case 2:
                checker[26] = true;
                break;
            case 3:
                checker[27] = true;
                break;
            case 4:
                checker[28] = true;
                break;
            case 5:
                checker[31] = true;
                break;
            case 6:
                checker[29] = true;
                break;
            case 7:
                checker[32] = true;
                break;
            case 8:
                checker[33] = true;
                break;
            case 9:
                checker[34] = true;
                break;

        } // 해당 분(number)
        if (minute > 9) {
            checker[23] = true;
            switch (minute / 10) {
                case 2:
                    checker[19] = true;
                    break;
                case 3:
                    checker[20] = true;
                    break;
                case 4:
                    checker[21] = true;
                    break;
                case 5:
                    checker[22] = true;
                    break;

            }
        }
    }
}

public class Mission5_HangulClock {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {

        Time time = new Time();
        Checker checker = new Checker();
        time.setHourMinutePeriod();
        checker.isMidDayOrNight(time.hour, time.minute, time.period);
        checker.checkHour(time.hour);
        checker.checkMinute(time.minute);
        char[] hangul = {'한', '두', '세', '네', '다', '섯', '여', '섯', '일', '곱', '여', '덟', '아', '홉', '열', '한', '두', '시',
                '자', '이', '삼', '사', '오', '십', '정', '일', '이', '삼', '사', '육', '오', '오', '칠', '팔', '구', '분'};

        for (int i = 0; i < 36; i++) {
            if (i % 6 == 0) { System.out.println(); } // new lines after six letters
            if (checker.checker[i]) { // print in red if the letter's checked according to the time
                System.out.print(ANSI_RED + hangul[i] + " " + ANSI_RESET);
                continue;
            }
            System.out.print(hangul[i] + " "); // print letters
        }
    }
}

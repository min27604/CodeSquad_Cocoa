package Day11;

import java.time.LocalTime;

class Time {
    int hour;
    int minute;
    String period;
    String[] timeNow = String.valueOf(LocalTime.now()).split(":");

    public Time() {
        this.hour = Integer.parseInt(timeNow[0]);
        this.minute = Integer.parseInt(timeNow[1]);
        if (this.hour > 12) {
            this.period = "PM";
            this.hour -= 12;
            return;
        }
        this.period = "AM";
    }
}

class Checker {
    boolean[] checker = new boolean[36];

    public void isMidDayOrNight(Time time) {
        if (time.hour == 0 && time.minute == 0) { // 자정, 정오
            this.checker[24] = true; // '정'에 true
            if (time.period.equals("AM")) {
                this.checker[18] = true;
            }
            if (time.period.equals("PM")) {
                this.checker[30] = true;
            }
        }
    }

    public void checkHour(Time time) {
        this.checker[17] = true; // '시'
        switch (time.hour) {
            case 1:
                this.checker[0] = true;
                break;
            case 2:
                this.checker[1] = true;
                break;
            case 3:
                this.checker[2] = true;
                break;
            case 4:
                this.checker[3] = true;
                break;
            case 5:
                this.checker[4] = this.checker[5] = true;
                break;
            case 6:
                this.checker[6] = this.checker[7] = true;
                break;
            case 7:
                this.checker[8] = this.checker[9] = true;
                break;
            case 8:
                this.checker[10] = this.checker[11] = true;
                break;
            case 9:
                this.checker[12] = this.checker[13] = true;
                break;
            case 10:
                this.checker[14] = true;
                break;
            case 11:
                this.checker[14] = this.checker[15] = true;
                break;
            case 12:
                this.checker[14] = this.checker[16] = true;
        } // 해당 시(number)
    }

    public void checkMinute(Time time) {
        this.checker[35] = true; // '분'
        switch (time.minute % 10) {
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
        if (time.minute > 9) {
            this.checker[23] = true;
            switch (time.minute / 10) {
                case 2:
                    this.checker[19] = true;
                    break;
                case 3:
                    this.checker[20] = true;
                    break;
                case 4:
                    this.checker[21] = true;
                    break;
                case 5:
                    this.checker[22] = true;
                    break;

            }
        }
    }

    public Checker(Time time) {
        if (time.hour == 0 && time.minute == 0) {
            isMidDayOrNight(time);
            return;
        }
        checkHour(time);
        if (time.minute != 0) {
            checkMinute(time);
        }
    }
}

class HangulClock {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    char[] hangul = {'한', '두', '세', '네', '다', '섯', '여', '섯', '일', '곱', '여', '덟', '아', '홉', '열', '한', '두', '시',
            '자', '이', '삼', '사', '오', '십', '정', '일', '이', '삼', '사', '육', '오', '오', '칠', '팔', '구', '분'};

    public void displayHangulClock(Time time, Checker checker) {
        for (int i = 0; i < 36; i++) {
            if (i % 6 == 0) {
                System.out.println();
            } // new lines after six letters
            if (checker.checker[i]) { // print in red if the letter's checked according to the time
                System.out.print(ANSI_RED + hangul[i] + " " + ANSI_RESET);
                continue;
            }
            System.out.print(hangul[i] + " "); // print letters
        }
    }
}

public class Mission5_HangulClock {

    public static void main(String[] args) {
        Time time = new Time();
        Checker checker = new Checker(time);
        HangulClock hangulClock = new HangulClock();

        hangulClock.displayHangulClock(time, checker);
    }
}

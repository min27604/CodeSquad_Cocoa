package Day11;

class HangulClock {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    char[] hangul = {'한', '두', '세', '네', '다', '섯', '여', '섯', '일', '곱', '여', '덟', '아', '홉', '열', '한', '두', '시',
            '자', '이', '삼', '사', '오', '십', '정', '일', '이', '삼', '사', '육', '오', '오', '칠', '팔', '구', '분'};

    public synchronized void displayHangulClock(Checker checker) {
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

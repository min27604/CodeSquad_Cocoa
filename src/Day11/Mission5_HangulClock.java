package Day11;

import java.time.LocalTime;

public class Mission5_HangulClock {
    static Time time;
    static Checker checker;

    public static void main(String[] args) {

        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                HangulClock hangulClock = new HangulClock();

                while (true) {
                    time = new Time();
                    checker = new Checker(time);

                    hangulClock.displayHangulClock(checker);

                    double second = Double.parseDouble(String.valueOf(LocalTime.now()).split(":")[2]);
                    try {
                        Thread.sleep(2000);//60000 - (int) (second * 1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (int i=0; i<25; i++) System.out.println(); // clear console
                }
            }
        });

        th.start();
    }
}

package Day11;

public class ClockWithTimer extends Thread{
    Time time;
    Checker checker;
    HangulClock hangulClock = new HangulClock();
    double second;

    public double getSecond(Time time) {
        return Double.parseDouble(time.timeNow[2]); // timeNow is String value of time info
    }

    public void run() {
        while (true) {
            time = new Time();
            checker = new Checker(time);
            hangulClock = new HangulClock();

            hangulClock.displayHangulClock(checker);

            second = getSecond(time);

            try {
                Thread.sleep(60000 - (int) (second * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i=0; i<25; i++) System.out.println(); // clear console
        }
    }
}

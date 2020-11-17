package Day11;

import java.time.LocalTime;

public class Time {
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


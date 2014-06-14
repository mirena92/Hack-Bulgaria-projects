package com.hackbulgaria.corejava;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateLogger extends Logger {

    public DateLogger() {
        super.level = 100;
    }

    public DateLogger(int level) {
        super(level);
    }

    @Override
    public void log(String message) {
        if (!message.isEmpty()) {
            if (this.level >= 3) {
                System.out.print(String.format("%s | ", getTime()));
                System.out.println(String.format("3 => %s", message));
            }
        } else
            throw new EmptyMessageException();
    }

    @Override
    public void log(int level, String message) {
        if (!message.isEmpty()) {
            if (level > 0 && level <= this.level) {
                System.out.print(String.format("%s | ", getTime()));
                System.out.println(String.format("%d => %s", level, message));
            } else
                throw new InvalidLevelException();
        } else
            throw new EmptyMessageException();
    }

    public String getTime() {
        Calendar currentTime = Calendar.getInstance();
        currentTime.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd.MM.YYYY");

        return sdf.format(currentTime.getTime());
    }
}

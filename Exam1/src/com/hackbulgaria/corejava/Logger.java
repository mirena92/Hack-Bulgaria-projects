package com.hackbulgaria.corejava;

public class Logger {

    int level;

    public Logger() {
        level = 3;
    }

    public Logger(int level) {
        setLevel(level);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if (level > 0) {
            this.level = level;
        } else
            throw new InvalidLevelException();
    }

    public void log(int level, String message) {
        if (!message.isEmpty()) {
            if (level > 0 && level <= this.level) {
                System.out.println(String.format("%d => %s", level, message));
            } else
                throw new InvalidLevelException();
        } else
            throw new EmptyMessageException();
    }

    public void log(String message) {
        if (!message.isEmpty()) {
            if (this.level >= 3)
                System.out.println(String.format("3 => %s", message));
        } else
            throw new EmptyMessageException();
    }
}

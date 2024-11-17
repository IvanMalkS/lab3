package ru.malkov.time;

public class Time {
    final private long seconds;

    public Time(long seconds) {
        if (seconds < 0) {
            throw new IllegalArgumentException("Invalid input: time cannot be negative.");
        }
        this.seconds = seconds % (24 * 3600);
    }

    public Time(int hours, int minutes, int seconds) {
        if (hours < 0 || minutes < 0 || seconds < 0) {
            throw new IllegalArgumentException("Invalid input: time cannot be negative.");
        }
        if (minutes >= 60 || seconds >= 60) {
            throw new IllegalArgumentException("Invalid input: time values are out of range.");
        }
        long totalSeconds = (hours % 24) * 3600 + minutes * 60 + seconds;
        this.seconds = totalSeconds % (24 * 3600);
    }

    public int getHours() {
        return (int) (seconds / 3600);
    }

    public int getMinutes() {
        return (int) (seconds % 3600) / 60;
    }

    public int getSeconds() {
        return (int) seconds % 60;
    }

    @Override
    public String toString() {
        long hours = getHours();
        long minutes = getMinutes();
        long seconds = getSeconds();

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}

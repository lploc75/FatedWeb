package model;

public class LunarDate {
    private int day;
    private int month;
    private int year;
    private boolean isLeap;

    public LunarDate(int day, int month, int year, boolean isLeap) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.isLeap = isLeap;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public boolean isLeap() {
        return isLeap;
    }
}

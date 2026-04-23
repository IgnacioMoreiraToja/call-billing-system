package com.example;

import java.time.DayOfWeek;

public class LocalCall extends Call {
    private final DayOfWeek startDay;
    private final int startHour;

    public LocalCall(int durationMinutes, DayOfWeek startDay, int startHour) {
        super(durationMinutes);
        this.startDay = startDay;
        this.startHour = startHour;
    }

    public boolean isWeekday() {
        return startDay != DayOfWeek.SATURDAY && startDay != DayOfWeek.SUNDAY;
    }

    public boolean isPeakHour() {
        return startHour >= 8 && startHour < 20;
    }

    @Override
    public double calculateCost() {
        double ratePerMinute = (isWeekday() && isPeakHour()) ? 0.20 : 0.10;
        return getDurationMinutes() * ratePerMinute;
    }

    @Override
    public CallCategory getCategory() {
        return CallCategory.LOCAL;
    }
}

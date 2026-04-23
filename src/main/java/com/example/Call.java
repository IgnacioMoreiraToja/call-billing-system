package com.example;

public abstract class Call {
    private final int durationMinutes;

    public Call(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public abstract double calculateCost();

    public abstract CallCategory getCategory();
}
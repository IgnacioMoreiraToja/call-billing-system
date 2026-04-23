package com.example;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class PhoneBill {

    private final List<Call> calls;
    private final int basicFee;
    private final Month month;
    private final int year;

    public PhoneBill(int basicFee, Month month, int year) {
        this.basicFee = basicFee;
        this.month = month;
        this.year = year;
        this.calls = new ArrayList<>();
    }

    public void addCall(Call call) {
        calls.add(call);
    }

    public double calculateLocalCost() {
        double total = 0;
        for (Call call : calls) {
            if (call.getCategory() == CallCategory.LOCAL) {
                total += call.calculateCost();
            }
        }
        return total;
    }

    public double calculateNonLocalCost() {
        double total = 0;
        for (Call call : calls) {
            if (call.getCategory() == CallCategory.NON_LOCAL) {
                total += call.calculateCost();
            }
        }
        return total;
    }

    public double calculateTotalCost() {
        return basicFee + calculateLocalCost() + calculateNonLocalCost();
    }

    @Override
    public String toString() {
        return "===== PHONE BILL =====\n" +
            "Period: " + month + " " + year + "\n" +
            "Basic fee: " + basicFee + "\n" +
            "Local calls: " + calculateLocalCost() + "\n" +
            "National & International calls: " + calculateNonLocalCost() + "\n" +
            "----------------------\n" +
            "TOTAL: " + calculateTotalCost();
    }
}
package com.example;

import java.time.DayOfWeek;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        PhoneBill bill = new PhoneBill(5, Month.APRIL, 2026);

        bill.addCall(new LocalCall(10, DayOfWeek.MONDAY, 10));
        bill.addCall(new LocalCall(5, DayOfWeek.SUNDAY, 14));
        bill.addCall(new NationalCall(12, "Cordoba"));
        bill.addCall(new InternationalCall(7, "Spain"));

        System.out.println(bill);
    }
}

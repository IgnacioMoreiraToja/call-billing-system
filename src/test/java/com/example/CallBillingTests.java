package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.DayOfWeek;
import java.time.Month;

import org.junit.jupiter.api.Test;

class CallBillingTests {
    private static final double EPSILON = 0.000001;

    @Test
    void localCallUsesPeakWeekdayRate() {
        LocalCall call = new LocalCall(10, DayOfWeek.MONDAY, 9);

        assertEquals(2.0, call.calculateCost(), EPSILON);
        assertTrue(call.getCategory() == CallCategory.LOCAL);
    }

    @Test
    void localCallUsesOffPeakWeekendRate() {
        LocalCall call = new LocalCall(10, DayOfWeek.SATURDAY, 9);

        assertEquals(1.0, call.calculateCost(), EPSILON);
    }

    @Test
    void nationalCallUsesSpecificProvinceRate() {
        NationalCall call = new NationalCall(10, "Cordoba");

        assertEquals(3.0, call.calculateCost(), EPSILON);
        assertTrue(call.getCategory() == CallCategory.NON_LOCAL);
    }

    @Test
    void nationalCallUsesDefaultRateForUnknownProvince() {
        NationalCall call = new NationalCall(10, "Mendoza");

        assertEquals(4.0, call.calculateCost(), EPSILON);
    }

    @Test
    void internationalCallUsesSpecificCountryRate() {
        InternationalCall call = new InternationalCall(10, "Brazil");

        assertEquals(6.0, call.calculateCost(), EPSILON);
        assertTrue(call.getCategory() == CallCategory.NON_LOCAL);
    }

    @Test
    void internationalCallUsesDefaultRateForUnknownCountry() {
        InternationalCall call = new InternationalCall(10, "Italy");

        assertEquals(9.0, call.calculateCost(), EPSILON);
    }

    @Test
    void phoneBillCalculatesTotals() {
        PhoneBill bill = new PhoneBill(100, Month.APRIL, 2026);
        bill.addCall(new LocalCall(10, DayOfWeek.TUESDAY, 10));
        bill.addCall(new NationalCall(10, "Santa Fe"));
        bill.addCall(new InternationalCall(10, "USA"));

        assertEquals(2.0, bill.calculateLocalCost(), EPSILON);
        assertEquals(12.5, bill.calculateNonLocalCost(), EPSILON);
        assertEquals(114.5, bill.calculateTotalCost(), EPSILON);
    }
}
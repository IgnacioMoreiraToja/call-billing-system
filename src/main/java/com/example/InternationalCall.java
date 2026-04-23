package com.example;

import java.util.Map;

public class InternationalCall extends Call {

    private final String destinationCountry;

    private static final Map<String, Double> pricesByCountry = Map.of(
        "USA", 1.00,
        "Spain", 0.80,
        "Brazil", 0.60
    );

    public InternationalCall(int durationMinutes, String destinationCountry) {
        super(durationMinutes);
        this.destinationCountry = destinationCountry;
    }

    @Override
    public double calculateCost() {
        // Some countries have a differential price, every other country is 0.90
        double rate = pricesByCountry.getOrDefault(destinationCountry, 0.90);
        return getDurationMinutes() * rate;
    }

    @Override
    public CallCategory getCategory() {
        return CallCategory.NON_LOCAL;
    }
}
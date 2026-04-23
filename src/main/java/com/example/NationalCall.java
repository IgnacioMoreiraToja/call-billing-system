package com.example;

import java.util.Map;

public class NationalCall extends Call {
    private final String destinationProvince;

    private static final Map<String, Double> pricesByProvince = Map.of(
        "Cordoba", 0.30,
        "Santa Fe", 0.25,
        "Tierra del Fuego", 0.50
    );

    public NationalCall(int durationMinutes, String destinationProvince) {
        super(durationMinutes);
        this.destinationProvince = destinationProvince;
    }

    @Override
    public double calculateCost() {
        // Some provinces have a differential price, everywhere else is 0.40
        double rate = pricesByProvince.getOrDefault(destinationProvince, 0.40);     
        return getDurationMinutes() * rate;
    }

    @Override
    public CallCategory getCategory() {
        return CallCategory.NON_LOCAL;
    }
}

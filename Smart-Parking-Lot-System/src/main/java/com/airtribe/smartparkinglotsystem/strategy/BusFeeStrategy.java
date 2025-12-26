package com.airtribe.smartparkinglotsystem.strategy;

public class BusFeeStrategy implements FeeStrategy {
    // Hourly rate after first hour
    private static final double HOURLY_RATE = 80.0;

    @Override
    public double calculateFee(long parkingDurationInHours) {
        return (parkingDurationInHours * HOURLY_RATE);
    }
}

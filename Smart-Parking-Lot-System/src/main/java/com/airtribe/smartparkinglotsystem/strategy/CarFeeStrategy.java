package com.airtribe.smartparkinglotsystem.strategy;

public class CarFeeStrategy implements FeeStrategy {
    // Hourly rate after first hour
    private static final double HOURLY_RATE = 40.0;

    @Override
    public double calculateFee(long parkingDurationInHours) {
        return (parkingDurationInHours * HOURLY_RATE);
    }
}

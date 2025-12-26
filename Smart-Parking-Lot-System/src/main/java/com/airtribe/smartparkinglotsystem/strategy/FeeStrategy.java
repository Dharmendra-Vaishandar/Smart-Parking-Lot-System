package com.airtribe.smartparkinglotsystem.strategy;

public interface FeeStrategy {
    double calculateFee(long durationInHours);
}

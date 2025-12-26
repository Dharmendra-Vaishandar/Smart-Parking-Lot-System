package com.airtribe.smartparkinglotsystem.strategy;

import com.airtribe.smartparkinglotsystem.enums.VehicleType;
import com.airtribe.smartparkinglotsystem.exception.VehicleTypeNotSupportedException;

import java.util.HashMap;
import java.util.Map;

public class FeeCalculator {
    private final Map<VehicleType, FeeStrategy> strategies = new HashMap<>();

    public FeeCalculator() {
        strategies.put(VehicleType.CAR, new CarFeeStrategy());
        strategies.put(VehicleType.MOTORCYCLE, new MotorcycleFeeStrategy());
        strategies.put(VehicleType.BUS, new BusFeeStrategy());
    }

    public double calculateFee(VehicleType vehicleType, int hoursParked) throws VehicleTypeNotSupportedException {
        FeeStrategy strategy = strategies.get(vehicleType);
        if (strategy == null) {
            throw new VehicleTypeNotSupportedException("Unsupported vehicle type: " + vehicleType);
        }
        return strategy.calculateFee(hoursParked);
    }
}

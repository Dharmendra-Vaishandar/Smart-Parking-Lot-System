package com.airtribe.smartparkinglotsystem.entities;

import com.airtribe.smartparkinglotsystem.enums.VehicleType;

public class ParkingSpot {
    private final String spotId;
    private final int floorNumber;
    private final VehicleType supportedVehicleType;
    private boolean available;

    public ParkingSpot(String spotId, int floorNumber, VehicleType supportedVehicleType) {
        this.spotId = spotId;
        this.floorNumber = floorNumber;
        this.supportedVehicleType = supportedVehicleType;
    }

    public String getSpotId() {
        return spotId;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public VehicleType getSupportedVehicleType() {
        return supportedVehicleType;
    }

    public boolean isOccupied() {
        this.available = false;
        return false;
    }

    public void release() {
        this.available = true;
    }
}

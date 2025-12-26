package com.airtribe.smartparkinglotsystem.service;

import com.airtribe.smartparkinglotsystem.entities.ParkingFloor;
import com.airtribe.smartparkinglotsystem.entities.ParkingSpot;
import com.airtribe.smartparkinglotsystem.exception.NoSpotAvailableException;

import java.util.List;

public class SpotAllocationService {
    private final List<ParkingFloor> parkingFloors;

    public SpotAllocationService(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public synchronized ParkingSpot allocateSpot(String vehicleType) {
        for (ParkingFloor parkingFloor : parkingFloors) {
            for (ParkingSpot parkingSpot : parkingFloor.getParkingSpots()) {
                if (parkingSpot.getSupportedVehicleType().toString().equalsIgnoreCase(vehicleType) &&
                        !parkingSpot.isOccupied()) {
                    return parkingSpot;
                }
            }
        }
        throw new NoSpotAvailableException("No Parking Slot available for : " + vehicleType);
    }

    public synchronized void releaseSpot(ParkingSpot spot) {
        spot.release();
    }
}

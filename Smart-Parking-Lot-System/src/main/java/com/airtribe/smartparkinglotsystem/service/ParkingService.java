package com.airtribe.smartparkinglotsystem.service;

import com.airtribe.smartparkinglotsystem.entities.ParkingSpot;
import com.airtribe.smartparkinglotsystem.entities.ParkingTicket;
import com.airtribe.smartparkinglotsystem.entities.Vehicle;
import com.airtribe.smartparkinglotsystem.enums.VehicleType;
import com.airtribe.smartparkinglotsystem.exception.VehicleTypeNotSupportedException;
import com.airtribe.smartparkinglotsystem.strategy.FeeCalculator;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ParkingService {
    private final SpotAllocationService spotAllocationService;
    private final FeeCalculator feeCalculator;
    private Map<String, ParkingTicket> activeTickets = new HashMap<>();
    private Map<String, ParkingSpot> ticketSpotMap = new HashMap<>();

    public ParkingService(SpotAllocationService spotAllocationService, FeeCalculator feeCalculator) {
        this.spotAllocationService = spotAllocationService;
        this.feeCalculator = feeCalculator;
    }

    //Check-IN method
    public synchronized ParkingTicket checkIn(Vehicle vehicle) {
        ParkingSpot parkingSpot = spotAllocationService.allocateSpot(vehicle.getVehicleType().toString());
        String parkingTicketId = UUID.randomUUID().toString();
        ParkingTicket parkingTicket = new ParkingTicket(parkingTicketId, vehicle.getVehicleNumber(), parkingSpot.getSpotId());
        activeTickets.put(parkingTicketId, parkingTicket);
        ticketSpotMap.put(parkingTicketId, parkingSpot);
        return parkingTicket;
    }

    //Check-OUT method
    public synchronized ParkingTicket checkOut(String ticketId, VehicleType vehicleType) throws VehicleTypeNotSupportedException {
        ParkingTicket ticket = activeTickets.get(ticketId);
        ParkingSpot parkingSpot = ticketSpotMap.get(ticketId);
        ticket.setEntryTime(LocalDateTime.now()); // Set entry
        ticket.setExitTime(LocalDateTime.now());
        Long hours = Math.max(1, Duration.between(ticket.getEntryTime(), ticket.getExitTime()).toHours());
        double fee = feeCalculator.calculateFee(vehicleType, hours.intValue());
        ticket.setParkingFee(fee);
        spotAllocationService.releaseSpot(parkingSpot);
        activeTickets.remove(ticketId);
        ticketSpotMap.remove(ticketId);
        return ticket;
    }
}

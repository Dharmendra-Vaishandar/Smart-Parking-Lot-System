package com.airtribe.smartparkinglotsystem.entities;

import java.time.LocalDateTime;

public class ParkingTicket {
    private final String ticketId;
    private final String vehicleNumber;
    private final String spotId;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private Double parkingFee;


    public ParkingTicket(String ticketId, String vehicleNumber, String spotId) {
        this.ticketId = ticketId;
        this.vehicleNumber = vehicleNumber;
        this.spotId = spotId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getSpotId() {
        return spotId;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public Double getParkingFee() {
        return parkingFee;
    }
    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public void setParkingFee(Double parkingFee) {
        this.parkingFee = parkingFee;
    }
}

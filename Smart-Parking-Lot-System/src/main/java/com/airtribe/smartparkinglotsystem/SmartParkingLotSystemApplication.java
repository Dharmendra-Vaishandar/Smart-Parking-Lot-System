package com.airtribe.smartparkinglotsystem;

import com.airtribe.smartparkinglotsystem.entities.ParkingFloor;
import com.airtribe.smartparkinglotsystem.entities.ParkingSpot;
import com.airtribe.smartparkinglotsystem.entities.ParkingTicket;
import com.airtribe.smartparkinglotsystem.entities.Vehicle;
import com.airtribe.smartparkinglotsystem.enums.VehicleType;
import com.airtribe.smartparkinglotsystem.exception.VehicleTypeNotSupportedException;
import com.airtribe.smartparkinglotsystem.service.ParkingService;
import com.airtribe.smartparkinglotsystem.service.SpotAllocationService;
import com.airtribe.smartparkinglotsystem.strategy.FeeCalculator;

import java.util.List;

public class SmartParkingLotSystemApplication {

    public static void main(String[] args) throws InterruptedException, VehicleTypeNotSupportedException {
        ParkingSpot p1 = new ParkingSpot("F1-MOTOR1", 1, VehicleType.MOTORCYCLE);
        ParkingSpot p2 = new ParkingSpot("F1-CAR1", 1, VehicleType.CAR);
        ParkingSpot p3 = new ParkingSpot("F1-BUS1", 1, VehicleType.BUS);

        ParkingFloor floor1 = new ParkingFloor(1, List.of(p1, p2, p3));

        SpotAllocationService allocationService1 = new SpotAllocationService(List.of(floor1));

        ParkingService parkingService1 = new ParkingService(allocationService1, new FeeCalculator());

        Vehicle car = new Vehicle("DL12CA1234", VehicleType.CAR);
        Vehicle motorCycle = new Vehicle("DL12MO1234", VehicleType.MOTORCYCLE);
        Vehicle bus = new Vehicle("DL12BU1234", VehicleType.BUS);

        ParkingTicket ticketCar1 = parkingService1.checkIn(car);
        ParkingTicket ticketMotor1 = parkingService1.checkIn(motorCycle);
        ParkingTicket ticketBus1 = parkingService1.checkIn(bus);

        System.out.println("Smart Parking System Starting----- ");
        System.out.println("Ticket ID : " + ticketCar1.getTicketId() + " \nVehicle Number : " + ticketCar1.getVehicleNumber() +
                "\nFloor Number : " + floor1.getFloorNumber() + "\nSpot ID : " + ticketCar1.getSpotId());
        System.out.println("----------------------------------------------------");
        System.out.println("Ticket ID : " + ticketMotor1.getTicketId() + " \nVehicle Number : " + ticketMotor1.getVehicleNumber() +
                "\nFloor Number : " + floor1.getFloorNumber() + " \nSpot ID : " + ticketMotor1.getSpotId());
        System.out.println("----------------------------------------------------");
        System.out.println("Ticket ID : " + ticketBus1.getTicketId() + " \nVehicle Number : " + ticketBus1.getVehicleNumber() +
                "\nFloor Number : " + floor1.getFloorNumber() + " \nSpot ID : " + ticketBus1.getSpotId());

        Thread.sleep(2000);
        System.out.println("****************************************************");
        ParkingTicket exitTicketCar = parkingService1.checkOut(ticketCar1.getTicketId(), VehicleType.CAR);
        ParkingTicket exitTicketMotor = parkingService1.checkOut(ticketMotor1.getTicketId(), VehicleType.MOTORCYCLE);
        ParkingTicket exitTicketBus = parkingService1.checkOut(ticketBus1.getTicketId(), VehicleType.BUS);

        System.out.println("Checked In time : " + exitTicketCar.getExitTime() + "\nChecked Out time : " + exitTicketCar.getExitTime() +
                "\nFloor Number : " + p1.getFloorNumber() + " \nTicket ID : " + exitTicketCar.getTicketId());
        System.out.println(VehicleType.CAR + " Fee: ₹" + exitTicketCar.getParkingFee());
        System.out.println("----------------------------------------------------");
        System.out.println("Checked In time : " + exitTicketMotor.getExitTime() + "\nChecked Out time : " + exitTicketMotor.getExitTime() +
                "\nFloor Number : " + p1.getFloorNumber() + " \nTicket ID : " + exitTicketMotor.getTicketId());
        System.out.println(VehicleType.MOTORCYCLE + " Fee: ₹" + exitTicketMotor.getParkingFee());
        System.out.println("----------------------------------------------------");
        System.out.println("Checked In time : " + exitTicketBus.getExitTime() + "\nChecked Out time : " + exitTicketBus.getExitTime() +
                "\nFloor Number : " + p1.getFloorNumber() + " \nTicket ID : " + exitTicketBus.getTicketId());
        System.out.println(VehicleType.BUS + " Fee: ₹" + exitTicketBus.getParkingFee());

        System.out.println("Smart Parking System End----- ");
    }
}

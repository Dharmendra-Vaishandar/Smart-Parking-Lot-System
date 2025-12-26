package com.airtribe.smartparkinglotsystem;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SmartParkingLotSyemtemApplicationTests {

    @Test
    void testMainFlow() throws Exception {
        // Capture console output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Run main
        SmartParkingLotSystemApplication.main(new String[]{});

        // Restore original System.out
        System.setOut(originalOut);

        String output = outContent.toString();

        // Assert key outputs
        assertTrue(output.contains("Smart Parking System Starting"));
        assertTrue(output.contains("Ticket ID"));
        assertTrue(output.contains("Vehicle Number"));
        assertTrue(output.contains("Fee: ₹"));
        assertTrue(output.contains("Smart Parking System End"));
    }

}

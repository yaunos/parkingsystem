package com.parkit.parkingsystem.integration;

import com.parkit.parkingsystem.constants.ParkingType;
import com.parkit.parkingsystem.dao.ParkingSpotDAO;
import com.parkit.parkingsystem.dao.TicketDAO;
import com.parkit.parkingsystem.integration.config.DataBaseTestConfig;
import com.parkit.parkingsystem.integration.service.DataBasePrepareService;
import com.parkit.parkingsystem.model.Ticket;
import com.parkit.parkingsystem.service.ParkingService;
import com.parkit.parkingsystem.util.InputReaderUtil;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static junit.framework.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ParkingDataBaseIT {

    private static DataBaseTestConfig dataBaseTestConfig = new DataBaseTestConfig();
    private static ParkingSpotDAO parkingSpotDAO;
    private static TicketDAO ticketDAO;
    private static DataBasePrepareService dataBasePrepareService;

    @Mock
    private static InputReaderUtil inputReaderUtil;

    @BeforeAll
    public static void setUp() throws Exception{
        parkingSpotDAO = new ParkingSpotDAO();
        parkingSpotDAO.dataBaseConfig = dataBaseTestConfig;
        ticketDAO = new TicketDAO();
        ticketDAO.dataBaseConfig = dataBaseTestConfig;
        dataBasePrepareService = new DataBasePrepareService();
    }

    @BeforeEach
    public void setUpPerTest() throws Exception {
        when(inputReaderUtil.readSelection()).thenReturn(1);
        when(inputReaderUtil.readVehicleRegistrationNumber()).thenReturn("ABCDEF");
        dataBasePrepareService.clearDataBaseEntries();
    }

    @AfterAll
    public static void tearDown(){

    }

    @Test
    public void testParkingACar() throws Exception{

        ParkingService parkingService = new ParkingService(inputReaderUtil, parkingSpotDAO, ticketDAO);
        parkingService.processIncomingVehicle();
        //TODO: check that a ticket is actualy saved in DB and Parking table is updated with availability
        Ticket ticket = ticketDAO.getTicket(inputReaderUtil.readVehicleRegistrationNumber());
        assertNotEquals(null, ticket);
        int nextSlot = parkingSpotDAO.getNextAvailableSlot(ParkingType.CAR);
        assertNotNull(ticket.getId());
        assertNotEquals(nextSlot, ticket.getId());
    }

    @Test
    public void testParkingLotExit() throws Exception{
        testParkingACar();
        ParkingService parkingService = new ParkingService(inputReaderUtil, parkingSpotDAO, ticketDAO);
        parkingService.processExitingVehicle();
        //TODO: check that the fare generated and out time are populated correctly in the database
        Ticket ticket = ticketDAO.getTicket(inputReaderUtil.readVehicleRegistrationNumber());
        assertNotNull(ticket.getOutTime());
        assertEquals(true, ticket.getOutTime().after(ticket.getInTime()));
        assertEquals(0.0, ticket.getPrice());
    }

    @Test
    public void testParkingABike() throws Exception{

        ParkingService parkingService = new ParkingService(inputReaderUtil, parkingSpotDAO, ticketDAO);
        parkingService.processIncomingVehicle();
        Ticket ticket = ticketDAO.getTicket(inputReaderUtil.readVehicleRegistrationNumber());
        assertNotEquals(null, ticket);
        int nextSlot = parkingSpotDAO.getNextAvailableSlot(ParkingType.BIKE);
        assertNotNull(ticket.getId());
        assertNotEquals(nextSlot, ticket.getId());
    }

    @Test
    public void testVerifyVehicleRegistrationNumberForACar() throws Exception{

        ParkingService parkingService = new ParkingService(inputReaderUtil, parkingSpotDAO, ticketDAO);
        parkingService.processIncomingVehicle();
        Ticket ticket = ticketDAO.getTicket(inputReaderUtil.readVehicleRegistrationNumber());
        assertNotEquals("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAZZZZZZZZZZZZZZZZZZZ", ticket.getVehicleRegNumber());
    }

    @Test
    public void testVerifyParkingNumberForABike() throws Exception{

        ParkingService parkingService = new ParkingService(inputReaderUtil, parkingSpotDAO, ticketDAO);
        parkingService.processIncomingVehicle();
        Ticket ticket = ticketDAO.getTicket(inputReaderUtil.readVehicleRegistrationNumber());
        assertNotEquals(-1, ticket.getParkingSpot());
    }
}
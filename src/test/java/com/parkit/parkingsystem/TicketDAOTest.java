/*
package com.parkit.parkingsystem;



import com.parkit.parkingsystem.constants.ParkingType;
import com.parkit.parkingsystem.dao.TicketDAO;
import com.parkit.parkingsystem.integration.config.DataBaseTestConfig;
import com.parkit.parkingsystem.service.model.Ticket;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.Date;

import com.parkit.parkingsystem.service.model.ParkingSpot;

import static java.util.logging.Logging.logManager;


public class TicketDAOTest {

    private static TicketDAO ticketDAO;
    private static Ticket ticket;

    public static DataBaseTestConfig dataBaseTestConfig = new DataBaseTestConfig();
    Connection con = null;
    private static final Logger logger= logManager.getLogger("TicketDAOTest");

    @BeforeAll
    private static void setUp() throws Exception {
        ticketDAO = new TicketDAO();
        ticket = new Ticket();
        ticketDAO.dataBaseConfig = dataBaseTestConfig;
    }

    @BeforeEach
    public void setUpPertest() {
        try {
            con = dataBaseTestConfig.getConnection();
        } catch (Exception exception) {
            logger.error("Can't connect to the database", exception);

        }
    }

    @AfterEach
    private void tearDownPerTest() {
        dataBaseTestConfig.closeConnection(con);
    }
*/
    /* WRITE : On teste l'enregistrement d'un ticket dans la base */
/*
    @Test
    public void saveTicket() throws Exception {
        //GIVEN
        ParkingSpot parkingSpot = new ParkingSpot(1, ParkingType.CAR, false);
        Ticket ticket = new Ticket();
        ticket.setId(1);
        ticket.setPrice(3.0);
        ticket.setInTime(new Date(System.currentTimeMillis() - (120 * 60 * 1000)));
        ticket.setOutTime(new Date(System.currentTimeMillis()));
        ticket.setParkingSpot(parkingSpot);
        ticket.setVehicleRegNumber(REGISTRATION_NUMBER);

        //WHEN //ACT
        ticketDAO.saveTicket(ticket);

        //THEN
        // mock

        //AssertJ
        assertThat(ticketDAO.getTicket)

        //Junit
        assertEquals(ticketDAO.saveTicket(ticket));

    }

    /* READ : On teste la lecture d'un ticket dans la base */
/*
    @Test
    public void getTicket() throws exception {
        //GIVEN
        ParkingSpot parkingSpot = new ParkingSpot(1, ParkingType.CAR, false);
        Ticket ticket = new Ticket();
        ticket.getId();
        ticket.getPrice();
        ticket.getInTime();
        ticket.getOutTime(new Date(System.currentTimeMillis()));
        ticket.getParkingSpot(parkingSpot);
        ticket.getVehicleRegNumber(REGISTRATION_NUMBER);

        //WHEN
        ticketDAO.getTicket();

        //THEN
        assertThat(ticketDAO.get).
                assertThat(ticketDAO.saveTicket(ticket));

    }

    /* UPDATE: On teste la mise à jour d'un ticket dans la base */
/*
    @Test
    public void updateTicket() throws exception {
        //GIVEN
        ParkingSpot parkingSpot = new ParkingSpot(1, ParkingType.CAR, false);
        Ticket ticket = new Ticket();
        ticket.getId();
        ticket.getPrice();
       // On a déjà le temps d'arrivée // ticket.getInTime();
        ticket.getOutTime(new Date(System.currentTimeMillis()));
        ticket.getParkingSpot(parkingSpot);
        ticket.getVehicleRegNumber(REGISTRATION_NUMBER);

        //WHEN
        ticketDAO.getTicket();

        //THEN
        assertThat(ticketDAO.get).
                assertThat(ticketDAO.saveTicket(ticket));

    }
}
    /*FIND avec la plaque d'immat */



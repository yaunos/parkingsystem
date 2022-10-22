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
/*
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
/*
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

@BeforeAll
private static void setUp() throws Exception {
        ticketDAO = new TicketDAO();
        ticket = new Ticket();
        ticketDAO.dataBaseConfig = dataBaseTestConfig;
        }

@Test void testSaveTicket()
//GIVEN

//WHEN

//THEN

@Test void getTicketTest()
//GIVEN

//WHEN

//THEN

@Test void updateTicketTest()
//GIVEN

//WHEN


//THEN

/*FIND avec la plaque d'immat */

/*
@Test void checkTicketExistsTest()

//GIVEN

//WHEN

//THEN

*/

/*
import com.parkit.parkingsystem.dao.TicketDAO;
import com.parkit.parkingsystem.model.Ticket;
import junit.framework.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TicketDA0Test {

    @BeforeAll
    private static void setUp() throws Exception {
        ticketDAO = new TicketDAO();
        ticket = new Ticket();
        ticketDAO.dataBaseConfig = dataBaseConfig;
    }

    @BeforeEach
    public void setUpPertest() {
        try {
            Connection con = null;
            con = dataBaseConfig.getConnection();
        } catch (Exception exception) {
            logger.error("Can't connect to the database", exception);

        }
    }

    @AfterEach
    private void tearDownPerTest() {
       //dataBaseTestConfig.closeConnection(con);
        dataBaseConfig.closeConnection(con);
    }

    // ?
    private static TicketDAOTest ticketDAOTest;
    // ok
    private Ticket ticket;

    @Test
    public void saveTicketTest extends TestCase{
        //GIVEN
        TicketDA0 td = new TicketDA0();

        //WHEN
        td.saveTicket(ticket);
        //THEN

        Assert.assertEquals(ticket.getParkingSpot(), PARKING_NUMBER);
        Assert.assertEquals(ticket.getVehicleRegNumber(), VEHICLE_REG_NUMBER);
        Assert.assertEquals(ticket.getPrice(), PRICE);
        Assert.assertEquals(ticket.getInTime(), IN_TIME);
        Assert.assertEquals(ticket.getOutTime(), OUT_TIME);
        }

    @Test
    public void updateTicketTest extends TestCase{
        //GIVEN
        TicketDA0 td = new TicketDA0();

        //WHEN
        td.updateTicket(ticket);
        //THEN

        Assert.assertEquals(ticket.getParkingSpot(), PARKING_NUMBER);
        Assert.assertEquals(ticket.getVehicleRegNumber(), VEHICLE_REG_NUMBER);
        Assert.assertEquals(ticket.getPrice(), PRICE);
        Assert.assertEquals(ticket.getInTime(), IN_TIME);
        Assert.assertEquals(ticket.getOutTime(), OUT_TIME);
    }

    @Test
    public void checkTicketExistsTest extends TestCase{
        //GIVEN
        TicketDA0 td = new TicketDA0();

        //WHEN
        td.checkTicketExists();
        //THEN


        Assert.assertEquals(ticket.getVehicleRegNumber(), VEHICLE_REG_NUMBER);

    }
}
*/
package com.parkit.parkingsystem;

import com.parkit.parkingsystem.config.DataBaseConfig;
import com.parkit.parkingsystem.constants.DBConstants;
import com.parkit.parkingsystem.constants.ParkingType;
import com.parkit.parkingsystem.dao.TicketDAO;
import com.parkit.parkingsystem.model.ParkingSpot;
import com.parkit.parkingsystem.model.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.*;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;

public class TicketDAOTest {

    @InjectMocks
    private TicketDAO ticketDAO;
    @Mock
    private static PreparedStatement ps;
    @Mock
    private static Connection con;
    @Mock
    DataBaseConfig dataBaseConfig;
    @Mock
    private ResultSet result;
    private Ticket ticket;


    @BeforeEach
    public void init() throws SQLException, ClassNotFoundException {
        MockitoAnnotations.initMocks(this);
        Mockito.when(con.createStatement()).thenReturn(ps);
        Mockito.when(dataBaseConfig.getConnection()).thenReturn(con);


        ticket = new Ticket();
        ParkingSpot parkingSpot = new ParkingSpot(1, ParkingType.CAR, false);
        ticket.setParkingSpot(parkingSpot);
        ticket.setVehicleRegNumber("ABCDEF");
        ticket.setPrice(0);
        Date inTime = new Date();
        ticket.setInTime(inTime);
        ticket.setOutTime(null);
    }

    @Test
    public void saveTicketTest() throws SQLException {
        Mockito.when(con.prepareStatement(DBConstants.SAVE_TICKET)).thenReturn(ps);

        ticketDAO.saveTicket(ticket);
        Mockito.verify(ps, times(1)).execute();
    }

    @Test
    public void getTicketTest() throws SQLException {
        Mockito.when(con.prepareStatement(DBConstants.GET_TICKET)).thenReturn(ps);
        Mockito.when(ps.executeQuery()).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true);

        Mockito.when(result.getInt(1)).thenReturn(1);
        Mockito.when(result.getInt(2)).thenReturn(0);
        Mockito.when(result.getDouble(3)).thenReturn(0.0);
        Date inTime = new Date();
        Timestamp inTimeStamp = new Timestamp(inTime.getTime());
        Mockito.when(result.getTimestamp(4)).thenReturn(inTimeStamp);
        Mockito.when(result.getTimestamp(5)).thenReturn(inTimeStamp);
        Mockito.when(result.getString(6)).thenReturn( "CAR");

        Ticket ticket = ticketDAO.getTicket("ABCDEF");
        assertNotNull(ticket);
        assertNotNull(ticket.getInTime());
        Mockito.verify(ps).executeQuery();
    }


    @Test
    public void checkTicketExistsTest() throws SQLException {
        Mockito.when(con.prepareStatement(DBConstants.CHECK_TICKET_EXISTS)).thenReturn(ps);
        Mockito.when(ps.executeQuery()).thenReturn(result);
        Mockito.when(result.next()).thenReturn(true);

        Mockito.when(result.getInt(1)).thenReturn(2);

        boolean IsRecurrent = false;
        IsRecurrent = ticketDAO.checkTicketExists("ABCDEF");
        assertEquals(true,IsRecurrent);
        Mockito.verify(ps).executeQuery();
    }


    @Test
    public void updateTicketTest() throws SQLException {
        Mockito.when(con.prepareStatement(DBConstants.UPDATE_TICKET)).thenReturn(ps);

        Date inTime = new Date();
        ticket.setOutTime(inTime);

        ticketDAO.updateTicket(ticket);

        Mockito.verify(ps, times(1)).execute();
    }
}
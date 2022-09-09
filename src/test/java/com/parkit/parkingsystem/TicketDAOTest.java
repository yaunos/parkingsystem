package com.parkit.parkingsystem;

import com.parkit.parkingsystem.service.model.Ticket;
import net.bytebuddy.NamingStrategy;
import org.junit.jupiter.api.*;

public class TicketDAOTest {

    @BeforeEach

    @AfterEach

    @BeforeAll
    private void setUpPerTest(); {

    ticket =new Ticket();
    }

    @AfterAll

    @Test
    void saveTicketTest() {
        //GIVEN
        //SaveTicket saveticket = new saveTicket();
        Ticket ticket;
        ticket.setInTime(5:00);
        ticket.setOutTime(7:00);
        ticket.setParkingSpot(1);
        ticket.getPrice(1)

        //WHEN


        //THEN
        AssertEquals(7:00, Ticket.getOutime());
t
    }

   @Test
    void getTicketTest() {
        //GIVEN
       GetTicket getticket = new getTicket();

        //WHEN

        //THEN
       Assert.


    }
   @Test
    void updateTicketTest() {
        //GIVEN
       ... = new updateTicket();

        //WHEN

        //THEN
       Assert.

    }


}

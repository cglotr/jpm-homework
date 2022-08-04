package org.jpmorgan.managers;

import org.jpmorgan.beans.ShowBean;
import org.jpmorgan.beans.TicketBean;
import org.jpmorgan.models.Show;
import org.jpmorgan.models.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DisplayManagerImplTest {

    Show show;
    Ticket ticket;

    @BeforeEach
    void beforeEach() {
        show = new Show("SHOW1", 2, 3, 1);
        show.book("+6587503118", "A1");

        ticket = new Ticket("SHOW1", "A1", "+6587503118");
    }

    @Test
    void displayBookedShows() {
        String out = new DisplayManagerImpl().displayBookedShows(new ShowBean(show));

        assertTrue(out.contains("٩(◕‿◕｡)۶ · Showing booked seats for [SHOW1]:"));
        assertTrue(out.contains("* SHOW1"));
    }

    @Test
    void displaySeatNumbers() {
        String out = new DisplayManagerImpl().displaySeatNumbers(Arrays.asList("A1", "A2"));
        assertTrue(out.contains("٩(◕‿◕｡)۶ · Available seats:"));
        assertTrue(out.contains("* A1"));
        assertTrue(out.contains("* A2"));
    }

    @Test
    void displayBookingSuccess() {
        String out = new DisplayManagerImpl().displayBookingSuccess(List.of(
                new TicketBean(ticket),
                new TicketBean(ticket)
        ));

        assertTrue(out.contains("٩(◕‿◕｡)۶ · Successfully booked [2] seats!:"));
        assertTrue(out.contains("* SHOW1:A1"));
        assertTrue(out.contains("* SHOW1:A1"));
    }

    @Test
    void displaySetupSuccess() {
        String out = new DisplayManagerImpl().displaySetupSuccess(new ShowBean(new Show("SHOW1", 2, 3, 1)));
        assertEquals("٩(◕‿◕｡)۶ · Successfully setup a new show [SHOW1]!\n", out);
    }

    @Test
    void displayCancelledBooking() {
        String out = new DisplayManagerImpl().displayCancelledBooking();
        assertEquals("٩(◕‿◕｡)۶ · Successfully cancelled the booking!\n", out);
    }
}

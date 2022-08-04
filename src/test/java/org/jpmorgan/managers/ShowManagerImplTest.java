package org.jpmorgan.managers;

import org.jpmorgan.Result;
import org.jpmorgan.beans.ShowBean;
import org.jpmorgan.beans.TicketBean;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShowManagerImplTest {
    private ShowManagerImpl showManager;

    @BeforeEach
    void setUp() {
        showManager = new ShowManagerImpl();
    }

    @Test
    void givenSetup_thenBook_thenCancel() {
        showManager.setup("SHOW1", 3, 10, 1);
        Result<ShowBean> viewResult = showManager.view("SHOW1");

        assertNotNull(viewResult);
        assertEquals("SHOW1", viewResult.data().getShowNumber());
        assertEquals(0, viewResult.data().getTickets().size());

        Result<List<String>> availabilityResult = showManager.availability("SHOW1");

        assertNotNull(availabilityResult);
        assertEquals(30, availabilityResult.data().size());

        Result<List<TicketBean>> bookResult = showManager.book("SHOW1", "+6587503118", Arrays.asList("A1", "A2", "A3"));
        TicketBean a1Ticket = bookResult.data().get(0);
        TicketBean a2Ticket = bookResult.data().get(1);
        TicketBean a3Ticket = bookResult.data().get(2);

        assertFalse(bookResult.isError());
        assertEquals(3, bookResult.data().size());
        assertEquals("A1", a1Ticket.getSeatNumber());
        assertEquals("A2", a2Ticket.getSeatNumber());
        assertEquals("A3", a3Ticket.getSeatNumber());

        bookResult = showManager.book("SHOW1", "+6587503118", Arrays.asList("A3", "A4", "A5"));

        assertTrue(bookResult.isError());
        assertEquals("you have already booked before", bookResult.error());

        Result<Boolean> cancelResult = showManager.cancel(a3Ticket.getTicketNumber(), "+6587503118");

        assertNotNull(cancelResult.data());
        assertTrue(cancelResult.data());

        viewResult = showManager.view("SHOW1");

        assertNotNull(viewResult);
        assertEquals("SHOW1", viewResult.data().getShowNumber());
        assertEquals(2, viewResult.data().getTickets().size());

        availabilityResult = showManager.availability("SHOW1");

        assertNotNull(availabilityResult);
        assertEquals(28, availabilityResult.data().size());

        showManager.cancel(a1Ticket.getTicketNumber(), "+6587503118");
        showManager.cancel(a2Ticket.getTicketNumber(), "+6587503118");
        viewResult = showManager.view("SHOW1");

        assertNotNull(viewResult);
        assertEquals("SHOW1", viewResult.data().getShowNumber());
        assertEquals(0, viewResult.data().getTickets().size());

        bookResult = showManager.book("SHOW1", "+6587503118", Arrays.asList("A3", "A4"));

        assertFalse(bookResult.isError());
        assertEquals(2, bookResult.data().size());
    }
}

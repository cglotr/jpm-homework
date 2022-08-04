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

        assertFalse(bookResult.isError());
        assertEquals(3, bookResult.data().size());
        assertEquals("A1", bookResult.data().get(0).getSeatNumber());
        assertEquals("A2", bookResult.data().get(1).getSeatNumber());
        assertEquals("A3", bookResult.data().get(2).getSeatNumber());

        bookResult = showManager.book("SHOW1", "+6587503118", Arrays.asList("A3", "A4", "A5"));

        assertTrue(bookResult.isError());
        assertEquals("some seats are already booked", bookResult.error());

        bookResult = showManager.book("SHOW1", "+6587503118", Arrays.asList("A4", "A5"));

        assertFalse(bookResult.isError());
        assertEquals(2, bookResult.data().size());
        assertEquals("A4", bookResult.data().get(0).getSeatNumber());
        assertEquals("A5", bookResult.data().get(1).getSeatNumber());

        Result<Boolean> cancelResult = showManager.cancel(bookResult.data().get(1).getTicketNumber(), "+6587503118");

        assertNotNull(cancelResult.data());
        assertTrue(cancelResult.data());

        viewResult = showManager.view("SHOW1");

        assertNotNull(viewResult);
        assertEquals("SHOW1", viewResult.data().getShowNumber());
        assertEquals(4, viewResult.data().getTickets().size());

        availabilityResult = showManager.availability("SHOW1");

        assertNotNull(availabilityResult);
        assertEquals(26, availabilityResult.data().size());
    }
}

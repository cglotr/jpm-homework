package org.jpmorgan.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TicketUtilTest {
    @Test
    public void getSeatNumberFromRowCol() {
        assertEquals("A1", TicketUtil.getSeatNumberFromRowCol(0, 0));
        assertEquals("Z1", TicketUtil.getSeatNumberFromRowCol(25, 0));
        assertEquals("AB1", TicketUtil.getSeatNumberFromRowCol(27, 0));
        assertEquals("AB100", TicketUtil.getSeatNumberFromRowCol(27, 99));

        int[] rowCol = TicketUtil.parseRowColFromTicketSeat("ABC1773");

        assertNotNull(rowCol);
        assertEquals("ABC1773", TicketUtil.getSeatNumberFromRowCol(rowCol[0] - 1, rowCol[1] - 1));
    }

    @Test
    public void parseSeatFromTicketNumber() {
        assertEquals("A4", TicketUtil.parseSeatFromTicketNumber("SHOW1:A4:1659571173"));
    }

    @Test
    public void parseShowNumberFromTicketNumber() {
        assertEquals("SHOW1", TicketUtil.parseShowNumberFromTicketNumber("SHOW1:A4:1659571173"));
    }

    @Test
    public void parseRowColFromTicketSeat() {
        int[] rowCol = TicketUtil.parseRowColFromTicketSeat("AB34");

        assertNotNull(rowCol);
        assertEquals(28, rowCol[0]);
        assertEquals(34, rowCol[1]);
    }

    @Test
    public void alphaToNum() {
        assertEquals(1, TicketUtil.alphaToNum("A"));
        assertEquals(26, TicketUtil.alphaToNum("Z"));
        assertEquals(27, TicketUtil.alphaToNum("AA"));
        assertEquals(28, TicketUtil.alphaToNum("AB"));
        assertEquals(52, TicketUtil.alphaToNum("AZ"));
        assertEquals(53, TicketUtil.alphaToNum("BA"));
    }
}

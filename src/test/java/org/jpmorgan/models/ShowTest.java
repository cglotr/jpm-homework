package org.jpmorgan.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ShowTest {
    @Test
    public void getRowFromSeating_valid() {
        assertEquals(0, Show.getRowFromSeat("A1"));
        assertEquals(25, Show.getRowFromSeat("Z1"));
    }

    @Test
    public void getRowFromSeating_invalid() {
        assertEquals(-1, Show.getRowFromSeat(""));
        assertEquals(-1, Show.getRowFromSeat("A"));
    }

    @Test
    public void getColFromSeating_valid() {
        assertEquals(0, Show.getColFromSeat("Z1"));
        assertEquals(98, Show.getColFromSeat("Z99"));
    }

    @Test
    public void getColFromSeating_invalid() {
        assertEquals(-1, Show.getColFromSeat(""));
        assertEquals(-1, Show.getColFromSeat("A"));
    }
}

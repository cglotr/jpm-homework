package org.jpmorgan.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SetupCommandTest {
    @Test
    public void setupCommand() {
        SetupCommand setupCommand = new SetupCommand("Setup SHOW1 2 3 1");

        assertTrue(setupCommand.isValid());
        assertEquals("SHOW1", setupCommand.getShowNumber());
        assertEquals(2, setupCommand.getNumberOfRows());
        assertEquals(3, setupCommand.getNumberOfSeatsPerRow());
        assertEquals(1, setupCommand.getCancellationWindowInMinutes());
    }

    @Test
    public void availabilityCommandInvalid() {
        SetupCommand setupCommand = new SetupCommand("Setup");

        assertFalse(setupCommand.isValid());
    }
}

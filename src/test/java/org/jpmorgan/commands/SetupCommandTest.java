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
        assertFalse(new SetupCommand("Setup").isValid());
        assertFalse(new SetupCommand("Setup SHOW1 0 1 0").isValid());
        assertFalse(new SetupCommand("Setup SHOW1 1 0 0").isValid());
        assertFalse(new SetupCommand("Setup SHOW1 27 1 0").isValid());
        assertFalse(new SetupCommand("Setup SHOW1 1 27 0").isValid());
    }
}

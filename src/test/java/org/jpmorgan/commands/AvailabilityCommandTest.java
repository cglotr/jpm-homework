package org.jpmorgan.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AvailabilityCommandTest {
    @Test
    public void availabilityCommand() {
        AvailabilityCommand availabilityCommand = new AvailabilityCommand("Availability SHOW1");

        assertTrue(availabilityCommand.isValid());
        assertEquals("SHOW1", availabilityCommand.getShowNumber());
    }

    @Test
    public void availabilityCommandInvalid() {
        AvailabilityCommand availabilityCommand = new AvailabilityCommand("Availability");

        assertFalse(availabilityCommand.isValid());
    }
}

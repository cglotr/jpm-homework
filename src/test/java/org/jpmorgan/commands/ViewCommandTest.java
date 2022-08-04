package org.jpmorgan.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ViewCommandTest {
    @Test
    public void viewCommand() {
        ViewCommand viewCommand = new ViewCommand("View SHOW1");

        assertTrue(viewCommand.isValid());
        assertEquals("SHOW1", viewCommand.getShowNumber());
    }

    @Test
    public void availabilityCommandInvalid() {
        ViewCommand viewCommand = new ViewCommand("View");

        assertFalse(viewCommand.isValid());
    }
}

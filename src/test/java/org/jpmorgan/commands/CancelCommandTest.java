package org.jpmorgan.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CancelCommandTest {
    @Test
    public void cancelCommand() {
        CancelCommand cancelCommand = new CancelCommand("Cancel SHOW1:A2:1659584952 +6587503118");

        assertTrue(cancelCommand.isValid());
        assertEquals("SHOW1:A2:1659584952", cancelCommand.getTicketNumber());
        assertEquals("+6587503118", cancelCommand.getPhoneNumber());
    }

    @Test
    public void cancelCommandInvalid() {
        CancelCommand cancelCommand = new CancelCommand("Cancel");

        assertFalse(cancelCommand.isValid());
    }
}

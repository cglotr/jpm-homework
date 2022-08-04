package org.jpmorgan.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookCommandTest {
    @Test
    public void bookCommand() {
        BookCommand bookCommand = new BookCommand("Book SHOW1 +6587503118 A1,A2");

        assertTrue(bookCommand.isValid());
        assertEquals("SHOW1", bookCommand.getShowNumber());
        assertEquals("+6587503118", bookCommand.getPhoneNumber());
        assertEquals("[A1, A2]", bookCommand.getSeats().toString());
    }

    @Test
    public void bookCommandInvalid() {
        BookCommand bookCommand = new BookCommand("Book");

        assertFalse(bookCommand.isValid());
    }
}

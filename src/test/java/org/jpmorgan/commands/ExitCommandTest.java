package org.jpmorgan.commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ExitCommandTest {
    @Test
    public void exitCommand() {
        assertTrue(new ExitCommand().isValid());
    }
}

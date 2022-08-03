package org.jpmorgan.utils;

import org.jpmorgan.enums.Command;
import org.junit.jupiter.api.Test;

import static org.jpmorgan.enums.Command.SETUP;
import static org.junit.jupiter.api.Assertions.*;

class InputUtilTest {
    @Test
    public void TestParseCommandType() {
        Command actual = InputUtil.parseCommandType("Setup #SHOW1 10 10 5");
        assertEquals(SETUP, actual);
    }
}

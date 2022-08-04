package org.jpmorgan.utils;

import org.jpmorgan.enums.Command;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.jpmorgan.enums.Command.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InputUtilTest {
    @Test
    public void parseCommandType() {
        TestCase[] tests = {
                new TestCase("Setup", SETUP),
                new TestCase("View", VIEW),
                new TestCase("Availability", AVAILABILITY),
                new TestCase("Book", BOOK),
                new TestCase("Cancel", CANCEL),
                new TestCase("Exit", EXIT),
                new TestCase("Login", LOGIN),
                new TestCase("Logout", LOGOUT),
                new TestCase("", INVALID),
                new TestCase("?", INVALID)
        };
        Arrays.stream(tests).forEach(testCase -> {
            assertEquals(testCase.expected, InputUtil.parseCommandType(testCase.input));
        });
    }

    private static class TestCase {
        public String input;
        public Command expected;

        TestCase(String input, Command expected) {
            this.input = input;
            this.expected = expected;
        }
    }
}

package org.jpmorgan.utils;

import org.jpmorgan.enums.Command;

public class InputUtil {
    public static Command parseCommandType(String input) {
        if (input == null) {
            return Command.INVALID;
        }

        String[] words = input.split(" ");

        if (words.length < 1) {
            return Command.INVALID;
        }

        return switch (words[0].toLowerCase()) {
            case "setup" -> Command.SETUP;
            case "view" -> Command.VIEW;
            case "availability" -> Command.AVAILABILITY;
            case "book" -> Command.BOOK;
            case "cancel" -> Command.CANCEL;
            case "exit" -> Command.EXIT;
            case "login" -> Command.LOGIN;
            case "logout" -> Command.LOGOUT;
            default -> Command.INVALID;
        };
    }
}

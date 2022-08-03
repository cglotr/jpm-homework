package org.jpmorgan.commands;

import java.util.List;

public class BookCommand implements Command {
    private String showNumber;
    private String phoneNumber;
    private List<String> seats;

    public BookCommand(String raw) {
        String[] words = raw.split(" ");
        try {
            this.showNumber = words[1];
            this.phoneNumber = words[2];
            this.seats = List.of(words[3].split(","));
        } catch (Exception e) {
            System.out.printf("> Error parsing command\n");
        }
    }

    @Override
    public boolean isValid() {
        if (showNumber == null) {
            return false;
        }
        if (phoneNumber == null) {
            return false;
        }
        if (seats.size() <= 0) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("BookCommand {showNumber=%s, phoneNumber=%s, seats=%s}",
                showNumber,
                phoneNumber,
                seats.toString());
    }
}

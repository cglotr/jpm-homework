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
        } catch (Exception ignored) {
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
        return seats.size() > 0;
    }

    public String getShowNumber() {
        return showNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<String> getSeats() {
        return seats;
    }
}

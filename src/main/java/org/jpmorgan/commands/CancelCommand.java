package org.jpmorgan.commands;

public class CancelCommand implements Command {
    private String ticketNumber;
    private String phoneNumber;

    public CancelCommand(String raw) {
        String[] words = raw.split(" ");
        try {
            this.ticketNumber = words[1];
            this.phoneNumber = words[2];
        } catch (Exception ignored) {
        }
    }

    @Override
    public boolean isValid() {
        if (ticketNumber == null) {
            return false;
        }
        return phoneNumber != null;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

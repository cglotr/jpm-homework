package org.jpmorgan.commands;

public class CancelCommand implements Command {
    private String ticketNumber;
    private String phoneNumber;

    public CancelCommand(String raw) {
        String[] words = raw.split(" ");
        try {
            this.ticketNumber = words[1];
            this.phoneNumber = words[2];
        } catch (Exception e) {
            System.out.printf("> Error parsing command\n");
        }
    }

    @Override
    public boolean isValid() {
        if (ticketNumber == null) {
            return false;
        }
        if (phoneNumber == null) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("CancelCommand {ticketNumber=%s, phoneNumber=%s}", ticketNumber, phoneNumber);
    }
}

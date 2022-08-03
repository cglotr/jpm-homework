package org.jpmorgan.commands;

public class AvailabilityCommand implements Command {
    private String showNumber;

    public AvailabilityCommand(String raw) {
        String[] words = raw.split(" ");
        try {
            this.showNumber = words[1];
        } catch (Exception e) {
            System.out.printf("> Error parsing command\n");
        }
    }

    @Override
    public boolean isValid() {
        if (showNumber == null) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("AvailabilityCommand {showNumber=%s}", showNumber);
    }
}

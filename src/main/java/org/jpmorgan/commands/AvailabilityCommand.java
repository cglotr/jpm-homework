package org.jpmorgan.commands;

public class AvailabilityCommand implements Command {
    private String showNumber;

    public AvailabilityCommand(String raw) {
        String[] words = raw.split(" ");
        try {
            this.showNumber = words[1];
        } catch (Exception ignored) {
        }
    }

    @Override
    public boolean isValid() {
        return showNumber != null;
    }

    @Override
    public String toString() {
        return String.format("AvailabilityCommand {showNumber=%s}", showNumber);
    }

    public String getShowNumber() {
        return showNumber;
    }
}

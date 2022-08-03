package org.jpmorgan.commands;

public class SetupCommand implements Command {
    private String showNumber;
    private int numberOfRows;
    private int numberOfSeatsPerRow;
    private int cancellationWindowInMinutes;

    public SetupCommand(String raw) {
        String[] words = raw.split(" ");
        try {
            this.showNumber = words[1];
            this.numberOfRows = Integer.parseInt(words[2]);
            this.numberOfSeatsPerRow = Integer.parseInt(words[3]);
            this.cancellationWindowInMinutes = Integer.parseInt(words[4]);
        } catch (Exception e) {
            System.out.printf("> Error parsing command\n");
        }
    }

    @Override
    public boolean isValid() {
        if (showNumber == null) {
            return false;
        }
        if (numberOfRows <= 0) {
            return false;
        }
        if (numberOfSeatsPerRow <= 0) {
            return false;
        }
        if (cancellationWindowInMinutes < 0) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format(
                "SetupCommand {showNumber=%s, numberOfRows=%d, numberOfSeatsPerRow=%d, cancellationWindowInMinutes=%d}",
                showNumber,
                numberOfRows,
                numberOfSeatsPerRow,
                cancellationWindowInMinutes);
    }
}

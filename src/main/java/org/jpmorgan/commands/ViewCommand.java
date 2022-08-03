package org.jpmorgan.commands;

public class ViewCommand implements Command {
    private String showNumber;

    public ViewCommand(String raw) {
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
        return String.format("ViewCommand {showNumber=%s}", showNumber);
    }
}

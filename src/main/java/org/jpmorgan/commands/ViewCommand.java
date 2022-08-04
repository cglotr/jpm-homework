package org.jpmorgan.commands;

public class ViewCommand implements Command {
    private String showNumber;

    public ViewCommand(String raw) {
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
        return String.format("ViewCommand {showNumber=%s}", showNumber);
    }

    public String getShowNumber() {
        return showNumber;
    }
}

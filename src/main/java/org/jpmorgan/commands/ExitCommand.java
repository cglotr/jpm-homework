package org.jpmorgan.commands;

public class ExitCommand implements Command {
    @Override
    public boolean isValid() {
        return true;
    }
}

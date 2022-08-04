package org.jpmorgan.commands;

public class LogoutCommand implements Command {
    @Override
    public boolean isValid() {
        return true;
    }
}

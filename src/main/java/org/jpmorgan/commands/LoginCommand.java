package org.jpmorgan.commands;

public class LoginCommand implements Command {
    @Override
    public boolean isValid() {
        return true;
    }
}

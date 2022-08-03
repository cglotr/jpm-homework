package org.jpmorgan;

import org.jpmorgan.enums.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.jpmorgan.commands.*;
import org.jpmorgan.utils.InputUtil;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.printf("> Welcome to JPM Show Booker!\n");

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = bf.readLine();
            Command command = InputUtil.parseCommandType(line);

            switch (command) {
                case SETUP: {
                    SetupCommand setupCommand = new SetupCommand(line);
                    System.out.printf("> %s\n", setupCommand.toString());
                    break;
                }
                case VIEW: {
                    ViewCommand viewCommand = new ViewCommand(line);
                    System.out.printf("> %s\n", viewCommand.toString());
                    break;
                }
                case AVAILABILITY: {
                    AvailabilityCommand availabilityCommand = new AvailabilityCommand(line);
                    System.out.printf("> %s\n", availabilityCommand.toString());
                    break;
                }
                case BOOK: {
                    BookCommand bookCommand = new BookCommand(line);
                    System.out.printf("> %s\n", bookCommand.toString());
                    break;
                }
                case CANCEL: {
                    CancelCommand cancelCommand = new CancelCommand(line);
                    System.out.printf("> %s\n", cancelCommand.toString());
                    break;
                }
                case EXIT: {
                    System.out.printf("> Exiting...\n");
                    System.out.printf("> Thanks for using JPM Show Booker. Bye!\n");
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.printf("> Invalid command!\n");
                    break;
                }
            }
        }
    }
}

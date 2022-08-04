package org.jpmorgan;

import org.jpmorgan.beans.ShowBean;
import org.jpmorgan.beans.TicketBean;
import org.jpmorgan.commands.*;
import org.jpmorgan.enums.Command;
import org.jpmorgan.managers.DisplayManager;
import org.jpmorgan.managers.DisplayManagerImpl;
import org.jpmorgan.managers.ShowManager;
import org.jpmorgan.managers.ShowManagerImpl;
import org.jpmorgan.utils.InputUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.print("٩(◕‿◕｡)۶ · Welcome to JPM Show Booker! · ٩(◕‿◕｡)۶\n");

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ShowManager showManager = new ShowManagerImpl();
        DisplayManager displayManager = new DisplayManagerImpl();

        while (true) {
            System.out.print("> ");

            String line = bf.readLine();
            Command command = InputUtil.parseCommandType(line);

            switch (command) {
                case SETUP -> {
                    SetupCommand setupCommand = new SetupCommand(line);

                    Result<ShowBean> setupResult = showManager.setup(
                            setupCommand.getShowNumber(),
                            setupCommand.getNumberOfRows(),
                            setupCommand.getNumberOfSeatsPerRow(),
                            setupCommand.getCancellationWindowInMinutes()
                    );

                    if (setupResult.isError()) {
                        printError(setupResult.error());
                        break;
                    }

                    displayManager.displaySetupSuccess(setupResult.data());
                }
                case VIEW -> {
                    ViewCommand viewCommand = new ViewCommand(line);

                    Result<ShowBean> showBeanResult = showManager.view(viewCommand.getShowNumber());

                    if (showBeanResult.isError()) {
                        printError(showBeanResult.error());
                        break;
                    }

                    displayManager.displayBookedShows(showBeanResult.data());
                }
                case AVAILABILITY -> {
                    AvailabilityCommand availabilityCommand = new AvailabilityCommand(line);

                    Result<List<String>> availabilityResult = showManager.availability(availabilityCommand.getShowNumber());

                    if (availabilityResult.isError()) {
                        printError(availabilityResult.error());
                        break;
                    }

                    displayManager.displaySeatNumbers(availabilityResult.data());
                }
                case BOOK -> {
                    BookCommand bookCommand = new BookCommand(line);

                    Result<List<TicketBean>> bookResult = showManager.book(
                            bookCommand.getShowNumber(),
                            bookCommand.getPhoneNumber(),
                            bookCommand.getSeats());

                    if (bookResult.isError()) {
                        printError(bookResult.error());
                        break;
                    }

                    displayManager.displayBookingSuccess(bookResult.data());
                }
                case CANCEL -> {
                    CancelCommand cancelCommand = new CancelCommand(line);

                    Result<Boolean> cancelResult = showManager.cancel(cancelCommand.getTicketNumber(), cancelCommand.getPhoneNumber());

                    if (cancelResult.isError()) {
                        printError(cancelResult.error());
                        break;
                    }

                    displayManager.displayCancelledBooking();
                }
                case EXIT -> {
                    System.out.print("Exiting...\n");
                    System.out.print("Thanks for using JPM Show Booker. Bye!\n");
                    System.exit(0);
                }
                default -> {
                    printError("invalid command");
                }
            }
        }
    }

    private static void printError(String error) {
        System.out.printf("(๑◕︵◕๑) · ERROR: %s\n", error);
    }
}

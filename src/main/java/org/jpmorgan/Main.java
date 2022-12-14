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
    private static boolean isAdmin = false;

    public static void main(String[] args) throws IOException {
        System.out.print("٩(◕‿◕｡)۶ · Welcome to JPM Show Booker! · ٩(◕‿◕｡)۶\n");
        printUserType();

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        ShowManager showManager = new ShowManagerImpl();
        DisplayManager displayManager = new DisplayManagerImpl();

        while (true) {
            System.out.print("> ");

            String line = bf.readLine();
            Command command = InputUtil.parseCommandType(line);

            switch (command) {
                case SETUP -> {
                    if (!isAdmin) {
                        printError("Access denied!");
                        break;
                    }

                    SetupCommand setupCommand = new SetupCommand(line);

                    if (!setupCommand.isValid()) {
                        printError("Invalid setup arguments!");
                        break;
                    }

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

                    System.out.print(displayManager.displaySetupSuccess(setupResult.data()));
                }
                case VIEW -> {
                    if (!isAdmin) {
                        printError("Access denied!");
                        break;
                    }

                    ViewCommand viewCommand = new ViewCommand(line);

                    Result<ShowBean> showBeanResult = showManager.view(viewCommand.getShowNumber());

                    if (showBeanResult.isError()) {
                        printError(showBeanResult.error());
                        break;
                    }

                    System.out.print(displayManager.displayBookedShows(showBeanResult.data()));
                }
                case AVAILABILITY -> {
                    AvailabilityCommand availabilityCommand = new AvailabilityCommand(line);

                    Result<List<String>> availabilityResult = showManager.availability(availabilityCommand.getShowNumber());

                    if (availabilityResult.isError()) {
                        printError(availabilityResult.error());
                        break;
                    }

                    System.out.print(displayManager.displaySeatNumbers(availabilityResult.data()));
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

                    System.out.print(displayManager.displayBookingSuccess(bookResult.data()));
                }
                case CANCEL -> {
                    CancelCommand cancelCommand = new CancelCommand(line);

                    Result<Boolean> cancelResult = showManager.cancel(cancelCommand.getTicketNumber(), cancelCommand.getPhoneNumber());

                    if (cancelResult.isError()) {
                        printError(cancelResult.error());
                        break;
                    }

                    System.out.print(displayManager.displayCancelledBooking());
                }
                case LOGIN -> {
                    isAdmin = true;
                    printUserType();
                }
                case LOGOUT -> {
                    isAdmin = false;
                    printUserType();
                }
                case EXIT -> {
                    System.out.print("٩(◕‿◕｡)۶ · Exiting...\n");
                    System.out.print("٩(◕‿◕｡)۶ · Thanks for using JPM Show Booker. Bye! · ٩(◕‿◕｡)۶\n");
                    System.exit(0);
                }
                default -> {
                    printError("invalid command");
                }
            }
        }
    }

    private static void printError(String error) {
        System.out.printf("٩(× ×)۶ · ERROR: %s\n", error);
    }

    private static String userType() {
        return isAdmin ? "Admin" : "Buyer";
    }

    private static void printUserType() {
        System.out.printf("٩(◕‿◕｡)۶ · User type: %s\n", userType());
    }
}

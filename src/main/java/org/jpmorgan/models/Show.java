package org.jpmorgan.models;

import org.jpmorgan.utils.TicketUtil;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Show {
    private final String showNumber;
    private final Ticket[][] tickets;
    private final int cancelWindowInMinutes;

    public Show(String showNumber, int rows, int seatsPerRow, int cancelWindowInMinutes) {
        this.showNumber = showNumber;
        this.tickets = new Ticket[rows][seatsPerRow];
        this.cancelWindowInMinutes = cancelWindowInMinutes;
    }

    static int getRowFromSeat(String seat) {
        int[] rowCol = TicketUtil.parseRowColFromTicketSeat(seat);
        if (rowCol == null) {
            return -1;
        }
        return rowCol[0] - 1;
    }

    static int getColFromSeat(String seat) {
        int[] rowCol = TicketUtil.parseRowColFromTicketSeat(seat);
        if (rowCol == null) {
            return -1;
        }
        return rowCol[1] - 1;
    }

    public Ticket book(String phoneNumber, String seat) {
        if (isBooked(seat)) {
            return null;
        }
        int row = getRowFromSeat(seat);
        int col = getColFromSeat(seat);
        Ticket ticket = new Ticket(showNumber, seat, phoneNumber);
        tickets[row][col] = ticket;
        return ticket;
    }

    public boolean cancel(String seat) {
        for (int row = 0; row < getRows(); row++) {
            for (int col = 0; col < getCols(); col++) {
                Ticket ticket = tickets[row][col];
                if (ticket.getSeat().equals(seat) && canCancel(ticket.getBookingTime())) {
                    tickets[row][col] = null;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isBooked(String seat) {
        int row = getRowFromSeat(seat);
        int col = getColFromSeat(seat);
        return tickets[row][col] != null;
    }

    public String getShowNumber() {
        return showNumber;
    }

    public List<Ticket> getTickets() {
        List<Ticket> answer = new ArrayList<>();
        for (int row = 0; row < getRows(); row++) {
            for (int col = 0; col < getCols(); col++) {
                Ticket ticket = tickets[row][col];
                if (ticket != null) {
                    answer.add(ticket);
                }
            }
        }
        return answer;
    }

    public List<String> getEmptySeats() {
        List<String> emptySeats = new ArrayList<>();
        for (int row = 0; row < getRows(); row++) {
            for (int col = 0; col < getCols(); col++) {
                Ticket ticket = tickets[row][col];
                if (ticket == null) {
                    emptySeats.add(TicketUtil.getSeatNumberFromRowCol(row, col));
                }
            }
        }
        return emptySeats;
    }

    private int getRows() {
        return tickets.length;
    }

    private int getCols() {
        return tickets[0].length;
    }

    private boolean canCancel(Instant bookedTime) {
        long secondsSinceBooked = Instant.now().getEpochSecond() - bookedTime.getEpochSecond();
        long cancelWindowInSeconds = cancelWindowInMinutes * 60L;
        return secondsSinceBooked <= cancelWindowInSeconds;
    }
}

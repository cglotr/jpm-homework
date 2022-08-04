package org.jpmorgan.beans;

import org.jpmorgan.models.Ticket;

public class TicketBean {
    private final String showNumber;
    private final String ticketNumber;
    private final String buyerPhoneNumber;
    private final String seatNumber;

    public TicketBean(Ticket ticket) {
        this.showNumber = ticket.getShowNumber();
        this.ticketNumber = ticket.getTicketNumber();
        this.buyerPhoneNumber = ticket.getPhoneNumber();
        this.seatNumber = ticket.getSeat();
    }

    public String getShowNumber() {
        return showNumber;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public String getBuyerPhoneNumber() {
        return buyerPhoneNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }
}

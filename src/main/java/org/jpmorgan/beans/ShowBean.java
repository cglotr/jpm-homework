package org.jpmorgan.beans;

import org.jpmorgan.models.Show;
import org.jpmorgan.models.Ticket;

import java.util.ArrayList;
import java.util.List;

public class ShowBean {
    private final String showNumber;
    private final List<TicketBean> tickets;

    public ShowBean(Show show) {
        this.showNumber = show.getShowNumber();
        this.tickets = new ArrayList<>();

        for (Ticket ticket : show.getTickets()) {
            this.tickets.add(new TicketBean(ticket));
        }
    }

    public String getShowNumber() {
        return showNumber;
    }

    public List<TicketBean> getTickets() {
        return tickets;
    }
}

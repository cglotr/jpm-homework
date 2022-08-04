package org.jpmorgan.managers;

import org.jpmorgan.Result;
import org.jpmorgan.beans.ShowBean;
import org.jpmorgan.beans.TicketBean;
import org.jpmorgan.models.Show;
import org.jpmorgan.models.Ticket;
import org.jpmorgan.utils.TicketUtil;

import java.util.ArrayList;
import java.util.List;

public class ShowManagerImpl implements ShowManager {
    List<Show> shows;

    public ShowManagerImpl() {
        this.shows = new ArrayList<>();
    }

    @Override
    public Result<ShowBean> setup(String showNumber, int rows, int seatsPerRow, int cancelWindowInMinutes) {
        Show show = new Show(showNumber, rows, seatsPerRow, cancelWindowInMinutes);
        shows.add(show);
        return new Result<>(new ShowBean(show));
    }

    @Override
    public Result<ShowBean> view(String showNumber) {
        Show show = find(showNumber);

        if (show == null) {
            return new Result<>("show not found");
        }

        return new Result<>(new ShowBean(show));
    }

    @Override
    public Result<List<String>> availability(String showNumber) {
        Show show = find(showNumber);

        if (show == null) {
            return new Result<>("show not found");
        }

        return new Result<>(show.getEmptySeats());
    }

    @Override
    public Result<List<TicketBean>> book(String showNumber, String phoneNumber, List<String> seats) {
        Show show = find(showNumber);

        if (show == null) {
            return new Result<>("show not available");
        }

        for (String seat : seats) {
            if (show.isBooked(seat)) {
                return new Result<>("some seats are already booked");
            }
        }

        List<TicketBean> ticketBeans = new ArrayList<>();

        for (String seat : seats) {
            Ticket ticket = show.book(phoneNumber, seat);
            ticketBeans.add(new TicketBean(ticket));
        }

        return new Result<>(ticketBeans);
    }

    @Override
    public Result<Boolean> cancel(String ticketNumber, String phoneNumber) {
        String showNumber = TicketUtil.parseShowNumberFromTicketNumber(ticketNumber);

        Show show = find(showNumber);

        if (show == null) {
            return new Result<>("show not found");
        }

        String seat = TicketUtil.parseSeatFromTicketNumber(ticketNumber);
        boolean cancelled = show.cancel(seat);

        if (!cancelled) {
            return new Result<>("booking cancellation failed");
        }

        return new Result<>(true);
    }

    private Show find(String showNumber) {
        for (Show show : shows) {
            if (show.getShowNumber().equals(showNumber)) {
                return show;
            }
        }
        return null;
    }
}

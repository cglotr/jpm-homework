package org.jpmorgan.managers;

import org.jpmorgan.beans.ShowBean;
import org.jpmorgan.beans.TicketBean;

import java.util.List;

public interface DisplayManager {
    void displayBookedShows(ShowBean showBean);

    void displaySeatNumbers(List<String> seatNumbers);

    void displayBookingSuccess(List<TicketBean> ticketBeans);

    void displaySetupSuccess(ShowBean showBean);

    void displayCancelledBooking();
}

package org.jpmorgan.managers;

import org.jpmorgan.beans.ShowBean;
import org.jpmorgan.beans.TicketBean;

import java.util.List;

public interface DisplayManager {
    String displayBookedShows(ShowBean showBean);

    String displaySeatNumbers(List<String> seatNumbers);

    String displayBookingSuccess(List<TicketBean> ticketBeans);

    String displaySetupSuccess(ShowBean showBean);

    String displayCancelledBooking();
}

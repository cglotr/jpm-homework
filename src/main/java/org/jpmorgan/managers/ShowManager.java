package org.jpmorgan.managers;

import org.jpmorgan.Result;
import org.jpmorgan.beans.ShowBean;
import org.jpmorgan.beans.TicketBean;

import java.util.List;

public interface ShowManager {
    Result<ShowBean> setup(String showNumber, int rows, int seatsPerRow, int cancelWindow);

    Result<ShowBean> view(String showNumber);

    Result<List<String>> availability(String showNumber);

    Result<List<TicketBean>> book(String showNumber, String phoneNumber, List<String> seats);

    Result<Boolean> cancel(String ticketNumber, String phoneNumber);
}

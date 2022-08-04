package org.jpmorgan.managers;

import org.jpmorgan.beans.ShowBean;
import org.jpmorgan.beans.TicketBean;

import java.util.List;

public class DisplayManagerImpl implements DisplayManager {
    @Override
    public String displayBookedShows(ShowBean showBean) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("٩(◕‿◕｡)۶ · Showing booked seats for [%s]:\n", showBean.getShowNumber()));
        showBean.getTickets().forEach(ticketBean -> {
            sb.append(String.format("* %s,\tuser=%s,\tseat=%s\n",
                    ticketBean.getTicketNumber(),
                    ticketBean.getBuyerPhoneNumber(),
                    ticketBean.getSeatNumber()));
        });
        return sb.toString();
    }

    public String displaySeatNumbers(List<String> seatNumbers) {
        StringBuilder sb = new StringBuilder();
        sb.append("٩(◕‿◕｡)۶ · Available seats:\n");
        seatNumbers.forEach(seatNumber -> {
            sb.append(String.format("* %s\n", seatNumber));
        });
        return sb.toString();
    }

    @Override
    public String displayBookingSuccess(List<TicketBean> ticketBeans) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("٩(◕‿◕｡)۶ · Successfully booked [%d] seats!:\n", ticketBeans.size()));
        ticketBeans.forEach(ticketBean -> {
            sb.append(String.format("* %s\tshow=%s,\tseat=%s\n",
                    ticketBean.getTicketNumber(),
                    ticketBean.getShowNumber(),
                    ticketBean.getSeatNumber()));
        });
        return sb.toString();
    }

    @Override
    public String displaySetupSuccess(ShowBean showBean) {
        return String.format("٩(◕‿◕｡)۶ · Successfully setup a new show [%s]!\n", showBean.getShowNumber());
    }

    @Override
    public String displayCancelledBooking() {
        return "٩(◕‿◕｡)۶ · Successfully cancelled the booking!\n";
    }
}

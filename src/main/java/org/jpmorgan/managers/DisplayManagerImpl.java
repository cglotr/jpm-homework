package org.jpmorgan.managers;

import org.jpmorgan.beans.ShowBean;
import org.jpmorgan.beans.TicketBean;

import java.util.List;

public class DisplayManagerImpl implements DisplayManager {
    @Override
    public void displayBookedShows(ShowBean showBean) {
        System.out.printf("٩(◕‿◕｡)۶ · Showing booked seats for [%s]:\n", showBean.getShowNumber());
        showBean.getTickets().forEach(ticketBean -> {
            System.out.printf("* %s,\tuser=%s,\tseat=%s\n",
                    ticketBean.getTicketNumber(),
                    ticketBean.getBuyerPhoneNumber(),
                    ticketBean.getSeatNumber());
        });
    }

    public void displaySeatNumbers(List<String> seatNumbers) {
        System.out.print("٩(◕‿◕｡)۶ · Available seats:\n");
        seatNumbers.forEach(seatNumber -> {
            System.out.printf("* %s\n", seatNumber);
        });
    }

    @Override
    public void displayBookingSuccess(List<TicketBean> ticketBeans) {
        System.out.printf("٩(◕‿◕｡)۶ · Successfully booked [%d] seats!:\n", ticketBeans.size());
        ticketBeans.forEach(ticketBean -> {
            System.out.printf("* %s\tshow=%s,\tseat=%s\n",
                    ticketBean.getTicketNumber(),
                    ticketBean.getShowNumber(),
                    ticketBean.getSeatNumber());
        });
    }

    @Override
    public void displaySetupSuccess(ShowBean showBean) {
        System.out.printf("٩(◕‿◕｡)۶ · Successfully setup a new show [%s]!\n", showBean.getShowNumber());
    }

    @Override
    public void displayCancelledBooking() {
        System.out.print("٩(◕‿◕｡)۶ · Successfully cancelled the booking!\n");
    }
}

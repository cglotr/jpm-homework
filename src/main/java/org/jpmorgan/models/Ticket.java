package org.jpmorgan.models;

import java.time.Instant;

public class Ticket {
    private final String showNumber;
    private final String seat;
    private final String phoneNumber;
    private final Instant bookingTime;

    public Ticket(String showNumber, String seat, String phoneNumber) {
        this.showNumber = showNumber;
        this.seat = seat;
        this.phoneNumber = phoneNumber;
        this.bookingTime = Instant.now();
    }

    public String getTicketNumber() {
        return "%s:%s:%d".formatted(showNumber, seat, bookingTime.getEpochSecond());
    }

    public String getSeat() {
        return seat;
    }

    public Instant getBookingTime() {
        return bookingTime;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getShowNumber() {
        return showNumber;
    }
}

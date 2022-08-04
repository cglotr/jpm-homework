package org.jpmorgan.managers;

import org.jpmorgan.beans.ShowBean;
import org.jpmorgan.models.Show;
import org.junit.jupiter.api.Test;

import java.util.Collections;

class DisplayManagerImplTest {

    @Test
    void displayBookedShows() {
        new DisplayManagerImpl().displayBookedShows(new ShowBean(new Show("SHOW1", 2, 3, 1)));
    }

    @Test
    void displaySeatNumbers() {
        new DisplayManagerImpl().displaySeatNumbers(Collections.emptyList());
    }

    @Test
    void displayBookingSuccess() {
        new DisplayManagerImpl().displayBookingSuccess(Collections.emptyList());
    }

    @Test
    void displaySetupSuccess() {
        new DisplayManagerImpl().displaySetupSuccess(new ShowBean(new Show("SHOW1", 2, 3, 1)));
    }

    @Test
    void displayCancelledBooking() {
        new DisplayManagerImpl().displayCancelledBooking();
    }
}

package com.paypal.bfs.test.bookingserv.impl;

import com.paypal.bfs.test.bookingserv.api.BookingResource;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingResourceImpl implements BookingResource {

    @Autowired
    BookingService bookingService;

    @Override
    public ResponseEntity<Booking> create(Booking booking) {
        Booking booking1 = bookingService.createBooking(booking);
        return ResponseEntity.ok(booking1);
    }

    @Override
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookingList = bookingService.getAllBooking();
        return ResponseEntity.ok(bookingList);
    }
}

package com.paypal.bfs.test.bookingserv.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class BookingServiceTest {

    @Autowired
    private BookingService bookingService;

    private Booking booking;


    @Before
    public void init() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String bookingObjectString = new String(
                Files.readAllBytes(Paths.get("src/test/resources/TestBooking.json")));
        this.booking = mapper.readValue(bookingObjectString, Booking.class);
    }

    @Test
    public void testCreateBooking(){
        Booking testBooking = bookingService.createBooking(booking);
        assertTrue(testBooking.getFirstName().equals(booking.getFirstName()));
    }

    @Test
    public void testGetAllBooking(){
        List<Booking> list = bookingService.getAllBooking();
        assertTrue(list.size()==0);
    }
}

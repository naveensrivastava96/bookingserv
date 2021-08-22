package com.paypal.bfs.test.bookingserv.service;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.entity.BookingEntity;
import com.paypal.bfs.test.bookingserv.exceptionhandler.BookingSerException;
import com.paypal.bfs.test.bookingserv.mapper.BookingMapper;
import com.paypal.bfs.test.bookingserv.mapper.BookingMapperImpl;
import com.paypal.bfs.test.bookingserv.repository.BookingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookingService.class);

    BookingMapper bookingMapper = new BookingMapperImpl();

    @Autowired
    BookingRepository bookingRepository;

    public Booking createBooking(Booking booking) {
        try {
            BookingEntity bookingEntity = bookingMapper.bookingToBookingEntity(booking);
            BookingEntity bookingEntityFromDb = bookingRepository.save(bookingEntity);
            return bookingMapper.bookingEntityToBooking(bookingEntityFromDb);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw new BookingSerException(e.getMessage());
        }
    }

    public List<Booking> getAllBooking() {
        try {
            List<BookingEntity> list = (List<BookingEntity>) bookingRepository.findAll();
            List<Booking> listOfBooking = bookingMapper.bookingEntityListToBookingList(list);
            return listOfBooking;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw new BookingSerException(e.getMessage());
        }
    }

}

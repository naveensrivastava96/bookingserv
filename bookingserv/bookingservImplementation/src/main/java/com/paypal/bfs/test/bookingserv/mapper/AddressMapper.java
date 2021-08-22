package com.paypal.bfs.test.bookingserv.mapper;

import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.entity.AddressEntity;
import com.paypal.bfs.test.bookingserv.entity.BookingEntity;
import org.mapstruct.Mapper;

@Mapper
public interface AddressMapper {

    Address addressEntityToBooking(AddressEntity addressEntity);

    AddressEntity BookingToBookingEntity(Address address);
}

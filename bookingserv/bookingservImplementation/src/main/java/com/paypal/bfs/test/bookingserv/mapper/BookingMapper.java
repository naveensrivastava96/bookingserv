package com.paypal.bfs.test.bookingserv.mapper;


import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.entity.BookingEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BookingMapper {

    BookingMapper BOOKING_MAPPER = Mappers.getMapper( BookingMapper.class );

    @Mapping(target="address", source="addressEntity")
    Booking bookingEntityToBooking(BookingEntity bookingEntity);

    @Mapping(target="addressEntity", source="address")
    BookingEntity bookingToBookingEntity(Booking booking);

    List<Booking> bookingEntityListToBookingList(List<BookingEntity> bookingEntities);


}

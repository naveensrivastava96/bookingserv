package com.paypal.bfs.test.bookingserv.repository;

import com.paypal.bfs.test.bookingserv.entity.AddressEntity;
import com.paypal.bfs.test.bookingserv.entity.BookingEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<AddressEntity,Long> {
}

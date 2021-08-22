package com.paypal.bfs.test.bookingserv.repository;

import com.paypal.bfs.test.bookingserv.entity.BookingEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import javax.persistence.Id;

@Repository
public interface BookingRepository extends CrudRepository<BookingEntity,Long> {

}

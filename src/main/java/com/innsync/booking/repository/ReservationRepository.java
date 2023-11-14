package com.innsync.booking.repository;

import com.innsync.booking.model.Reservation;
import com.innsync.booking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    List<Reservation> findAllReservationsByUser(Long id);
}

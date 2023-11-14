package com.innsync.booking.repository;

import com.innsync.booking.model.Reservation;
import com.innsync.booking.model.Room;
import com.innsync.booking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
//    List<Reservation> findReservationsByUser(Long id);

    List<Reservation> findReservationsByRoom(Room room);

    List<Reservation> findByRoomAndCheckInDateLessThanEqualAndCheckoutDateGreaterThanEqual(
            Room room, Date checkOutDate, Date checkInDate);
}

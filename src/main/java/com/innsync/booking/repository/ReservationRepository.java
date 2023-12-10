package com.innsync.booking.repository;

import com.innsync.booking.model.Reservation;
import com.innsync.booking.model.Room;
import com.innsync.booking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
//    List<Reservation> findReservationsByUser(Long id);

    List<Reservation> findReservationsByRoom(Room room);

    List<Reservation> findByRoomAndCheckInDateBetweenOrCheckoutDateBetween(
            Room room, LocalDate checkInDate , LocalDate checkOutDate , LocalDate checkInDate2 , LocalDate checkOutDate2);

    List<Reservation> findReservationsByUser(Optional<User> user);
}

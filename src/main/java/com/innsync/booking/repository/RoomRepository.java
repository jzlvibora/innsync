package com.innsync.booking.repository;

import com.innsync.booking.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room,Long> {
    Optional<Object> findByRoomNumber(String roomNumber);

    @Query("SELECT r FROM Room r LEFT JOIN r.reservations res " + "WHERE (res.checkoutDate < :checkInDate OR res.checkInDate > :checkoutDate) OR res.reservationId IS NULL")
    List<Room> findAvailableRoomsBetweenDates(@Param("checkInDate") LocalDate checkInDate , @Param("checkoutDate") LocalDate checkoutDate);
}

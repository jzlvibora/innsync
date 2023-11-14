package com.innsync.booking.repository;

import com.innsync.booking.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room,Long> {
    Optional<Object> findByRoomNumber(String roomNumber);
}

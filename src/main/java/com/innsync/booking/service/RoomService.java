package com.innsync.booking.service;

import com.innsync.booking.exceptions.RoomAlreadyExistsException;
import com.innsync.booking.model.Room;
import com.innsync.booking.repository.RoomRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public Room getRoom(Long id){
        Optional<Room> room = roomRepository.findById(id);
        return room.orElseThrow();

    }

    public List<Room> getAllRooms(){
        List<Room> rooms = roomRepository.findAll();
        return rooms;
    }

    public List<Room> getAllAvailableRooms(LocalDate checkInDate, LocalDate checkoutDate){
        List<Room> availableRooms = roomRepository.findAvailableRoomsBetweenDates(checkInDate,checkoutDate);
        return availableRooms;
    }

    public Room addRoom(Room newRoom){
        if (roomRepository.findByRoomNumber(newRoom.getRoomNumber()).isPresent()) {
            throw new RoomAlreadyExistsException("Room already exists: " + newRoom.getRoomNumber());
        }

        return roomRepository.save(newRoom);
    }

}

package com.innsync.booking.service;

import com.innsync.booking.exceptions.RoomAlreadyExistsException;
import com.innsync.booking.model.Room;
import com.innsync.booking.repository.RoomRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllRooms(){
        List<Room> rooms = roomRepository.findAll();
        return rooms;
    }

    public Room addRoom(Room newRoom){
        if (roomRepository.findByRoomNumber(newRoom.getRoomNumber()).isPresent()) {
            throw new RoomAlreadyExistsException("Room already exists: " + newRoom.getRoomNumber());
        }

        return roomRepository.save(newRoom);
    }

}

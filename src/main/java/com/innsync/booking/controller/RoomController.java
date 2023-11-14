package com.innsync.booking.controller;

import com.innsync.booking.dto.RoomDTO;
import com.innsync.booking.model.Room;
import com.innsync.booking.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("innsync/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping
    public List<Room> getAllRooms(){
        List<Room> rooms = roomService.getAllRooms();
        return rooms;
    }

    @PostMapping("/new")
    public ResponseEntity<Room> addRoom(@RequestBody RoomDTO roomDTO){
        Room newRoom = new Room();
        newRoom.setRoomNumber(roomDTO.getRoomNumber());
        newRoom.setPrice(roomDTO.getPrice());
        newRoom.setType(roomDTO.getType());
        newRoom.setCapacity(roomDTO.getCapacity());
        newRoom.setDescription(roomDTO.getDescription());

        roomService.addRoom(newRoom);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }
}

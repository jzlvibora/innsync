package com.innsync.booking.controller;

import com.innsync.booking.dto.RoomDTO;
import com.innsync.booking.model.Room;
import com.innsync.booking.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("innsync/rooms")
@CrossOrigin(value = "http://localhost:4200")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping("/{id}")
    public Room getRoom(@PathVariable Long id){
        Room room = roomService.getRoom(id);
        return room;
    }

    @GetMapping("/ourRooms")
    public List<Room> getAllRooms(){
        List<Room> rooms = roomService.getAllRooms();
        return rooms;
    }

    @GetMapping("/availableRooms")
    public List<Room> getAllAvailableRooms(@RequestParam String checkInDate, @RequestParam String checkoutDate){
        LocalDate inDate = LocalDate.parse(checkInDate);
        LocalDate outDate = LocalDate.parse(checkoutDate);
        List<Room> rooms = roomService.getAllAvailableRooms(inDate,outDate);
        return rooms;
    }

    @PostMapping("/new")
    public ResponseEntity<Room> addRoom(@RequestBody RoomDTO roomDTO){
        Room newRoom = new Room();
        newRoom.setRoomNumber(roomDTO.getRoomNumber());
        newRoom.setPrice(roomDTO.getPrice());
        newRoom.setRoomType(roomDTO.getRoomType());
        newRoom.setCapacity(roomDTO.getCapacity());
        newRoom.setDescription(roomDTO.getDescription());
        newRoom.setRoomName(newRoom.generateRoomName());

        roomService.addRoom(newRoom);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable Long id, @RequestBody Room room){
        roomService.updateRoom(id,room);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Room> deleteRoom(@PathVariable Long id){
        roomService.deleteRoom(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}

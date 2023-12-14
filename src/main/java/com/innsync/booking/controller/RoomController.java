package com.innsync.booking.controller;

import com.innsync.booking.dto.RoomDTO;
import com.innsync.booking.model.Room;
import com.innsync.booking.service.RoomService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("innsync/rooms")
@CrossOrigin(value = "http://localhost:4200")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoom(@PathVariable Long id){
        Room room = roomService.getRoom(id);
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    @GetMapping("/ourRooms")
    public ResponseEntity<List<Room>> getAllRooms(){
        List<Room> rooms = roomService.getAllRooms();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping("/availableRooms")
    public ResponseEntity<List<Room>> getAllAvailableRooms(
            @RequestParam
            @NotNull(message = "Check-in date must not be null")
            @Future(message = "Check-in date must be in the present or future")
            String checkInDate,
            @RequestParam
            @NotNull(message = "Check-out date must not be null")
            @Future(message = "Check-out date must be in the present or future")
            String checkoutDate){
        LocalDate inDate = LocalDate.parse(checkInDate);
        LocalDate outDate = LocalDate.parse(checkoutDate);
        List<Room> rooms = roomService.getAllAvailableRooms(inDate,outDate);
        return new ResponseEntity<>(rooms,HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<String> addRoom(@RequestBody RoomDTO roomDTO){
        Room newRoom = new Room();
        newRoom.setRoomNumber(roomDTO.getRoomNumber());
        newRoom.setPrice(roomDTO.getPrice());
        newRoom.setRoomType(roomDTO.getRoomType());
        newRoom.setCapacity(roomDTO.getCapacity());
        newRoom.setDescription(roomDTO.getDescription());
        newRoom.setRoomName(newRoom.generateRoomName());

        roomService.addRoom(newRoom);
        return new ResponseEntity<>("Room added successfully" , HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateRoom(
            @PathVariable
            @NotNull(message = "Room ID must be specified") Long id,
            @RequestBody Room room){
        roomService.updateRoom(id,room);
        return new ResponseEntity<>("Successfully updated room with id " + id,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRoom(@PathVariable Long id){
        roomService.deleteRoom(id);
        return new ResponseEntity<>("Successfully deleted room with id " + id, HttpStatus.OK);

    }
}

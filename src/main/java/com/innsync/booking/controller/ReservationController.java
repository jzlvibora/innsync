package com.innsync.booking.controller;

import com.innsync.booking.dto.ReservationRequestDTO;
import com.innsync.booking.model.Reservation;
import com.innsync.booking.model.Room;
import com.innsync.booking.model.User;
import com.innsync.booking.repository.ReservationRepository;
import com.innsync.booking.repository.RoomRepository;
import com.innsync.booking.repository.UserRepository;
import com.innsync.booking.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("innsync/reservations")
@CrossOrigin(value = "http://localhost:4200")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    ReservationService reservationService;

    @GetMapping
    public List<Reservation> getAllReservations(){
        List<Reservation> reservations = reservationService.getAllReservations();
        return reservations;
    }

    @GetMapping("/{username}")
    public List<Reservation> getAllReservationsByUser(@PathVariable String username){
        Optional<User> user = userRepository.findUserByUsername(username);
        List<Reservation> reservations = reservationService.getAllReservationsByUser(user);
        return reservations;
    }

    @PostMapping("/new")
    public Reservation reserveARoom(@RequestBody ReservationRequestDTO reservationRequestDTO){
        LocalDate checkInDate = reservationRequestDTO.getCheckInDate();
        LocalDate checkoutDate = reservationRequestDTO.getCheckOutDate();
        Room room = roomRepository.findById(reservationRequestDTO.getRoomId()).orElseThrow(()-> new RuntimeException("Selected room not found"));
        User user = userRepository.findUserByUsername(reservationRequestDTO.getUsername()).orElseThrow(()-> new RuntimeException("User not found"));
        return reservationService.bookARoom(user,room,checkInDate,checkoutDate);
    }

}

package com.innsync.booking.service;

import com.innsync.booking.model.Reservation;
import com.innsync.booking.model.User;
import com.innsync.booking.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations(){
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations;
    }

    public List<Reservation> getAllReservationsByUser(User user){
        List<Reservation> reservations = reservationRepository.findAllReservationsByUser(user.getUserId());
        return reservations;
    }





}

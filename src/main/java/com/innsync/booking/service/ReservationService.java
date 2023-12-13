package com.innsync.booking.service;

import com.innsync.booking.model.Reservation;
import com.innsync.booking.model.Room;
import com.innsync.booking.model.User;
import com.innsync.booking.repository.ReservationRepository;
import com.innsync.booking.repository.RoomRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    private RoomRepository roomRepository;

    public List<Reservation> getAllReservations(){
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations;
    }

//    public List<Reservation> getAllReservationsByUser(Optional<User> user){
//        List<Reservation> reservations = reservationRepository.findAllReservationsByUser(user.get().getUserId());
//        return reservations;
//    }

    public Reservation bookARoom(User user, Room room, LocalDate checkInDate, LocalDate checkoutDate){
//        List<Reservation> existingReservations = reservationRepository.findByRoomAndCheckInDateLessThanEqualAndCheckoutDateGreaterThanEqual(room,checkInDate,checkoutDate);
        if(isRoomAvailable(room,checkInDate,checkoutDate)){
            Reservation newReservation = new Reservation();
            newReservation.setRoom(room);
            newReservation.setCheckInDate(checkInDate);
            newReservation.setCheckoutDate(checkoutDate);
            newReservation.setUser(user);
            newReservation.setAmount(12000);
            reservationRepository.save(newReservation);
            return newReservation;
        }
        else{
            throw new RuntimeException("Room not available for the selected dates.");
        }
    }

    public boolean isRoomAvailable(Room room, LocalDate checkInDate, LocalDate checkoutDate){
//        Long id = room.getRoomId();
        List<Room> availableRooms = roomRepository.findAvailableRoomsBetweenDates(checkInDate,checkoutDate);
        if(availableRooms.size()!=0 && availableRooms.contains(room)){
            return true;
        }
        else return false;
    }


    public List<Reservation> getAllReservationsByUser(Optional<User> user) {
        List<Reservation> userReservations = reservationRepository.findReservationsByUser(user);
        return userReservations;
    }
}

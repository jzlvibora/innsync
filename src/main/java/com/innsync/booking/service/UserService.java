package com.innsync.booking.service;

import com.innsync.booking.exceptions.UserAlreadyExistsException;
import com.innsync.booking.exceptions.UserNotFoundException;
import com.innsync.booking.model.Reservation;
import com.innsync.booking.model.User;
import com.innsync.booking.repository.ReservationRepository;
import com.innsync.booking.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    public List<User> getAllUsers(){
        List<User> users = userRepository.findAll();
        return users;
    }

    public User save(User newUser) {
        if (userRepository.findUserByUsername(newUser.getUsername()).isPresent()) {
            throw new UserAlreadyExistsException("Username already exists: " + newUser.getUsername());
        }

        return userRepository.save(newUser);
    }

    public User findUserById(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found."));
        return user;
    }

    public User findUserByUsername(String username){
        User user = userRepository.findUserByUsername(username).orElseThrow(() -> new UserNotFoundException(username));
        return user;
    }


    public List<Reservation> getAllReservationsByUser(User user){
        List<Reservation> reservations = reservationRepository.findAllReservationsByUser(user);
        return reservations;
    }

}

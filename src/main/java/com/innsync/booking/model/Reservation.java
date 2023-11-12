package com.innsync.booking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long reservationId;

    private Date checkInDate;
    private Date checkoutDate;
    private double amount;

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "userId")
    private User user;

    @OneToOne
    @JoinColumn(name="room_id", referencedColumnName = "roomId")
    private Room room;

    @OneToOne(mappedBy = "reservation")
    private Payment payment;



}

package com.innsync.booking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long paymentId;

    private String paymentMethod;
    private Double amount;

    @OneToOne
    @JoinColumn(name="reservation_id", referencedColumnName = "reservationId")
    private Reservation reservation;

    @OneToOne
    @JoinColumn(name="user_id", referencedColumnName = "userId")
    private User user;
}

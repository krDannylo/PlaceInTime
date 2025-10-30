package com.dev.dj.PlaceInTime.entity;

import com.dev.dj.PlaceInTime.enums.PaymentStatus;
import com.dev.dj.PlaceInTime.enums.StatusBooking;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "booking")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "slotId",nullable = false, unique = true)
    private Slot slot;

    @Column(nullable = false)
    private StatusBooking status;

    @Column(nullable = false,name ="checkin_at")
    private LocalDateTime checkInAt;

    @Column(name = "checkout_at")
    private LocalDateTime checkOutAT;

    @Column(nullable = false)
    private PaymentStatus paymentStatus;


    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;



}

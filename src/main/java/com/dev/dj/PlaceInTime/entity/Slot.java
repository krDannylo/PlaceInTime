package com.dev.dj.PlaceInTime.entity;

import com.dev.dj.PlaceInTime.enums.StatusSlot;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "slot")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Slot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "serviceId")
    private Service service;

    @Column(unique = true, nullable = false)
    private LocalDateTime startTime;

    @Column(unique = true, nullable = false)
    private LocalDateTime endTime;

    @Column(nullable = false)
    private StatusSlot status;

    @CreationTimestamp
    @Column(nullable = false, updatable = false, name = "created_at")
    private LocalDateTime createTime;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updateTime;

    @OneToOne(mappedBy = "slot",fetch = FetchType.LAZY,orphanRemoval = true,cascade = CascadeType.ALL)
    private Booking booking;
}

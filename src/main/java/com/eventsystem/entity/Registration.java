package com.eventsystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="registrations",
        uniqueConstraints = {
               @UniqueConstraint(columnNames = {"user_id", "event_id"})
        })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="event_id")
    private Event event;

    private LocalDateTime registrationDate;
}

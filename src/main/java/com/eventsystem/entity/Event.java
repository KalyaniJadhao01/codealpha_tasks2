package com.eventsystem.entity;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@Entity
@Table(name="events")

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor

public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "Title required")
    private String title;


    @NotBlank(message = "Description required")
    private String description;


    @NotBlank(message = "Location required")
    private String location;


    @NotNull(message = "Event date required")
    private LocalDateTime eventDate;


    @Positive(message = "Capacity must be positive")
    private Integer capacity;


}

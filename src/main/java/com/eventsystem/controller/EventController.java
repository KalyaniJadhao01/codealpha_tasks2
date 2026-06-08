package com.eventsystem.controller;

import com.eventsystem.dto.ApiResponse;
import com.eventsystem.entity.Event;
import com.eventsystem.service.EventService;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;


    public EventController(EventService eventService) {

        this.eventService = eventService;

    }


    @PostMapping
    public ApiResponse<Event> createEvent(
            @Valid
            @RequestBody
            Event event
    ) {

        Event savedEvent =
                eventService.createEvent(event);

        return new ApiResponse<>(

                true,

                "Event created successfully",

                savedEvent

        );

    }


    @GetMapping
    public ApiResponse<Page<Event>> getEvents(

            @RequestParam(defaultValue = "0")
            int page,

            @RequestParam(defaultValue = "5")
            int size,

            @RequestParam(required = false)
            String keyword

    ) {

        Page<Event> events =
                eventService.getEvents(
                        page,
                        size,
                        keyword
                );

        return new ApiResponse<>(

                true,

                "Events fetched successfully",

                events

        );

    }


    @GetMapping("/{id}")
    public ApiResponse<Event> getEventById(
            @PathVariable Long id
    ) {

        Event event =
                eventService.getEventById(id);

        return new ApiResponse<>(

                true,

                "Event fetched successfully",

                event

        );

    }


    @PutMapping("/{id}")
    public ApiResponse<Event> updateEvent(

            @PathVariable Long id,

            @Valid
            @RequestBody
            Event event

    ) {

        Event updatedEvent =
                eventService.updateEvent(
                        id,
                        event
                );

        return new ApiResponse<>(

                true,

                "Event updated successfully",

                updatedEvent

        );

    }


    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteEvent(
            @PathVariable Long id
    ) {

        eventService.deleteEvent(id);

        return new ApiResponse<>(

                true,

                "Event deleted successfully",

                null

        );

    }

}
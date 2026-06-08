package com.eventsystem.service;

import com.eventsystem.entity.Event;
import com.eventsystem.repository.EventRepository;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class EventService {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event createEvent(Event event)
         {return eventRepository.save(event);}

    public List<Event> getAllEvents()
         {return eventRepository.findAll();}

    public Event getEventById(Long id){
        return eventRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Event not found"));
    }

    public Event updateEvent(Long id , Event updateEvent){
        Event existingEvent = getEventById(id);
        existingEvent.setTitle(updateEvent.getTitle());
        existingEvent.setDescription(updateEvent.getDescription());
        existingEvent.setLocation(updateEvent.getLocation());
        existingEvent.setEventDate(updateEvent.getEventDate());
        existingEvent.setCapacity(updateEvent.getCapacity());

        return eventRepository.save(existingEvent);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    public Page<Event> getEvents(int page, int size, String keyword)
    {
        Pageable pageable = PageRequest.of(page, size);
        if(keyword == null || keyword.isBlank()){
            return eventRepository.findAll(pageable);
        }

        return eventRepository.findByTitleContainingIgnoreCase(keyword, pageable);

    }
}

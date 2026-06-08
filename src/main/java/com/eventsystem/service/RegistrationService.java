package com.eventsystem.service;

import com.eventsystem.dto.RegistrationRequest;
import com.eventsystem.entity.*;
import com.eventsystem.exception.ResourceException;
import com.eventsystem.repository.*;
import org.springframework.stereotype.Service;
import com.eventsystem.exception.ResourceException;

import java.time.LocalDateTime;

@Service
public class RegistrationService {

    private final UserRepository userRepository;
    private final EventRepository eventRepository;
    private final RegistrationRepository registrationRepository;

   //constructor
    public RegistrationService(UserRepository userRepository, EventRepository eventRepository, RegistrationRepository registrationRepository){
        this.userRepository=userRepository;
        this.eventRepository=eventRepository;
        this.registrationRepository= registrationRepository;
    }

    public Registration register(RegistrationRequest request){
        Event event= eventRepository.findById(request.getEventId())
                .orElseThrow(()->new ResourceException("Event not found"));


        User user= userRepository.findByEmail(request.getEmail())
                .orElseGet(()->{
                    User newUser= new User();
                    newUser.setName(request.getName());
                    newUser.setEmail(request.getEmail());
                    newUser.setPhone(request.getPhone());

                    return userRepository.save(newUser);
                });

        if (registrationRepository.existsByUserAndEvent(user, event)){
            throw new ResourceException("Already registered");
        }

        long registrations = registrationRepository.countByEvent(event);

        if (registrations >= event.getCapacity()) {
            throw new ResourceException("Event full");
        }

        Registration registration = new Registration();

        registration.setUser(user);
        registration.setEvent(event);
        registration.setRegistrationDate(LocalDateTime.now());

        return registrationRepository.save(registration);

    }


}

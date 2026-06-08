package com.eventsystem.repository;

import com.eventsystem.entity.Event;
import com.eventsystem.entity.Registration;
import com.eventsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration,Long> {

    boolean existsByUserAndEvent(User user, Event event);
    long countByEvent(Event event);

}
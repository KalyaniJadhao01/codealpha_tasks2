package com.eventsystem.controller;

import com.eventsystem.dto.RegistrationRequest;
import com.eventsystem.entity.Registration;
import com.eventsystem.service.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registrations")
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService){
        this.registrationService= registrationService;
    }

    @PostMapping
    public Registration register(@Valid  @RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }

}
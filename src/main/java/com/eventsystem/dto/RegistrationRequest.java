package com.eventsystem.dto;
import jakarta.validation.constraints.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationRequest {
    @NotBlank
    private String name;

    @Email
    private String email;

    @NotBlank
    private String phone;

    @NotNull
    private Long eventId;

}

package com.springframeworkapp.SpringFramework.student;

import jakarta.validation.constraints.NotEmpty;

public record StudentDTO(
        @NotEmpty(message = "First Name should NOT be empty")
        String firstname,

        @NotEmpty(message = "Last Name should NOT be empty")
        String lastname,

        String email,

        Integer schoolId
) {

}

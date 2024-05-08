package com.springframeworkapp.SpringFramework.student;

public record StudentDTO(
        String firstname,
        String lastname,
        String email,
        Integer schoolId
) {

}

package com.springframeworkapp.SpringFramework.school;

import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {

    public School toSchool(SchoolDTO dto) {
        var school = new School();
        school.setName(dto.name());
        return school;
    }

    public SchoolDTO toSchoolDTO(School school){
        return new SchoolDTO(school.getName());
    }
}
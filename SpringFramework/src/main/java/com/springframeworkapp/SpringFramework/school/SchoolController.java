package com.springframeworkapp.SpringFramework.school;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    // Post a new School
    @PostMapping("/schools")
    public SchoolDTO saveSchool(
            @RequestBody SchoolDTO dto
    ) {
        return  schoolService.create(dto);
    }

    // Get All Schools
    @GetMapping("/schools")
    public List<SchoolDTO> findAll() {
        return schoolService.findAllSchools();
    }

    // Get Schools by ID
    @GetMapping("/schools/{id}")
    public SchoolDTO getSchoolById(
            @PathVariable("id") Integer id
    ) {
        return schoolService.getSchoolById(id);
    }

    // Delete School
    @DeleteMapping ("api/student/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudentById(
            @PathVariable("id") Integer id
    ) {
        schoolService.delete(id);
    }
}

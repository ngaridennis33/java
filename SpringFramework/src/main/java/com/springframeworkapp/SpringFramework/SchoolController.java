package com.springframeworkapp.SpringFramework;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SchoolController {

    private final SchoolRepository schoolRepository;

    public SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @PostMapping("/schools")
    public School create(
            @RequestBody School school
    ){
        return schoolRepository.save(school);
    }

    @GetMapping("/schools")
    public List<School> findAll(){
        return schoolRepository.findAll();
    }

    @GetMapping("/schools/{id}")
    public School getSchoolById(
            @PathVariable("id") Integer id
    ){
        return schoolRepository.findById(id)
                .orElse(new School());
    }
}

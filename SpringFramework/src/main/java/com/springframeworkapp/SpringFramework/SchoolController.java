package com.springframeworkapp.SpringFramework;


import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class SchoolController {

    private final SchoolRepository schoolRepository;

    public SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @PostMapping("/schools")
    public SchoolDTO create(
            @RequestBody SchoolDTO dto
    ){
        var school = toSchool(dto);
        schoolRepository.save(school);
         return dto;

    }
    private School toSchool(SchoolDTO dto){
        var school = new School();
        school.setName(dto.name());
        return school;
    }

    private  SchoolDTO toSchoolDTO(School school){
        return new SchoolDTO(school.getName());
    }

    @GetMapping("/schools")
    public List<SchoolDTO> findAll(){
        return schoolRepository.findAll()
                .stream()
                .map(this::toSchoolDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/schools/{id}")
    public School getSchoolById(
            @PathVariable("id") Integer id
    ){
        return schoolRepository.findById(id)
                .orElse(new School());
    }
}

package com.springframeworkapp.SpringFramework.school;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {

    private final SchoolMapper schoolMapper;
    private final SchoolRepository schoolRepository;

    public SchoolService(SchoolMapper schoolMapper, SchoolRepository schoolRepository) {
        this.schoolMapper = schoolMapper;
        this.schoolRepository = schoolRepository;
    }

    // Add a new School
    public SchoolDTO create(SchoolDTO dto) {
        var school = schoolMapper.toSchool(dto);
        schoolRepository.save(school);
        return dto;
    }

    // Get All Schools
    public List<SchoolDTO> findAllSchools() {
        return schoolRepository.findAll()
                .stream()
                .map(schoolMapper::toSchoolDTO)
                .collect(Collectors.toList());
    }

    // Get School by ID
    public SchoolDTO getSchoolById(Integer id) {
        return schoolRepository.findById(id)
                .map(schoolMapper::toSchoolDTO)
                .orElse(null);
    }

    // Delete School by ID
    public void delete(Integer id) {
        schoolRepository.deleteById(id);
    }
}

package com.springframeworkapp.SpringFramework.student;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    //    Save Student
    public StudentResponseDTO saveStudent(
            StudentDTO dto
    ){
        var student = studentMapper.toStudent(dto);
        var savedStudent =  studentRepository.save(student);
        return studentMapper.tostudentResponseDTO(savedStudent);
    }

    // Get all Students
    public List<StudentResponseDTO> findAllStudents() {
      return studentRepository.findAll()
              .stream()
              .map(studentMapper::tostudentResponseDTO)
              .collect(Collectors.toList());
    }

    // Get Student by ID
    public StudentResponseDTO findStudentById(Integer id) {
         return studentRepository.findById(id)
                 .map(studentMapper::tostudentResponseDTO)
                .orElse(null);

    }

    // Get Student by name
    public List <StudentResponseDTO> findStudentByName(String name) {
        return studentRepository.findAllByFirstnameContaining(name)
                .stream()
                .map(studentMapper::tostudentResponseDTO)
                .collect(Collectors.toList());
    }

    // Delete Student by ID
    public void delete(Integer id) {
        studentRepository.deleteById(id);
    }

}

package com.springframeworkapp.SpringFramework.student;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("api/student")
    public StudentResponseDTO saveStudent(
            @RequestBody StudentDTO dto
    ) {
        return this.studentService.saveStudent(dto);
    }

    //  Get All Students
    @GetMapping("api/students")
    public List<StudentResponseDTO> findAllStudents() {
        return studentService.findAllStudents();
    }


    //  Get Students by ID
    @GetMapping("api/student/{student-id}")
    public StudentResponseDTO findStudentById(
            @PathVariable("student-id") Integer id
    ) {
        return studentService.findStudentById(id);
    }

    // Get Student by name
    @GetMapping("api/student/search/{name}")
    public List <StudentResponseDTO> findStudentByFirstName(
            @PathVariable("name") String name
    ) {
        return studentService.findStudentByName(name);
    }

    @DeleteMapping ("api/student/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudentById(
            @PathVariable("id") Integer id
    ) {
        studentService.delete(id);
    }
}

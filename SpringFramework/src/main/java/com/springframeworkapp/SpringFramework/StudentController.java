package com.springframeworkapp.SpringFramework;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping("api/student")
    public Student post(
            @RequestBody Student student
    ) {
        return studentRepository.save(student);
    }

    //  Get All Objects
    @GetMapping("api/students")
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("api/student/{student-id}")
    public Student findStudentById(
            @PathVariable("student-id") Integer id
    ) {
        return studentRepository.findById(id)
                .orElse(new Student());
    }

    @GetMapping("api/student/search/{first-name}")
    public List <Student> findStudentByFirstName(
            @PathVariable("first-name") String firstName
    ) {
        return studentRepository.findAllByFirstnameContaining(firstName);
    }

    @DeleteMapping ("api/student/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudentById(
            @PathVariable("id") Integer id
    ) {
         studentRepository.deleteById(id);

    }
}

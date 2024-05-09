package com.springframeworkapp.SpringFramework.student;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("api/student")
    public StudentResponseDTO saveStudent(
            @Valid @RequestBody StudentDTO dto
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exp
    ){
        var errors = new HashMap<String, String>();
        exp.getBindingResult().getAllErrors()
                .forEach(error -> {
                    var fieldName = ((FieldError) error).getField();
                    var errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}

package com.springframeworkapp.SpringFramework.student;

import com.springframeworkapp.SpringFramework.school.School;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {
    public Student toStudent(StudentDTO dto){
        if(dto == null){
            throw new NullPointerException("The student DTO should NOT be null");
        }
        var student = new Student();
        student.setFirstname(dto.firstname());
        student.setLastname(dto.lastname());
        student.setEmail(dto.email());

        var school = new School();
        school.setId(dto.schoolId());
        student.setSchool(school);

        return student;
    }
    public StudentResponseDTO tostudentResponseDTO(Student student){
        return new StudentResponseDTO(
                student.getFirstname(),
                student.getLastname(),
                student.getEmail()
        );
    }
}

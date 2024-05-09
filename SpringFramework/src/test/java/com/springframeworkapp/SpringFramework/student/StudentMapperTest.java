package com.springframeworkapp.SpringFramework.student;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    private StudentMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new StudentMapper();
    }

    @Test
    public void shouldMapStudentDtoToStudent() {
        StudentDTO dto = new StudentDTO(
                "john", "Doe", "john@gmail.com", 2);
        Student student = mapper.toStudent(dto);

        assertEquals(dto.firstname(), student.getFirstname());
        assertEquals(dto.lastname(), student.getLastname());
        assertEquals(dto.email(), student.getEmail());
        assertNotNull(student.getSchool());
        assertEquals(dto.schoolId(), student.getSchool().getId());
    }

    @Test
    public void should_throw_null_pointer_exception_when_student_dto_is_null(){
        var exp = assertThrows(NullPointerException.class,() ->  mapper.toStudent(null));
        assertEquals("The student DTO should NOT be null", exp.getMessage());
    }

    @Test
   public void shouldMapStudentToStudentResponseDto(){
        // Given
        Student student = new Student("jane","smith","jane@gmail.com",30);

        // When
        StudentResponseDTO response = mapper.tostudentResponseDTO(student);

        // Then
        assertEquals(response.firstname(),student.getFirstname());
        assertEquals(response.lastname(),student.getLastname());
        assertEquals(response.email(),student.getEmail());
   }
}
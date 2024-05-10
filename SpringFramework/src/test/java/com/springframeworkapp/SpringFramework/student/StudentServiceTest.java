package com.springframeworkapp.SpringFramework.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    // Services to test
    @InjectMocks
    private StudentService studentService;

    // Declare the dependencies
    @Mock
    private StudentRepository repository;
    @Mock
    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_successfully_save_a_student() {
        // Given
        StudentDTO dto = new StudentDTO(
                "john",
                "Doe",
                "john@gmail.com",
                1
        );
        Student student = new Student(
                "john",
                "Doe",
                "john@gmail.com",
                20
        );

        Student savedStudent = new Student(
                "john",
                "Doe",
                "john@gmail.com",
                20
        );
        savedStudent.setId(1);

        // Mock the calls
        when(studentMapper.toStudent(dto))
                .thenReturn(student);
        when(repository.save(student))
                .thenReturn(savedStudent);
        when(studentMapper.tostudentResponseDTO(savedStudent))
                .thenReturn(new StudentResponseDTO(
                        "john",
                        "Doe",
                        "john@gmail.com"
                ));

        // When
        StudentResponseDTO responseDTO = studentService.saveStudent(dto);

        // Then
        assertEquals(dto.firstname(), responseDTO.firstname());
        assertEquals(dto.lastname(), responseDTO.lastname());
        assertEquals(dto.email(), responseDTO.email());

        verify(studentMapper, times(1)).toStudent(dto);
        verify(repository, times(1)).save(student);
        verify(studentMapper, times(1)).tostudentResponseDTO(savedStudent);
    }


    @Test
    public void should_return_all_students() {

        // Given
        List<Student> students = new ArrayList<>();
        students.add(new Student(
                "john",
                "Doe",
                "john@gmail.com",
                20
        ));

        //  Mock the calls
        when(repository.findAll()).thenReturn(students);
        when(studentMapper.tostudentResponseDTO(any(Student.class)))
                .thenReturn(new StudentResponseDTO(
                        "john",
                        "Doe",
                        "john@example.com"
                ));

        // When
        List<StudentResponseDTO> responseDTOS = studentService.findAllStudents();

        // Then
        assertEquals(students.size(), responseDTOS.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    public void should_return_student_by_name() {

        // Given
        String studentName = "john";
        List<Student> students = new ArrayList<>();
        students.add(new Student(
                "john",
                "Doe",
                "john@gmail.com",
                20
        ));

        //  Mock the calls
        when(repository.findAllByFirstnameContaining(studentName)).thenReturn(students);
        when(studentMapper.tostudentResponseDTO(any(Student.class)))
                .thenReturn(new StudentResponseDTO(
                        "john",
                        "Doe",
                        "john@example.com"
                ));

        // When
        var responseDTO = studentService.findStudentByName(studentName);

        // Then
        assertEquals(students.size(), responseDTO.size());
        verify(repository, times(1)).findAllByFirstnameContaining(studentName);

    }

    @Test
    public void should_return_student_by_id() {

        // Given
        Integer studentId = 1;
        Student student = new Student(
                "john",
                "Doe",
                "john@gmail.com",
                20
        );

        // Mock the calls
        when(repository.findById(studentId)).thenReturn(Optional.of(student));
        when(studentMapper.tostudentResponseDTO(any(student.getClass())))
                .thenReturn(new StudentResponseDTO(
                        "john",
                        "Doe",
                        "john@gmail.com"
                ));

        // When
        StudentResponseDTO dto = studentService.findStudentById(studentId);

        // Then
        assertEquals(dto.firstname(), student.getFirstname());
        assertEquals(dto.lastname(), student.getLastname());
        assertEquals(dto.email(), student.getEmail());

        verify(repository, times(1)).findById(studentId);
    }

    ;
}
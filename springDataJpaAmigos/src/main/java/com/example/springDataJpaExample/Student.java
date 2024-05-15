package com.example.springDataJpaExample;

import jakarta.persistence.*;

/**
 * Represents a Student entity in the database.
 */
@Entity(name = "Student")
@Table(
        name = "student",
        uniqueConstraints = {
                @UniqueConstraint(name = "student_email_unique", columnNames= "email" )
        }
)
public class Student {

    // Primary key
    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    // First name column
    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "Text"
    )
    private String firstName;

    // Last name column
    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "Text"
    )
    private String lastName;

    // Email column with unique constraint
    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "Text"
    )
    private String email;

    // Age column
    @Column(
            name = "age",
            nullable = false
    )
    private Integer age;

    /**
     * Constructs a new Student with the given parameters.
     *
     * @param firstName The first name of the student.
     * @param lastName  The last name of the student.
     * @param email     The email of the student.
     * @param age       The age of the student.
     */
    public Student(String firstName,
                   String lastName,
                   String email,
                   Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    /**
     * Default constructor.
     */
    public Student(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    /**
     * Returns a string representation of the student.
     *
     * @return A string representation of the student.
     */
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}

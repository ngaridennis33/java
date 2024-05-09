package com.springframeworkapp.SpringFramework.student;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.springframeworkapp.SpringFramework.school.School;
import com.springframeworkapp.SpringFramework.studentProfile.StudentProfile;
import jakarta.persistence.*;

@Entity
@Table(name = "T_Student")
public class Student {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(
            name = "c_fname",
            length = 20
    )
    private String firstname;

    private String lastname;

    @Column(unique = true)
    private String email;

    private int age;

    @ManyToOne
    @JoinColumn(
            name = "school_id"
    )
    @JsonBackReference
    private School school;


    @OneToOne(
            mappedBy = "student",
            cascade = CascadeType.ALL
    )
    private StudentProfile studentProfile;

    public Student() {
    }

    public Student(String firstname, String lastname, String email, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

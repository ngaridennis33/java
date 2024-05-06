package com.springframeworkapp.SpringFramework;

import jakarta.persistence.*;


@Entity
public class StudentProfile {

    @Id
    @GeneratedValue
    private Integer id;

    private String bio;

    @OneToOne
    @JoinColumn(
            name = "student_id"
    )
    private  Student student;

    public StudentProfile() {
    }

    public StudentProfile(String bio, Student student) {
        this.bio = bio;
        this.student = student;
    }

    public String getBio() {
        return bio;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}

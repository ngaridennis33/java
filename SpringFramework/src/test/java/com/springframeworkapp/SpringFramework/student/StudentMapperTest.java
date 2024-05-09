package com.springframeworkapp.SpringFramework.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Inside the before all method");
    }

    // Setup
    @BeforeEach
    void setUp() {
        System.out.println("Inside the before each method");
    }

    // TearDown
    @AfterEach
    void tearDown() {
        System.out.println("Inside the after each method");
    }

    @Test
    public void testMethod1(){
        System.out.println("My first Test Method");
    }

    @Test
    public void testMethod2(){
        System.out.println("My Second Test Method");
    }

}
package com.springframeworkapp.SpringFramework;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ApplicationConfig {

    @Bean
    public MyFirstClass myFirstClass(){
        return new MyFirstClass("MyFirstBean");
    }

    @Bean
    public MyFirstClass mySecondBean(){
        return new MyFirstClass("Second Bean");
    }

    @Bean
    public MyFirstClass myThirdBean(){
        return new MyFirstClass("Third Bean");
    }
}

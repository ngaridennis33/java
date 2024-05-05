package com.springframeworkapp.SpringFramework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:custom.properties")
public class MyFirstService {

    private final MyFirstClass myFirstClass;
    @Value("${my.prop}")
    private String customPropertyFromAnotherFile;


    public MyFirstService(
            @Qualifier("myFirstClass") MyFirstClass myFirstClass
    ){
        this.myFirstClass = myFirstClass;
    }


    public String tellAStory() {
        return "The dependency is saying: " + myFirstClass.sayHello();
    }


    public String getCustomPropertyFromAnotherFile() {
        return customPropertyFromAnotherFile;
    }
}

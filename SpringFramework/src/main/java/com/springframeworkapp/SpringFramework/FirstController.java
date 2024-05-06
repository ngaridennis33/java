package com.springframeworkapp.SpringFramework;


import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {

    @GetMapping("api/hello")
    public String sayHello() {
        return "Hello from my first controller";
    }

    @PostMapping("api/post")
    public String post(
            @RequestBody String message
    ) {
        return "Request accepted and message is: " + message;
    }

    @PostMapping("api/post-order")
    public String post(
            @RequestBody Order order
    ) {
        return "Request accepted and order is: " + order.toString();
    }

    @PostMapping("api/post-order-record")
    public String post(
            @RequestBody OrderRecord order
    ) {
        return "Request accepted and order is: " + order.toString();
    }

    // http://localhost:8080:/api/hello/mike
//    @GetMapping("api/hello/{user-name}")
    public String pathVar(
            @PathVariable("user-name") String userName
            ) {
        return "My value = " + userName;
    }

    // // http://localhost:8080:/api/hello?param_name=paramvalue&param_name_2=value_2
    @GetMapping("api/hello")
    public String paramVar(
            @RequestParam("first-name") String firstName,
            @RequestParam("last-name") String lastName
    ) {
        return "My value = " + firstName + " " + lastName ;
    }

}

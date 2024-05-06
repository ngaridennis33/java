package com.springframeworkapp.SpringFramework;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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


}

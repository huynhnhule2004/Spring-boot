package com.example.demo.web.rest;

import com.example.demo.dto.request.HelloRequest;
import com.example.demo.dto.respone.HelloResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class HelloResource {

    @GetMapping("/hello/{id}")
    public String hello(@PathVariable String id, String name, int age) {
        return "Hello " + id + "-" + name + ". You're " + age;
    }

    @PostMapping("/hello2")
    public HelloResponse method(@RequestBody HelloRequest request) {

        HelloResponse helloResponse = new HelloResponse();
        helloResponse.setAction(request.getAction());
        helloResponse.setTimezoneOffsetMin(request.getTimezoneOffsetMin());
        return helloResponse;
    }
}

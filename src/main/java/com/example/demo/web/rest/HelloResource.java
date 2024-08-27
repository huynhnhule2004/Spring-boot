package com.example.demo.web.rest;

import com.example.demo.dto.request.HelloRequest;
import com.example.demo.dto.respone.HelloResponse;
import com.example.demo.service.HelloService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class HelloResource {

    private final HelloService helloService;


    public HelloResource(@Qualifier("defaultHelloService") HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello/{id}")
    public String hello(@PathVariable String id, String name, int age) {
        return "Hello " + id + "-" + name + ". You're " + age;
    }

    @PostMapping("/hello2")
    public HelloResponse method(@RequestBody @Valid HelloRequest request) {

        return helloService.hello2(request);

    }

}

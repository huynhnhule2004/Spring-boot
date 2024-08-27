package com.example.demo.service.impl;

import com.example.demo.dto.request.HelloRequest;
import com.example.demo.dto.respone.HelloResponse;
import com.example.demo.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class DefaultHelloService implements HelloService {
    @Override
    public HelloResponse hello2(HelloRequest request) {
        HelloResponse helloResponse = new HelloResponse();
        helloResponse.setAction(request.getAction());
        helloResponse.setTimezoneOffsetMin(request.getTimezoneOffsetMin());
        return helloResponse;
    }
}

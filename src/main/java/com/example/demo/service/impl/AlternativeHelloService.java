package com.example.demo.service.impl;

import com.example.demo.dto.request.HelloRequest;
import com.example.demo.dto.respone.HelloResponse;
import com.example.demo.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class AlternativeHelloService implements HelloService {
    @Override
    public HelloResponse hello2(HelloRequest request) {
        HelloResponse helloResponse = new HelloResponse();

        String action = request.getAction();
        helloResponse.setAction(new StringBuilder(action).reverse().toString());

        helloResponse.setTimezoneOffsetMin(request.getTimezoneOffsetMin() + 10);
        return helloResponse;
    }
}

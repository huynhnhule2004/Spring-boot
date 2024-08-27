package com.example.demo.service;

import com.example.demo.dto.request.HelloRequest;
import com.example.demo.dto.respone.HelloResponse;
import org.springframework.stereotype.Service;

public interface HelloService {
    HelloResponse hello2(HelloRequest request);
}

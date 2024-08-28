package com.example.demo.service.impl;

import com.example.demo.service.JsonProcessingService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ReverseStringJsonService implements JsonProcessingService {

    @Override
    public Map<String, Object> process(Map<String, Object> input) {
        Map<String, Object> output = new HashMap<>();
        for (Map.Entry<String, Object> entry : input.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof String) {
                output.put(entry.getKey(), new StringBuilder((String) value).reverse().toString());
            } else {
                output.put(entry.getKey(), value);
            }
        }
        return output;
    }
}


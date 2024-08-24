package com.example.demo.web.rest;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class Calculator {

    // API để tính toán
    @PostMapping("/calculate")
    public Map<String, Object> calculate(@RequestBody Map<String, Object> payload) {
        double num1 = Double.parseDouble(payload.get("num1").toString());
        double num2 = Double.parseDouble(payload.get("num2").toString());
        String operation = payload.get("operation").toString();

        double result = switch (operation) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num2 != 0 ? num1 / num2 : Double.NaN; // Check chia cho 0
            default -> throw new IllegalArgumentException("Invalid operation: " + operation);
        };

        Map<String, Object> response = new HashMap<>();
        response.put("result", result);
        return response;
    }

    // API để viết hoa tất cả key và value trong JSON
    @PostMapping("/uppercase")
    public Map<String, Object> uppercase(@RequestBody Map<String, Object> payload) {
        Map<String, Object> uppercasedPayload = new HashMap<>();

        for (Map.Entry<String, Object> entry : payload.entrySet()) {
            String key = entry.getKey().toUpperCase();
            Object value = entry.getValue();

            if (value instanceof String) {
                value = ((String) value).toUpperCase();
            }

            uppercasedPayload.put(key, value);
        }

        return uppercasedPayload;
    }
}

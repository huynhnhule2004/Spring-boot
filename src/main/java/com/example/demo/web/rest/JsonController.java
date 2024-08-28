package com.example.demo.web.rest;

import com.example.demo.service.JsonProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/json")
public class JsonController {

    private final JsonProcessingService jsonProcessingService;

    @Autowired
    public JsonController(@Qualifier("reverseStringJsonService") JsonProcessingService jsonProcessingService) {
        this.jsonProcessingService = jsonProcessingService;
    }

    @PostMapping("/process")
    public ResponseEntity<Map<String, Object>> processJson(@RequestBody Map<String, Object> input) {
        Map<String, Object> processedJson = jsonProcessingService.process(input);
        return ResponseEntity.ok(processedJson);
    }
}


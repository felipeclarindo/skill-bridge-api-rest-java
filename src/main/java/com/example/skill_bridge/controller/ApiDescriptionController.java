package com.example.skill_bridge.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.time.Instant;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiDescriptionController {

    @GetMapping
    public ResponseEntity<?> info() {
        return ResponseEntity.ok(Map.of(
                "name", "SkillBridge API",
                "version", "1.0.0",
                "status", "Online",
                "timestamp", Instant.now().toString()
        ));
    }
}

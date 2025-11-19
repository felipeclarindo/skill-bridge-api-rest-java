package com.example.skill_bridge.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.skill_bridge.entity.LearningPath;
import com.example.skill_bridge.service.LearningPathService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/learning-paths")
public class LearningPathController {

    private final LearningPathService service;

    public LearningPathController(LearningPathService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<LearningPath>> all(Pageable p) {
        return ResponseEntity.ok(service.findAll(p));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LearningPath> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<LearningPath> create(@Valid @RequestBody LearningPath lp) {
        return ResponseEntity.status(201).body(service.create(lp));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @Valid @RequestBody LearningPath lp) {
        service.update(id, lp);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

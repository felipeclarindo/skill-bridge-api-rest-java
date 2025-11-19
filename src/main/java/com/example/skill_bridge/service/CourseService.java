package com.example.skill_bridge.service;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.skill_bridge.repository.CourseRepository;
import com.example.skill_bridge.entity.Course;

@Service
public class CourseService {

    private final CourseRepository repo;

    public CourseService(CourseRepository repo) {
        this.repo = repo;
    }

    public Page<Course> findAll(Pageable p) {
        return repo.findAll(p);
    }

    public Course findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
    }

    public Course create(Course c) {
        return repo.save(c);
    }

    public Course update(Long id, Course c) {
        c.setId(id);
        return repo.save(c);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}

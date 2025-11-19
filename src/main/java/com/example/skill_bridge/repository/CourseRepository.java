package com.example.skill_bridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.skill_bridge.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}

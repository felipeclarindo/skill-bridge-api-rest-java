package com.example.skill_bridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.skill_bridge.entity.LearningPath;

public interface LearningPathRepository extends JpaRepository<LearningPath, Long> {
}

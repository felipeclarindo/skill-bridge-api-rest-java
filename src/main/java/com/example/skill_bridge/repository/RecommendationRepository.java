package com.example.skill_bridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.skill_bridge.entity.Recommendation;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {
}

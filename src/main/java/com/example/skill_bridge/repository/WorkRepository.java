package com.example.skill_bridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.skill_bridge.entity.Work;

public interface WorkRepository extends JpaRepository<Work, Long> {
}

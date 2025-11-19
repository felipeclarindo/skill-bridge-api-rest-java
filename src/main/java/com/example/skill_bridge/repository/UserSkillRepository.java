package com.example.skill_bridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.skill_bridge.entity.UserSkill;

public interface UserSkillRepository extends JpaRepository<UserSkill, Long> {
}

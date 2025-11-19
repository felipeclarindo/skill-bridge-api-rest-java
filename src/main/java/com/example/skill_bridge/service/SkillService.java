package com.example.skill_bridge.service;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.skill_bridge.repository.SkillRepository;
import com.example.skill_bridge.entity.Skill;

@Service
public class SkillService {

    private final SkillRepository repo;

    public SkillService(SkillRepository repo) {
        this.repo = repo;
    }

    public Page<Skill> findAll(Pageable p) {
        return repo.findAll(p);
    }

    public Skill findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Skill not found"));
    }

    public Skill create(Skill s) {
        return repo.save(s);
    }

    public Skill update(Long id, Skill s) {
        s.setId(id);
        return repo.save(s);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}

package com.example.skill_bridge.service;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.skill_bridge.repository.LearningPathRepository;
import com.example.skill_bridge.entity.LearningPath;

@Service
public class LearningPathService {

    private final LearningPathRepository repo;

    public LearningPathService(LearningPathRepository repo) {
        this.repo = repo;
    }

    public Page<LearningPath> findAll(Pageable p) {
        return repo.findAll(p);
    }

    public LearningPath findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("LearningPath not found"));
    }

    public LearningPath create(LearningPath lp) {
        return repo.save(lp);
    }

    public LearningPath update(Long id, LearningPath lp) {
        lp.setId(id);
        return repo.save(lp);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}

package com.example.skill_bridge.service;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.skill_bridge.repository.WorkRepository;
import com.example.skill_bridge.entity.Work;

@Service
public class WorkService {

    private final WorkRepository repo;

    public WorkService(WorkRepository repo) {
        this.repo = repo;
    }

    public Page<Work> findAll(Pageable p) {
        return repo.findAll(p);
    }

    public Work findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Work not found"));
    }

    public Work create(Work w) {
        return repo.save(w);
    }

    public Work update(Long id, Work w) {
        w.setId(id);
        return repo.save(w);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}

package com.example.skill_bridge.service;

import org.springframework.stereotype.Service;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import com.example.skill_bridge.repository.RecommendationRepository;
import com.example.skill_bridge.entity.Recommendation;
import com.example.skill_bridge.config.RabbitConfig;

import java.util.List;

@Service
public class RecommendationService {

    private final RecommendationRepository repo;
    private final RabbitTemplate rabbit;

    public RecommendationService(RecommendationRepository repo, RabbitTemplate rabbit) {
        this.repo = repo;
        this.rabbit = rabbit;
    }

    public List<Recommendation> getAll() {
        return repo.findAll();
    }

    public Recommendation getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Rec not found"));
    }

    public Recommendation create(Recommendation r) {
        Recommendation saved = repo.save(r);
        // publish to queue
        rabbit.convertAndSend(RabbitConfig.RECOMMENDATIONS_QUEUE, saved.getId());
        return saved;
    }

    public Recommendation update(Long id, Recommendation r) {
        r.setId(id);
        return repo.save(r);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}

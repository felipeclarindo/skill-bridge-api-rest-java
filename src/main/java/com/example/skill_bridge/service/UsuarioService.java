package com.example.skill_bridge.service;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import com.example.skill_bridge.repository.UsuarioRepository;
import com.example.skill_bridge.entity.Usuario;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository repo;

    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    @Cacheable("usuarios")
    public Page<Usuario> findAll(Pageable p) {
        return repo.findAll(p);
    }

    public Optional<Usuario> findById(Long id) {
        return repo.findById(id);
    }

    public Usuario create(Usuario u) {
        return repo.save(u);
    }

    @CacheEvict(value = "usuarios", key = "#id")
    public Usuario update(Long id, Usuario u) {
        return repo.findById(id).map(existing -> {
            existing.setNome(u.getNome());
            existing.setEmail(u.getEmail());
            return repo.save(existing);
        }).orElseThrow(() -> new RuntimeException("Usuario not found"));
    }

    @CacheEvict(value = "usuarios", allEntries = true)
    public void delete(Long id) {
        repo.deleteById(id);
    }
}

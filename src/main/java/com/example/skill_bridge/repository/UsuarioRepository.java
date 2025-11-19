package com.example.skill_bridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.skill_bridge.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}

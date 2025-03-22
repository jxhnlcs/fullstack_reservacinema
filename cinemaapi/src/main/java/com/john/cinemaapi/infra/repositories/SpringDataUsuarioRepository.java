package com.john.cinemaapi.infra.repositories;

import com.john.cinemaapi.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataUsuarioRepository extends JpaRepository<Usuario, Long> {}
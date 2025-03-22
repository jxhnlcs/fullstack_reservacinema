package com.john.cinemaapi.infra.repositories;

import com.john.cinemaapi.domain.filme.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataFilmeRepository extends JpaRepository<Filme, Long> {}
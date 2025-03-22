package com.john.cinemaapi.infra.repositories;

import com.john.cinemaapi.domain.sessao.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataSessaoRepository extends JpaRepository<Sessao, Long> {}
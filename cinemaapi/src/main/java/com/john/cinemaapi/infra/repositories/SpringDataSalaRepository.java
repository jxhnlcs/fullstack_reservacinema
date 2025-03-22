package com.john.cinemaapi.infra.repositories;

import com.john.cinemaapi.domain.sala.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataSalaRepository extends JpaRepository<Sala, Long> {}
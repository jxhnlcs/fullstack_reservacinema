package com.john.cinemaapi.infra.repositories;

import com.john.cinemaapi.domain.reserva.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataReservaRepository extends JpaRepository<Reserva, Long> {}
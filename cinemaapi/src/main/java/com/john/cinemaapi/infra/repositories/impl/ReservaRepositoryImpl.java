package com.john.cinemaapi.infra.repositories.impl;

import com.john.cinemaapi.domain.reserva.Reserva;
import com.john.cinemaapi.domain.reserva.ReservaRepository;
import com.john.cinemaapi.infra.repositories.SpringDataReservaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservaRepositoryImpl implements ReservaRepository {

    private final SpringDataReservaRepository jpa;

    @Autowired
    public ReservaRepositoryImpl(SpringDataReservaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Reserva salvar(Reserva reserva) {
        return jpa.save(reserva);
    }

    @Override
    public List<Reserva> listarTodas() {
        return jpa.findAll();
    }

    @Override
    public Optional<Reserva> buscarPorId(Long id) {
        return jpa.findById(id);
    }

    @Override
    public void remover(Long id) {
        jpa.deleteById(id);
    }
}
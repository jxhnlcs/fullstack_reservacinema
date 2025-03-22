package com.john.cinemaapi.infra.repositories.impl;

import com.john.cinemaapi.domain.sala.Sala;
import com.john.cinemaapi.domain.sala.SalaRepository;
import com.john.cinemaapi.infra.repositories.SpringDataSalaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SalaRepositoryImpl implements SalaRepository {

    private final SpringDataSalaRepository jpa;

    @Autowired
    public SalaRepositoryImpl(SpringDataSalaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Sala salvar(Sala sala) {
        return jpa.save(sala);
    }

    @Override
    public List<Sala> listarTodas() {
        return jpa.findAll();
    }

    @Override
    public Optional<Sala> buscarPorId(Long id) {
        return jpa.findById(id);
    }

    @Override
    public void remover(Long id) {
        jpa.deleteById(id);
    }
}
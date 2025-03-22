package com.john.cinemaapi.infra.repositories.impl;

import com.john.cinemaapi.domain.filme.Filme;
import com.john.cinemaapi.domain.filme.FilmeRepository;
import com.john.cinemaapi.infra.repositories.SpringDataFilmeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FilmeRepositoryImpl implements FilmeRepository {

    private final SpringDataFilmeRepository jpa;

    @Autowired
    public FilmeRepositoryImpl(SpringDataFilmeRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Filme salvar(Filme filme) {
        return jpa.save(filme);
    }

    @Override
    public List<Filme> listarTodos() {
        return jpa.findAll();
    }

    @Override
    public Optional<Filme> buscarPorId(Long id) {
        return jpa.findById(id);
    }

    @Override
    public void remover(Long id) {
        jpa.deleteById(id);
    }
}
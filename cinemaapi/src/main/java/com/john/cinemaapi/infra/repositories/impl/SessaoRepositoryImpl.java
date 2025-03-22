package com.john.cinemaapi.infra.repositories.impl;

import com.john.cinemaapi.domain.sessao.Sessao;
import com.john.cinemaapi.domain.sessao.SessaoRepository;
import com.john.cinemaapi.infra.repositories.SpringDataSessaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SessaoRepositoryImpl implements SessaoRepository {

    private final SpringDataSessaoRepository jpa;

    @Autowired
    public SessaoRepositoryImpl(SpringDataSessaoRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Sessao salvar(Sessao sessao) {
        return jpa.save(sessao);
    }

    @Override
    public List<Sessao> listarTodas() {
        return jpa.findAll();
    }

    @Override
    public Optional<Sessao> buscarPorId(Long id) {
        return jpa.findById(id);
    }

    @Override
    public void remover(Long id) {
        jpa.deleteById(id);
    }
}
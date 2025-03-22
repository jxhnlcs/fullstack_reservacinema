package com.john.cinemaapi.infra.repositories.impl;

import com.john.cinemaapi.domain.usuario.Usuario;
import com.john.cinemaapi.domain.usuario.UsuarioRepository;
import com.john.cinemaapi.infra.repositories.SpringDataUsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

    private final SpringDataUsuarioRepository jpa;

    @Autowired
    public UsuarioRepositoryImpl(SpringDataUsuarioRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Usuario salvar(Usuario usuario) {
        return jpa.save(usuario);
    }

    @Override
    public List<Usuario> listarTodos() {
        return jpa.findAll();
    }

    @Override
    public Optional<Usuario> buscarPorId(Long id) {
        return jpa.findById(id);
    }

    @Override
    public void remover(Long id) {
        jpa.deleteById(id);
    }
}
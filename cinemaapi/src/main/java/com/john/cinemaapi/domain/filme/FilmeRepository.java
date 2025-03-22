package com.john.cinemaapi.domain.filme;

import java.util.List;
import java.util.Optional;

public interface FilmeRepository {
    Filme salvar(Filme filme);
    List<Filme> listarTodos();
    Optional<Filme> buscarPorId(Long id);
    void remover(Long id);
}
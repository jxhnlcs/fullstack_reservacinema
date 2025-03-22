package com.john.cinemaapi.domain.sala;

import java.util.List;
import java.util.Optional;

public interface SalaRepository {
    Sala salvar(Sala sala);
    List<Sala> listarTodas();
    Optional<Sala> buscarPorId(Long id);
    void remover(Long id);
}
package com.john.cinemaapi.domain.reserva;

import java.util.List;
import java.util.Optional;

public interface ReservaRepository {
    Reserva salvar(Reserva reserva);
    List<Reserva> listarTodas();
    Optional<Reserva> buscarPorId(Long id);
    void remover(Long id);
}
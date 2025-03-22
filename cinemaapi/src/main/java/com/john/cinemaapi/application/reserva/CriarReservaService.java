package com.john.cinemaapi.application.reserva;

import com.john.cinemaapi.domain.reserva.Reserva;
import com.john.cinemaapi.domain.reserva.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CriarReservaService {

    private final ReservaRepository reservaRepository;

    @Autowired
    public CriarReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public Reserva executar(Reserva reserva) {
        return reservaRepository.salvar(reserva);
    }

    public List<Reserva> listarTodas() {
        return reservaRepository.listarTodas();
    }

    public Optional<Reserva> buscarPorId(Long id) {
        return reservaRepository.buscarPorId(id);
    }

    public void remover(Long id) {
        reservaRepository.remover(id);
    }
}
package com.john.cinemaapi.application.sala;

import com.john.cinemaapi.domain.sala.Sala;
import com.john.cinemaapi.domain.sala.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadastrarSalaService {

    private final SalaRepository salaRepository;

    @Autowired
    public CadastrarSalaService(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    public Sala executar(Sala sala) {
        return salaRepository.salvar(sala);
    }

    public List<Sala> listarTodas() {
        return salaRepository.listarTodas();
    }

    public Optional<Sala> buscarPorId(Long id) {
        return salaRepository.buscarPorId(id);
    }

    public void remover(Long id) {
        salaRepository.remover(id);
    }
}
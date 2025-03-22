package com.john.cinemaapi.web.controllers;

import com.john.cinemaapi.application.sala.CadastrarSalaService;
import com.john.cinemaapi.domain.sala.Sala;
import com.john.cinemaapi.web.dto.SalaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salas")
public class SalaController {

    @Autowired
    private CadastrarSalaService service;

    @PostMapping
    public Sala criar(@RequestBody SalaDTO dto) {
        Sala sala = Sala.builder()
                .nome(dto.getNome())
                .capacidade(dto.getCapacidade())
                .build();
        return service.executar(sala);
    }

    @GetMapping
    public List<Sala> listar() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public Sala buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Sala não encontrada"));
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        service.remover(id);
    }
}
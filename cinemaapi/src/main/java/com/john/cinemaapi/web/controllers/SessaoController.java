package com.john.cinemaapi.web.controllers;

import com.john.cinemaapi.application.sessao.CadastrarSessaoService;
import com.john.cinemaapi.domain.filme.Filme;
import com.john.cinemaapi.domain.filme.FilmeRepository;
import com.john.cinemaapi.domain.sala.Sala;
import com.john.cinemaapi.domain.sala.SalaRepository;
import com.john.cinemaapi.domain.sessao.Sessao;
import com.john.cinemaapi.web.dto.SessaoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/sessoes")
public class SessaoController {

    @Autowired
    private CadastrarSessaoService service;

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private SalaRepository salaRepository;

    @PostMapping
    public Sessao criar(@RequestBody SessaoDTO dto) {
        Filme filme = filmeRepository.buscarPorId(dto.getFilmeId())
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));
        Sala sala = salaRepository.buscarPorId(dto.getSalaId())
                .orElseThrow(() -> new RuntimeException("Sala não encontrada"));
        LocalDateTime horario = LocalDateTime.parse(dto.getHorario());

        Sessao sessao = Sessao.builder()
                .filme(filme)
                .sala(sala)
                .horario(horario)
                .build();

        return service.executar(sessao);
    }

    @GetMapping
    public List<Sessao> listar() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public Sessao buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Sessão não encontrada"));
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        service.remover(id);
    }
}
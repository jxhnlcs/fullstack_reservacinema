package com.john.cinemaapi.web.controllers;

import com.john.cinemaapi.application.filme.CadastrarFilmeService;
import com.john.cinemaapi.domain.filme.Filme;
import com.john.cinemaapi.web.dto.FilmeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/filmes")
public class FilmeController {

    @Autowired
    private CadastrarFilmeService service;

    @PostMapping
    public Filme criar(@RequestBody FilmeDTO dto) {
        Filme filme = Filme.builder()
                .titulo(dto.getTitulo())
                .descricao(dto.getDescricao())
                .duracaoEmMinutos(dto.getDuracaoEmMinutos())
                .build();
        return service.executar(filme);
    }

    @GetMapping
    public List<Filme> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Filme buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        service.remover(id);
    }
}
package com.john.cinemaapi.web.controllers;

import com.john.cinemaapi.application.reserva.CriarReservaService;
import com.john.cinemaapi.domain.reserva.Reserva;
import com.john.cinemaapi.domain.usuario.Usuario;
import com.john.cinemaapi.domain.usuario.UsuarioRepository;
import com.john.cinemaapi.domain.sessao.Sessao;
import com.john.cinemaapi.domain.sessao.SessaoRepository;
import com.john.cinemaapi.web.dto.ReservaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private CriarReservaService service;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private SessaoRepository sessaoRepository;

    @PostMapping
    public Reserva criar(@RequestBody ReservaDTO dto) {
        Usuario usuario = usuarioRepository.buscarPorId(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Sessao sessao = sessaoRepository.buscarPorId(dto.getSessaoId())
                .orElseThrow(() -> new RuntimeException("Sessão não encontrada"));

        Reserva reserva = Reserva.builder()
                .usuario(usuario)
                .sessao(sessao)
                .assento(dto.getAssento())
                .build();

        return service.executar(reserva);
    }

    @GetMapping
    public List<Reserva> listar() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public Reserva buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada"));
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        service.remover(id);
    }
}
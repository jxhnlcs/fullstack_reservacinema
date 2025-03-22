package com.john.cinemaapi.application.filme;

import com.john.cinemaapi.domain.filme.Filme;
import com.john.cinemaapi.domain.filme.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadastrarFilmeService {

    private final FilmeRepository filmeRepository;

    @Autowired
    public CadastrarFilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    public Filme executar(Filme filme) {
        return filmeRepository.salvar(filme);
    }

    public List<Filme> listarTodos() {
        return filmeRepository.listarTodos();
    }

    public Optional<Filme> buscarPorId(Long id) {
        return filmeRepository.buscarPorId(id);
    }

    public void remover(Long id) {
        filmeRepository.remover(id);
    }
}
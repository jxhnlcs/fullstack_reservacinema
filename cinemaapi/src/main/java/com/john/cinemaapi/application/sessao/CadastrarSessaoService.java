package com.john.cinemaapi.application.sessao;

import com.john.cinemaapi.domain.sessao.Sessao;
import com.john.cinemaapi.domain.sessao.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadastrarSessaoService {

    private final SessaoRepository sessaoRepository;

    @Autowired
    public CadastrarSessaoService(SessaoRepository sessaoRepository) {
        this.sessaoRepository = sessaoRepository;
    }

    public Sessao executar(Sessao sessao) {
        return sessaoRepository.salvar(sessao);
    }

    public List<Sessao> listarTodas() {
        return sessaoRepository.listarTodas();
    }

    public Optional<Sessao> buscarPorId(Long id) {
        return sessaoRepository.buscarPorId(id);
    }

    public void remover(Long id) {
        sessaoRepository.remover(id);
    }
}
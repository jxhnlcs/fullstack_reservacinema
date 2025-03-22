package com.john.cinemaapi.domain.sessao;

import java.util.List;
import java.util.Optional;

public interface SessaoRepository {
    Sessao salvar(Sessao sessao);
    List<Sessao> listarTodas();
    Optional<Sessao> buscarPorId(Long id);
    void remover(Long id);
}
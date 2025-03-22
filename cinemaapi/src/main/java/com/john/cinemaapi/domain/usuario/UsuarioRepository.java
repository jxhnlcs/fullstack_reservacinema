package com.john.cinemaapi.domain.usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository {
    Usuario salvar(Usuario usuario);
    List<Usuario> listarTodos();
    Optional<Usuario> buscarPorId(Long id);
    void remover(Long id);
}
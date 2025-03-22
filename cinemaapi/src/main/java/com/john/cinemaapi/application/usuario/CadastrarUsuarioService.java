package com.john.cinemaapi.application.usuario;

import com.john.cinemaapi.domain.usuario.Usuario;
import com.john.cinemaapi.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadastrarUsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public CadastrarUsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario executar(Usuario usuario) {
        return usuarioRepository.salvar(usuario);
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.listarTodos();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.buscarPorId(id);
    }

    public void remover(Long id) {
        usuarioRepository.remover(id);
    }
}
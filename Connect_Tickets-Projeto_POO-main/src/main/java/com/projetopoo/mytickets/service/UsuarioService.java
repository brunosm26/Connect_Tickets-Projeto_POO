package com.projetopoo.mytickets.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projetopoo.mytickets.model.Usuario;
import com.projetopoo.mytickets.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    // Cria e salva um novo usuário no banco
    public Usuario criarUsuario(Usuario usuario) {
        return repository.save(usuario);
    }

    // Retorna todos os usuários cadastrados
    public List<Usuario> listarUsuarios() {
        return repository.findAll();
    }

    // Corrigido: busca um usuário pelo id, lança erro se não encontrar
    public Usuario buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com id: " + id));
    }
}

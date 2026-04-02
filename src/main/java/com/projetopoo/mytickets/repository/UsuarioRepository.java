package com.projetopoo.mytickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetopoo.mytickets.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

}

package com.projetopoo.mytickets.repository;

import com.projetopoo.mytickets.model.Visita;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VisitaRepository extends JpaRepository<Visita, Long> {
    Page<Visita> findByRequesterIdUsuario(Long idUsuario, Pageable pageable);
}

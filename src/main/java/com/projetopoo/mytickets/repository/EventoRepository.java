package com.projetopoo.mytickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.projetopoo.mytickets.model.Evento;
import com.projetopoo.mytickets.model.enums.EventCategory;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {

    Page<Evento> findByCategory(EventCategory category, Pageable pageable);
}

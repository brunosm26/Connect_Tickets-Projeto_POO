package com.projetopoo.mytickets.controller;

import com.projetopoo.mytickets.model.dtos.EventoDTO;
import com.projetopoo.mytickets.model.enums.EventCategory;
import com.projetopoo.mytickets.service.EventoService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {

    private final EventoService service;

    public
    EventoController(EventoService service) {
        this.service = service;
    }

    @GetMapping
    public Page<EventoDTO> listar(
            @RequestParam(required = false) EventCategory category,
            @PageableDefault(size = 10, sort = "idEvento", direction = Sort.Direction.ASC) Pageable pageable) {
        return service.listarEventos(category, pageable).map(service::toDTO);
    }

    @GetMapping("/{idEvento}")
    public EventoDTO buscarPorId(@PathVariable Long idEvento) {
        return service.toDTO(service.buscarPorId(idEvento));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public EventoDTO criar(@Valid @RequestBody EventoDTO dto) {
        return service.toDTO(service.criarEvento(dto));
    }

    // gerenciamento de admins do evento (tabela event_admins)
    @PostMapping("/{idEvento}/admins/{idUsuario}")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public EventoDTO adicionarAdmin(@PathVariable Long idEvento, @PathVariable Long idUsuario) {
        return service.toDTO(service.adicionarAdmin(idEvento, idUsuario));
    }

    @DeleteMapping("/{idEvento}/admins/{idUsuario}")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerAdmin(@PathVariable Long idEvento, @PathVariable Long idUsuario) {
        service.removerAdmin(idEvento, idUsuario);
    }

    @PutMapping("/{idEvento}")
    @PreAuthorize("hasRole('ADMIN')")
    public EventoDTO atualizar(@PathVariable Long idEvento, @Valid @RequestBody EventoDTO dto) {
        return service.toDTO(service.atualizarEvento(idEvento, dto));
    }

    @DeleteMapping("/{idEvento}")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long idEvento) {
        service.deletarEvento(idEvento);
    }
}
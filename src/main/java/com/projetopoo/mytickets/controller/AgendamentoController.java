package com.projetopoo.mytickets.controller;

import com.projetopoo.mytickets.model.dtos.AgendamentoDTO;
import com.projetopoo.mytickets.model.dtos.AgendamentoResponseDTO;
import com.projetopoo.mytickets.service.AgendamentoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoController {

    private final AgendamentoService service;

    public AgendamentoController(AgendamentoService service) {
        this.service = service;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Page<AgendamentoResponseDTO> listar(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "asc") String sort) {
        Sort.Direction direction = Sort.Direction.fromString(sort);
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, "idAgendamento"));
        return service.listarAgendamentos(pageable).map(service::toResponseDTO);
    }

    @GetMapping("/{idAgendamento}")
    public AgendamentoResponseDTO buscarPorId(@PathVariable Long idAgendamento) {
        return service.toResponseDTO(service.buscarPorId(idAgendamento));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AgendamentoResponseDTO criar(@Valid @RequestBody AgendamentoDTO dto) {
        return service.toResponseDTO(service.criarAgendamento(dto));
    }

    @DeleteMapping("/{idAgendamento}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long idAgendamento) {
        service.excluirAgendamento(idAgendamento);
    }
}

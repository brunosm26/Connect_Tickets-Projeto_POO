package com.projetopoo.mytickets.controller;

import com.projetopoo.mytickets.model.dtos.VisitaDTO;
import com.projetopoo.mytickets.model.dtos.VisitaResponseDTO;
import com.projetopoo.mytickets.service.VisitaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@RestController
@RequestMapping("/api/visitas")
public class VisitaController {

    private final VisitaService service;

    public VisitaController(VisitaService service) {
        this.service = service;
    }

    @GetMapping
    public Page<VisitaResponseDTO> listar(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "asc") String sort) {
        Sort.Direction direction = Sort.Direction.fromString(sort);
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, "idVisita"));
        return service.listarVisitas(pageable).map(service::toResponseDTO);
    }

    @GetMapping("/{idVisita}")
    public VisitaResponseDTO buscarPorId(@PathVariable Long idVisita) {
        return service.toResponseDTO(service.buscarPorId(idVisita));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VisitaResponseDTO criar(@Valid @RequestBody VisitaDTO dto) {
        return service.toResponseDTO(service.criarVisita(dto));
    }

    @DeleteMapping("/{idVisita}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long idVisita) {
        service.excluirVisita(idVisita);
    }
}

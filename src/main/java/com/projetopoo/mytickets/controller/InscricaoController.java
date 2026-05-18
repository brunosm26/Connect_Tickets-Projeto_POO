package com.projetopoo.mytickets.controller;

import com.projetopoo.mytickets.model.dtos.CriarInscricaoDTO;
import com.projetopoo.mytickets.model.dtos.InscricaoResponseDTO;
import com.projetopoo.mytickets.service.InscricaoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscricoes")
public class InscricaoController {

    private final InscricaoService service;

    public InscricaoController(InscricaoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<InscricaoResponseDTO> criar(@Valid @RequestBody CriarInscricaoDTO dto,
            Authentication authentication) {
        String emailUsuarioLogado = authentication.getName();
        InscricaoResponseDTO resposta = service.criar(dto, emailUsuarioLogado);
        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
    }

    @GetMapping
    @org.springframework.security.access.prepost.PreAuthorize("hasRole('ADMIN')")
    public List<InscricaoResponseDTO> listarTodas() {
        return service.listarTodas().stream()
                .map(service::toResponseDTO)
                .toList();
    }

    @GetMapping("/me")
    public List<InscricaoResponseDTO> listarMinhasInscricoes() {
        return service.listarInscricoesUsuarioLogado().stream()
                .map(service::toResponseDTO)
                .toList();
    }

    @DeleteMapping("/{idInscricao}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long idInscricao) {
        service.excluirInscricao(idInscricao);
    }
}

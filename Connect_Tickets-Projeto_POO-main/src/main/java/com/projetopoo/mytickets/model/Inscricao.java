package com.projetopoo.mytickets.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Inscricao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // O banco gera o id, não mande no JSON
    private Long id;

    // @JsonIgnoreProperties evita loop infinito na hora de converter para JSON.
    // Sem isso, Inscricao -> Usuario -> lista de inscricoes -> Inscricao -> ... (loop!)
    @ManyToOne
    @JsonIgnoreProperties("inscricoes")
    private Usuario usuario;

    @ManyToOne
    @JsonIgnoreProperties("inscricoes")
    private Evento evento;

    private LocalDate dataInscricao;

    // Construtor vazio obrigatório para o JPA funcionar
    public Inscricao() {
    }

    public Long getId() { return id; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Evento getEvento() { return evento; }
    public void setEvento(Evento evento) { this.evento = evento; }

    public LocalDate getDataInscricao() { return dataInscricao; }
    public void setDataInscricao(LocalDate dataInscricao) { this.dataInscricao = dataInscricao; }
}

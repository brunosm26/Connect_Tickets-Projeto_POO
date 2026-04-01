package com.projetopoo.mytickets.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // O banco gera o id automaticamente, não mande no JSON!
    private Long id;

    private String nome;
    private String email;

    // Construtor vazio obrigatório para o JPA funcionar
    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    // Sem setId() — id não pode ser alterado manualmente

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}

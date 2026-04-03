package com.projetopoo.mytickets.model;

import com.projetopoo.mytickets.model.enums.EventCategory;
import com.projetopoo.mytickets.model.enums.SuggestionStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "sugestao")
public class Sugestao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 5, max = 50)
    @Column(name = "nomeEvento", nullable = false)
    private String nomeEvento;

    @Column(name = "descricao", length = 500)
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private EventCategory category;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private SuggestionStatus status;

    @ManyToOne
    @JoinColumn(name = "criador_id")
    private Usuario criador;

    public Sugestao() {
    }

    @PrePersist
    protected void onCreate() {
        if (this.status == null) {
            this.status = SuggestionStatus.PENDENTE;
        }
    }

    public Long getId() { return id; }

    public String getNomeEvento() { return nomeEvento; }
    public void setNomeEvento(String nomeEvento) { this.nomeEvento = nomeEvento; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public EventCategory getCategory() { return category; }
    public void setCategory(EventCategory category) { this.category = category; }

    public SuggestionStatus getStatus() { return status; }
    public void setStatus(SuggestionStatus status) { this.status = status; }

    public Usuario getCriador() { return criador; }
    public void setCriador(Usuario criador) { this.criador = criador; }
}

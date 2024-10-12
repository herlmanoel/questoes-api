package org.questoes.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Pergunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String texto;

    @OneToMany(mappedBy = "pergunta", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Alternativa> alternativas = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "conteudo_id")
    public Conteudo conteudo;

    public Pergunta() {}

    public Pergunta(String texto, Conteudo conteudo) {
        this.texto = texto;
        this.conteudo = conteudo;
    }
}
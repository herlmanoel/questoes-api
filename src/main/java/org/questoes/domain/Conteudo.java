package org.questoes.domain;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Conteudo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String titulo;

    @OneToMany(mappedBy = "conteudo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonbTransient
    public List<Pergunta> perguntas;

    @OneToMany(mappedBy = "conteudoPai", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonbTransient
    public List<Conteudo> subConteudos;

    @ManyToOne
    @JoinColumn(name = "conteudo_pai_id")
    @JsonbTransient
    public Conteudo conteudoPai;

    public Conteudo() {}

    public Conteudo(String titulo) {
        this.titulo = titulo;
    }
}

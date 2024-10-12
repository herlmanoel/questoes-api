package org.questoes.domain;


import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;

@Entity
public class Alternativa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String texto;
    public boolean correta;

    @ManyToOne
    @JoinColumn(name = "pergunta_id")
    @JsonbTransient
    public Pergunta pergunta;

    public Alternativa() {}

    public Alternativa(String texto, boolean correta, Pergunta pergunta) {
        this.texto = texto;
        this.correta = correta;
        this.pergunta = pergunta;
    }
}

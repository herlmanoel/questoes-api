package org.questoes.domain.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.questoes.domain.Conteudo;

@ApplicationScoped
public class ConteudoRepository implements PanacheRepository<Conteudo> {
}
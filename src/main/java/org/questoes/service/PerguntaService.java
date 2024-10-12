package org.questoes.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.questoes.domain.Alternativa;
import org.questoes.domain.Conteudo;
import org.questoes.domain.Pergunta;
import org.questoes.domain.repository.ConteudoRepository;
import org.questoes.domain.repository.PerguntaRepository;
import org.questoes.rest.dto.AlternativaDTO;
import org.questoes.rest.dto.CriarPerguntaDTO;

import java.util.List;

@ApplicationScoped
public class PerguntaService {

    @Inject
    PerguntaRepository perguntaRepository;

    @Inject
    ConteudoRepository conteudoRepository;

    @Transactional
    public Pergunta criarPergunta(CriarPerguntaDTO perguntaDTO) {
        Conteudo conteudo = conteudoRepository.findById(perguntaDTO.conteudo());

        if (conteudo == null) {
            throw new IllegalArgumentException("Conteúdo não encontrado");
        }

        Pergunta pergunta = new Pergunta(perguntaDTO.texto(), conteudo);

        for (AlternativaDTO alternativaDTO : perguntaDTO.alternativas()) {
            Alternativa alternativa = new Alternativa(alternativaDTO.texto(), alternativaDTO.correta(), pergunta);
            pergunta.alternativas.add(alternativa);
        }

        perguntaRepository.persist(pergunta);

        return pergunta;
    }

    @Transactional
    public void criarPerguntas(List<CriarPerguntaDTO> perguntasDTO) {
        perguntasDTO.forEach(this::criarPergunta);
    }

    public List<Pergunta> buscarPerguntasPorConteudo(Long conteudoId) {
        return perguntaRepository.buscarPorConteudo(conteudoId);
    }

    public List<Pergunta> buscarPerguntasPorConteudos(List<Long> conteudoIds) {
        return perguntaRepository.buscarPorConteudos(conteudoIds);
    }
}

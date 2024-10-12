package org.questoes.rest;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.questoes.domain.Pergunta;
import org.questoes.rest.dto.CriarPerguntaDTO;
import org.questoes.service.PerguntaService;

import java.util.List;

@Path("/perguntas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PerguntaRest {

    @Inject
    PerguntaService perguntaService;

    @POST
    public void criarPerguntas(List<CriarPerguntaDTO> perguntasDTO) {
        perguntaService.criarPerguntas(perguntasDTO);
    }

    @GET
    @Path("/conteudo/{conteudoId}")
    public List<Pergunta> buscarPerguntasPorConteudo(@PathParam("conteudoId") Long conteudoId) {
        System.out.println("conteudoId = "+ conteudoId);
        return perguntaService.buscarPerguntasPorConteudo(conteudoId);
    }

    @POST
    @Path("/conteudos")
    public List<Pergunta> buscarPerguntasPorConteudos(List<Long> conteudoIds) {
        return perguntaService.buscarPerguntasPorConteudos(conteudoIds);
    }
}

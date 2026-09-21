package com.aguiabranca.ConectaGab.dto;

import com.aguiabranca.ConectaGab.model.*;

import java.time.LocalDate;
import java.util.List;

public record IdeaExhibitionDTO(
        String id,
        String titulo,
        String descricao,
        String categoria,
        User autor,
        IdeaStatus status,
        Priority prioridade,
        String impactoEsperado,
        List<String> tags,
        LocalDate dataCriacao,
        StrategicGuideline estrategia
) {

    public IdeaExhibitionDTO(Idea idea) {
        this(
                idea.getId(),
                idea.getTitulo(),
                idea.getDescricao(),
                idea.getCategoria(),
                idea.getAutor(),
                idea.getStatus(),
                idea.getPrioridade(),
                idea.getImpactoEsperado(),
                idea.getTags(),
                idea.getDataCriacao(),
                idea.getEstrategia()
        );
    }

}

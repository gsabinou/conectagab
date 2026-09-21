package com.aguiabranca.ConectaGab.dto;

import com.aguiabranca.ConectaGab.model.StrategicGuideline;

import java.time.LocalDate;

public record GuideExhibitionDTO(
        String id,
        String titulo,
        String descricao,
        String categoria,
        @com.fasterxml.jackson.annotation.JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate data,
        Boolean ativo
) {

    public GuideExhibitionDTO(StrategicGuideline strategicGuideline) {
        this (strategicGuideline.getId(),
        strategicGuideline.getTitulo(),
        strategicGuideline.getDescricao(),
        strategicGuideline.getCategoria(),
        strategicGuideline.getData(),
        strategicGuideline.getAtivo()
        );
    }

}

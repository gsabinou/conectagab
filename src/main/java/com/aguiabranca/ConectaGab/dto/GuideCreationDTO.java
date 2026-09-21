package com.aguiabranca.ConectaGab.dto;

import com.aguiabranca.ConectaGab.model.StrategicGuideline;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record GuideCreationDTO(
        String id,

        @NotBlank(message = "O título é obrigatório")
        String titulo,

        @NotBlank(message = "Por favor, insira uma descrição")
        String descricao,

        @NotBlank(message = "Categoria não informada")
        String categoria,
        LocalDate data,
        Boolean ativo
) {

    public GuideCreationDTO(StrategicGuideline strategicGuideline) {
        this (strategicGuideline.getId(),
                strategicGuideline.getTitulo(),
                strategicGuideline.getDescricao(),
                strategicGuideline.getCategoria(),
                strategicGuideline.getData(),
                strategicGuideline.getAtivo()
        );
    }

}

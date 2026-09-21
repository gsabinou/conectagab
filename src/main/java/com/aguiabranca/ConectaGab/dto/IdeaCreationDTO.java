package com.aguiabranca.ConectaGab.dto;

import com.aguiabranca.ConectaGab.model.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record IdeaCreationDTO(
        String id,

        @NotBlank(message = "O título é obrigatório")
        String titulo,

        @NotBlank(message = "A descrição é obrigatória")
        String descricao,

        @NotBlank(message = "A categoria deve ser informada")
        String categoria,

        User autor,
        IdeaStatus status,

        @NotBlank(message = "Por favor, informe a prioridade")
        Priority prioridade,

        @NotBlank(message = "O impacto esperado deve ser informado")
        String impactoEsperado,

        List<String> tags,
        @com.fasterxml.jackson.annotation.JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataCriacao,
        StrategicGuideline estrategia
) {

    public IdeaCreationDTO(Idea idea) {
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

package com.aguiabranca.ConectaGab.dto;

import com.aguiabranca.ConectaGab.model.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.List;

public record ProjectCreationDTO(

        String id,

        @NotBlank(message = "O título é obrigatório")
        String titulo,

        @NotBlank(message = "A descrição é obrigatória")
        String descricao,

        @NotBlank(message = "O ID do responsável deve ser informado")
        User autor,

        String etapaAtual,

        ProjectStatus status,

        Priority prioridade,

        Risk risco,

        @NotBlank(message = "A data de início prevista é obrigatória")
        LocalDate dataInicioPrevista,

        @NotBlank(message = "A data de fim prevista é obrigatória")
        LocalDate dataFimPrevista,

        LocalDate dataInicioReal,

        LocalDate dataFimReal,

        StatusPrazo statusPrazo,

        Double investimentoEstimado,

        Double retornoEstimado,

        Double economiaEstimada,

        Double ganhoProdutividade,

        Integer progressoPercentual,

        String categoria,

        List<String> tags,

        StrategicGuideline estrategia,

        Double comparativoYOY
) {
        public ProjectCreationDTO(Project project) {
                this(
                        project.getId(),
                        project.getTitulo(),
                        project.getDescricao(),
                        project.getAutor(),
                        project.getEtapaAtual(),
                        project.getStatus(),
                        project.getPrioridade(),
                        project.getRisco(),
                        project.getDataInicioPrevista(),
                        project.getDataFimPrevista(),
                        project.getDataInicioReal(),
                        project.getDataFimReal(),
                        project.getStatusPrazo(),
                        project.getInvestimentoEstimado(),
                        project.getRetornoEstimado(),
                        project.getEconomiaEstimada(),
                        project.getGanhoProdutividade(),
                        project.getProgressoPercentual(),
                        project.getCategoria(),
                        project.getTags(),
                        project.getEstrategia(),
                        project.getComparativoYOY()
                );
        }
}

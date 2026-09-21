package com.aguiabranca.ConectaGab.dto;

import com.aguiabranca.ConectaGab.model.*;

import java.time.LocalDate;
import java.util.List;

public record ProjectExhibitionDTO(
        String id,
        String titulo,
        String descricao,
        User autor,
        String etapaAtual,
        ProjectStatus status,
        Priority prioridade,
        Risk risco,
        @com.fasterxml.jackson.annotation.JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataInicioPrevista,
        @com.fasterxml.jackson.annotation.JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataFimPrevista,
        @com.fasterxml.jackson.annotation.JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate dataInicioReal,
        @com.fasterxml.jackson.annotation.JsonFormat(pattern = "dd/MM/yyyy")
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
    public ProjectExhibitionDTO(Project project) {
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

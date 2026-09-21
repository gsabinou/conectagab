package com.aguiabranca.ConectaGab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "projects")
public class Project {

    @Id
    private String id;

    private String titulo;
    private String descricao;
    private User autor;
    private String etapaAtual;
    private ProjectStatus status;
    private Priority prioridade;
    private Risk risco;
    private LocalDate dataInicioPrevista;
    private LocalDate dataFimPrevista;
    private LocalDate dataInicioReal;
    private LocalDate dataFimReal;
    private StatusPrazo statusPrazo;
    private Double investimentoEstimado;
    private Double retornoEstimado;
    private Double economiaEstimada;
    private Double ganhoProdutividade;
    private Integer progressoPercentual;
    private String categoria;
    private List<String> tags;
    private StrategicGuideline estrategia;

    @Field("comparativoYOY")
    private Double comparativoYOY;
}
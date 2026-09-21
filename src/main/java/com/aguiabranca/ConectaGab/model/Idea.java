package com.aguiabranca.ConectaGab.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "ideas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Idea {

    @Id
    private String id;

    private String titulo;
    private String descricao;
    private String categoria;
    private User autor;
    private IdeaStatus status;
    private Priority prioridade;
    private String impactoEsperado;
    private Double economiaGeradaEstimada;
    private List<String> tags;
    private LocalDate dataCriacao;
    private StrategicGuideline estrategia;

}

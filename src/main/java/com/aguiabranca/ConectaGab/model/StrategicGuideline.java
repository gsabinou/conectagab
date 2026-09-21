package com.aguiabranca.ConectaGab.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "strategic_guidelines")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class StrategicGuideline {

    @Id
    private String id;

    private String titulo;
    private String descricao;
    private String categoria;
    private LocalDate data;
    private Boolean ativo;

}

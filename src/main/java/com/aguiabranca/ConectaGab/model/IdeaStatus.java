package com.aguiabranca.ConectaGab.model;

public enum IdeaStatus {
    CADASTRADA("Em Fila"),
    EM_ANALISE("Em Análise"),
    PRIORIZADA("Priorizada"),
    APROVADA("Aprovada"),
    REPROVADA("Arquivada"),
    CONVERTIDA_PROJETO("Projeto Ativo");

    private String ideaStatus;

    IdeaStatus(String ideaStatus) {
        this.ideaStatus = ideaStatus;
    }

    public String getIdeaStatus() {
        return this.ideaStatus;
    }

}

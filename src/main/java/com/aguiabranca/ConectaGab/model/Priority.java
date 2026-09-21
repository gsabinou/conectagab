package com.aguiabranca.ConectaGab.model;

public enum Priority {
    BAIXA("Baixa Prioridade"),
    MEDIA("Média Prioridade"),
    ALTA("Alta Prioridade"),
    CRITICA("Crítica Prioridade");

    private String priority;

    Priority(String priority) {
        this.priority = priority;
    }

    public String getPriority() {
        return this.priority;
    }
}

package com.aguiabranca.ConectaGab.model;

public enum Risk {
    BAIXO("Baixo"),
    MEDIO("Médio"),
    ALTO("Alto"),
    CRITICO("Crítico");

    private final String risk;
    Risk(String risk) { this.risk = risk; }
    public String getRisk() { return this.risk; }
}

package com.aguiabranca.ConectaGab.model;

public enum StatusPrazo {
    NO_PRAZO("No prazo"),
    PROXIMO_VENCIMENTO("Próximo do vencimento"),
    ATRASADO("Atrasado"),
    CONCLUIDO("Concluído");

    private final String status;
    StatusPrazo(String status) { this.status = status; }
    public String getStatus() { return status; }
}

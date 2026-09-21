package com.aguiabranca.ConectaGab.model;

public enum ProjectStatus {
    PLANEJADO("Planejado"),
    EM_ANDAMENTO("Em andamento"),
    PAUSADO("Pausado"),
    CONCLUIDO("Concluído"),
    CANCELADO("Cancelado");

    private final String projectStatus;

    ProjectStatus(String projectStatus) { this.projectStatus = projectStatus; }

    public String getProjectStatus() { return this.projectStatus; }

}

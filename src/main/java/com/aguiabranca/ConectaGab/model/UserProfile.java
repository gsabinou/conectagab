package com.aguiabranca.ConectaGab.model;

public enum UserProfile {
    OPERADOR("OPERADOR"),
    GESTOR("GESTOR"),
    LIDER("LIDER");

    private String userProfile;

    UserProfile(String userProfile) {
        this.userProfile = userProfile;
    }

    public String getUserProfile() {
        return this.userProfile;
    }

}

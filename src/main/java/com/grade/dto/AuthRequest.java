package com.grade.dto;

public class AuthRequest {
    private String email;
    private String mdp;

    // Getters, setters, and no-args constructor
    public AuthRequest() {}

    public AuthRequest(String email, String mdp) {
        this.email = email;
        this.mdp = mdp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}
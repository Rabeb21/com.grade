package com.grade.dto;

public class UtilisateurCreateDTO {
    private String nom;
    private String email;
    private String genre;
    private Integer anciennete;
    private String role;
    private String mdp;

    // Constructeurs, Getters, Setters
    public UtilisateurCreateDTO() {}
    public UtilisateurCreateDTO(String nom, String email, String genre, Integer anciennete, String role, String mdp) {
        this.nom = nom;
        this.email = email;
        this.genre = genre;
        this.anciennete = anciennete;
        this.role = role;
        this.mdp = mdp;
    }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
    public Integer getAnciennete() { return anciennete; }
    public void setAnciennete(Integer anciennete) { this.anciennete = anciennete; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public String getMdp() { return mdp; }
    public void setMdp(String mdp) { this.mdp = mdp; }
}
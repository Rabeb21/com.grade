package com.grade.dto;

public class UtilisateurDTO {
    private Long id;
    private String nom;
    private String email;
    private String genre;
    private Integer anciennete;
    private String role;

    // constructeurs
    public UtilisateurDTO() {}
    public UtilisateurDTO(Long id, String nom, String email, String genre, Integer anciennete, String role) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.genre = genre;
        this.anciennete = anciennete;
        this.role = role;
    }
    // getters, setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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
}
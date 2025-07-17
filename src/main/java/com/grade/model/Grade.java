package com.grade.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Grade {
    @Id
    private Long id;
    private String nom;

    @OneToMany(mappedBy = "grade", cascade = CascadeType.ALL)
    private List<Utilisateur> utilisateurs;

    // Getters, Setters, Constructeurs
    public Grade() {}
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public List<Utilisateur> getUtilisateurs() { return utilisateurs; }
    public void setUtilisateurs(List<Utilisateur> utilisateurs) { this.utilisateurs = utilisateurs; }
}
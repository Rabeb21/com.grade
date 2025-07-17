package com.grade.dto;

import java.util.List;

public class GradeDTO {
    private Long id;
    private String nom;
    // liste id des user associe
    private List<Long> utilisateurIds;


    public GradeDTO() {}

    public GradeDTO(Long id, String nom, List<Long> utilisateurIds) {
        this.id = id;
        this.nom = nom;
        this.utilisateurIds = utilisateurIds;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public List<Long> getUtilisateurIds() { return utilisateurIds; }
    public void setUtilisateurIds(List<Long> utilisateurIds) { this.utilisateurIds = utilisateurIds; }
}
package com.grade.dto;

import java.util.Date;

public class DemandeDTO {
    private Long id;
    private String nom;
    private String motivation;
    private String fichier;
    private String etat;
    private Date dateSoumission;

    // Constructeurs, Getters, Setters
    public DemandeDTO() {}
    public DemandeDTO(Long id, String nom, String motivation, String fichier, String etat, Date dateSoumission) {
        this.id = id;
        this.nom = nom;
        this.motivation = motivation;
        this.fichier = fichier;
        this.etat = etat;
        this.dateSoumission = dateSoumission;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getMotivation() { return motivation; }
    public void setMotivation(String motivation) { this.motivation = motivation; }
    public String getFichier() { return fichier; }
    public void setFichier(String fichier) { this.fichier = fichier; }
    public String getEtat() { return etat; }
    public void setEtat(String etat) { this.etat = etat; }
    public Date getDateSoumission() { return dateSoumission; }
    public void setDateSoumission(Date dateSoumission) { this.dateSoumission = dateSoumission; }
}
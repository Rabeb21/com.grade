package com.grade.dto;

public class CritereEligibiliteDTO {
    private Long id;
    private String nom;
    private String valeur;
    private Long demandeId; // ref a id de demande associee


    public CritereEligibiliteDTO() {}

    public CritereEligibiliteDTO(Long id, String nom, String valeur, Long demandeId) {
        this.id = id;
        this.nom = nom;
        this.valeur = valeur;
        this.demandeId = demandeId;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getValeur() { return valeur; }
    public void setValeur(String valeur) { this.valeur = valeur; }
    public Long getDemandeId() { return demandeId; }
    public void setDemandeId(Long demandeId) { this.demandeId = demandeId; }
}
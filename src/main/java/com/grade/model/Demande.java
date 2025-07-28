package com.grade.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String motivation;
    private String fichier;

    @Enumerated(EnumType.STRING)
    private Etat etat;

    private Date dateSoumission;

    @OneToMany(mappedBy = "demande")
    private List<CritereEligibilite> criteres;

    @ManyToOne(fetch = FetchType.LAZY)   //charge user uniquement wakt necessaire (optimisation performance)
    @JoinColumn(name = "utilisateur_id") // cle dans Demande
    private Utilisateur utilisateur; // relation avec user

    // Getters, Setters, Constructeurs
    public Demande() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getMotivation() { return motivation; }
    public void setMotivation(String motivation) { this.motivation = motivation; }

    public String getFichier() { return fichier; }
    public void setFichier(String fichier) { this.fichier = fichier; }

    public Etat getEtat() { return etat; }
    public void setEtat(Etat etat) { this.etat = etat; }

    public Date getDateSoumission() { return dateSoumission; }
    public void setDateSoumission(Date dateSoumission) { this.dateSoumission = dateSoumission; }

    public List<CritereEligibilite> getCriteres() { return criteres; }
    public void setCriteres(List<CritereEligibilite> criteres) { this.criteres = criteres; }

    public Utilisateur getUtilisateur() { return utilisateur; }
    public void setUtilisateur(Utilisateur utilisateur) { this.utilisateur = utilisateur; }
}
package com.grade.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // auto-increment
    private Long id;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String mdp;
    @Column(nullable = false)
    private String genre;
    @Column(nullable = false)
    private Integer anciennete;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;


    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private List<Demande> demandes; // liste demande soumis par user


    public Utilisateur() {}


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMdp() { return mdp; }
    public void setMdp(String mdp) { this.mdp = mdp; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public Integer getAnciennete() { return anciennete; }
    public void setAnciennete(Integer anciennete) { this.anciennete = anciennete; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }


}
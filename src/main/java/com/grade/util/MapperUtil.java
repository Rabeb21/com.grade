package com.grade.util;

import com.grade.dto.CritereEligibiliteDTO;
import com.grade.dto.UtilisateurDTO;
import com.grade.model.CritereEligibilite;
import com.grade.model.Utilisateur;
import com.grade.dto.DemandeDTO;
import com.grade.model.Demande;
import java.util.stream.Collectors;



public class MapperUtil {
    public static UtilisateurDTO toUtilisateurDTO(Utilisateur utilisateur) {
        return new UtilisateurDTO(
                utilisateur.getId(),
                utilisateur.getNom(),
                utilisateur.getEmail(),
                utilisateur.getGenre(),
                utilisateur.getAnciennete(),
                utilisateur.getRole().toString()
        );
    }

    public static DemandeDTO toDemandeDTO(Demande demande) {
        return new DemandeDTO(
                demande.getId(),
                demande.getNom(),
                demande.getMotivation(),
                demande.getFichier(),
                demande.getEtat().toString(),
                demande.getDateSoumission()
        );
    }

    public static CritereEligibiliteDTO toCritereEligibiliteDTO(CritereEligibilite critere) {
        return new CritereEligibiliteDTO(
                critere.getId(),
                critere.getNom(),
                critere.getValeur(),
                critere.getDemande() != null ? critere.getDemande().getId() : null
        );
    }
}
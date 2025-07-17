package com.grade.service;

import com.grade.dto.DemandeDTO;
import com.grade.model.Demande;
import com.grade.model.Etat;
import com.grade.model.Utilisateur;
import com.grade.repository.DemandeRepository;
import com.grade.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DemandeServiceImpl implements DemandeService {
    @Autowired
    private DemandeRepository demandeRepository;

    @Override
    public List<DemandeDTO> getAllDemandes() {
        return demandeRepository.findAll().stream()
                .map(MapperUtil::toDemandeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DemandeDTO getDemandeById(Long id) {
        return demandeRepository.findById(id)
                .map(MapperUtil::toDemandeDTO)
                .orElse(null);
    }

    @Override
    public DemandeDTO createDemande(DemandeDTO demandeDTO) {
        Demande demande = new Demande();
        demande.setId(demandeDTO.getId());
        demande.setNom(demandeDTO.getNom());
        demande.setMotivation(demandeDTO.getMotivation());
        demande.setFichier(demandeDTO.getFichier());
        demande.setEtat(Etat.valueOf(demandeDTO.getEtat()));
        demande.setDateSoumission(demandeDTO.getDateSoumission());
        if (demandeDTO.getId() != null) {
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setId(demandeDTO.getId());
            demande.setUtilisateur(utilisateur);
        }
        Demande savedDemande = demandeRepository.save(demande);
        return MapperUtil.toDemandeDTO(savedDemande);
    }

    @Override
    public void deleteDemande(Long id) {
        demandeRepository.deleteById(id);
    }
}
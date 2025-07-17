package com.grade.service;

import com.grade.dto.DemandeDTO;
import java.util.List;

public interface DemandeService {
    List<DemandeDTO> getAllDemandes();
    DemandeDTO getDemandeById(Long id);
    DemandeDTO createDemande(DemandeDTO demandeDTO);
    void deleteDemande(Long id);
}
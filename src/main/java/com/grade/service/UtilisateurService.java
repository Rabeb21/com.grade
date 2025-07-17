package com.grade.service;

import com.grade.dto.UtilisateurCreateDTO;
import com.grade.dto.UtilisateurDTO;
import java.util.List;

public interface UtilisateurService {
    List<UtilisateurDTO> getAllUtilisateurs();
    UtilisateurDTO getUtilisateurById(Long id);
    UtilisateurDTO createUtilisateur(UtilisateurCreateDTO utilisateurCreateDTO);
    void deleteUtilisateur(Long id);
}
package com.grade.service;

import com.grade.dto.UtilisateurCreateDTO;
import com.grade.dto.UtilisateurDTO;
import com.grade.model.Role;
import com.grade.model.Utilisateur;
import com.grade.repository.UtilisateurRepository;
import com.grade.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Override
    public List<UtilisateurDTO> getAllUtilisateurs() {
        return utilisateurRepository.findAll().stream()
                .map(MapperUtil::toUtilisateurDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UtilisateurDTO getUtilisateurById(Long id) {
        return utilisateurRepository.findById(id)
                .map(MapperUtil::toUtilisateurDTO)
                .orElse(null);
    }


    @Override
    public UtilisateurDTO createUtilisateur(UtilisateurCreateDTO utilisateurCreateDTO) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(utilisateurCreateDTO.getNom());
        utilisateur.setEmail(utilisateurCreateDTO.getEmail());

        // hachage mdp avec BCrypt
        String hashedPassword = hashPassword(utilisateurCreateDTO.getMdp());
        utilisateur.setMdp(hashedPassword);
        utilisateur.setGenre(utilisateurCreateDTO.getGenre());
        utilisateur.setAnciennete(utilisateurCreateDTO.getAnciennete());
        utilisateur.setRole(Role.valueOf(utilisateurCreateDTO.getRole()));
        Utilisateur savedUtilisateur = utilisateurRepository.save(utilisateur);
        return MapperUtil.toUtilisateurDTO(savedUtilisateur);
    }

    @Override
    public void deleteUtilisateur(Long id) {
        utilisateurRepository.deleteById(id);
    }

    private String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
}
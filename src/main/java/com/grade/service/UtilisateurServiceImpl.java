package com.grade.service;

import com.grade.dto.UtilisateurCreateDTO;
import com.grade.dto.UtilisateurDTO;
import com.grade.model.Role;
import com.grade.model.Utilisateur;
import com.grade.repository.UtilisateurRepository;
import com.grade.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UtilisateurServiceImpl implements UtilisateurService, UserDetailsService {

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
        String hashedPassword = hashPassword(utilisateurCreateDTO.getMdp());
        utilisateur.setMdp(hashedPassword);
        utilisateur.setGenre(utilisateurCreateDTO.getGenre());
        utilisateur.setAnciennete(utilisateurCreateDTO.getAnciennete());
        utilisateur.setRole(Role.valueOf(utilisateurCreateDTO.getRole().toUpperCase()));
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Recherche de l'utilisateur avec email : " + username);
        Utilisateur utilisateur = utilisateurRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé : " + username));
        System.out.println("Utilisateur trouvé : " + utilisateur.getEmail());
        List<GrantedAuthority> authorities = Collections.singletonList(
                new SimpleGrantedAuthority("ROLE_" + utilisateur.getRole().name()));
        return new User(
                utilisateur.getEmail(),
                utilisateur.getMdp(),
                authorities);
    }

    public Utilisateur findByEmail(String email) {
        return utilisateurRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé : " + email));
    }
}
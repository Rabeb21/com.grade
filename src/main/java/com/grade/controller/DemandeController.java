package com.grade.controller;

import com.grade.dto.DemandeDTO;
import com.grade.service.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/demandes")
public class DemandeController {
    @Autowired
    private DemandeService demandeService;

    @GetMapping
    public List<DemandeDTO> getAllDemandes() {
        return demandeService.getAllDemandes();
    }

    @GetMapping("/{id}")
    public DemandeDTO getDemandeById(@PathVariable Long id) {
        return demandeService.getDemandeById(id);
    }

    @PostMapping
    public DemandeDTO createDemande(@RequestBody DemandeDTO demandeDTO) {
        return demandeService.createDemande(demandeDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteDemande(@PathVariable Long id) {
        demandeService.deleteDemande(id);
    }
}
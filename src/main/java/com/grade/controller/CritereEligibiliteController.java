package com.grade.controller;

import com.grade.dto.CritereEligibiliteDTO;
import com.grade.service.CritereEligibiliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/criteres")
public class CritereEligibiliteController {
    @Autowired
    private CritereEligibiliteService critereEligibiliteService;

    @GetMapping
    public List<CritereEligibiliteDTO> getAllCriteres() {
        return critereEligibiliteService.getAllCriteres();
    }

    @GetMapping("/{id}")
    public CritereEligibiliteDTO getCritereById(@PathVariable Long id) {
        return critereEligibiliteService.getCritereById(id);
    }

    @PostMapping
    public CritereEligibiliteDTO createCritere(@RequestBody CritereEligibiliteDTO critereDTO) {
        return critereEligibiliteService.createCritere(critereDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCritere(@PathVariable Long id) {
        critereEligibiliteService.deleteCritere(id);
    }
}
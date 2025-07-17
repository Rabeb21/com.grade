package com.grade.service;

import com.grade.dto.CritereEligibiliteDTO;
import com.grade.model.CritereEligibilite;
import com.grade.repository.CritereEligibiliteRepository;
import com.grade.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CritereEligibiliteServiceImpl implements CritereEligibiliteService {
    @Autowired
    private CritereEligibiliteRepository critereEligibiliteRepository;

    @Override
    public List<CritereEligibiliteDTO> getAllCriteres() {
        return critereEligibiliteRepository.findAll().stream()
                .map(MapperUtil::toCritereEligibiliteDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CritereEligibiliteDTO getCritereById(Long id) {
        return critereEligibiliteRepository.findById(id)
                .map(MapperUtil::toCritereEligibiliteDTO)
                .orElse(null);
    }

    @Override
    public CritereEligibiliteDTO createCritere(CritereEligibiliteDTO critereDTO) {
        CritereEligibilite critere = new CritereEligibilite();
        critere.setId(critereDTO.getId());
        critere.setNom(critereDTO.getNom());
        critere.setValeur(critereDTO.getValeur());
        CritereEligibilite savedCritere = critereEligibiliteRepository.save(critere);
        return MapperUtil.toCritereEligibiliteDTO(savedCritere);
    }

    @Override
    public void deleteCritere(Long id) {
        critereEligibiliteRepository.deleteById(id);
    }
}
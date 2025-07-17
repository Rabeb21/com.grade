package com.grade.service;

import com.grade.dto.CritereEligibiliteDTO;
import java.util.List;

public interface CritereEligibiliteService {
    List<CritereEligibiliteDTO> getAllCriteres();
    CritereEligibiliteDTO getCritereById(Long id);
    CritereEligibiliteDTO createCritere(CritereEligibiliteDTO critereDTO);
    void deleteCritere(Long id);
}
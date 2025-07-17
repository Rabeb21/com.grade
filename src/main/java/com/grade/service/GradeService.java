package com.grade.service;

import com.grade.dto.GradeDTO;
import java.util.List;

public interface GradeService {
    List<GradeDTO> getAllGrades();
    GradeDTO getGradeById(Long id);
    GradeDTO createGrade(GradeDTO gradeDTO);
    void deleteGrade(Long id);
}
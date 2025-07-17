package com.grade.service;

import com.grade.dto.GradeDTO;
import com.grade.model.Grade;
import com.grade.repository.GradeRepository;
import com.grade.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    private GradeRepository gradeRepository;

    @Override
    public List<GradeDTO> getAllGrades() {
        return gradeRepository.findAll().stream()
                .map(MapperUtil::toGradeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public GradeDTO getGradeById(Long id) {
        return gradeRepository.findById(id)
                .map(MapperUtil::toGradeDTO)
                .orElse(null);
    }

    @Override
    public GradeDTO createGrade(GradeDTO gradeDTO) {
        Grade grade = new Grade();
        grade.setId(gradeDTO.getId());
        grade.setNom(gradeDTO.getNom());
        Grade savedGrade = gradeRepository.save(grade);
        return MapperUtil.toGradeDTO(savedGrade);
    }

    @Override
    public void deleteGrade(Long id) {
        gradeRepository.deleteById(id);
    }
}
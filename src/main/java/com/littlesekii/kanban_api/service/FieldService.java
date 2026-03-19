package com.littlesekii.kanban_api.service;

import org.springframework.stereotype.Service;

import com.littlesekii.kanban_api.dto.field.FieldPatchDTO;
import com.littlesekii.kanban_api.dto.field.FieldResponseDTO;
import com.littlesekii.kanban_api.model.Field;
import com.littlesekii.kanban_api.repository.IFieldRepository;

import jakarta.transaction.Transactional;

@Service
public class FieldService {

    private final IFieldRepository repository;

    public FieldService(IFieldRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public FieldResponseDTO partialUpdate(Long id, FieldPatchDTO data) {
        Field field = repository.findById(id).orElseThrow(
            () -> new RuntimeException("Resource not found")
        );

        field.updateTitle(data.title());
        return FieldResponseDTO.fromEntity(repository.save(field));
    }
    
}
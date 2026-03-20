package com.littlesekii.kanban_api.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.littlesekii.kanban_api.dto.board.BoardPatchMoveFieldsDTO;
import com.littlesekii.kanban_api.dto.board.BoardResponseDTO;
import com.littlesekii.kanban_api.model.Field;
import com.littlesekii.kanban_api.repository.IBoardRepository;
import com.littlesekii.kanban_api.repository.IFieldRepository;

@Service
public class BoardService {

    private final IBoardRepository repository;
    private final IFieldRepository fieldRepository;

    public BoardService(
        IBoardRepository repository,
        IFieldRepository fieldRepository
    ) {
        this.repository = repository;
        this.fieldRepository = fieldRepository;
    }

    public List<BoardResponseDTO> findAll() {
        return repository.findAll().stream()
            .map(BoardResponseDTO::fromEntity)
            .toList();
    }

    public BoardResponseDTO findById(Long id) {
        return BoardResponseDTO.fromEntity(
            repository.findById(id).orElseThrow(
                () -> new RuntimeException("Resource not found")
            )
        );
    }

    public void moveFields(Long id, BoardPatchMoveFieldsDTO req) {
        List<Field> fields = fieldRepository.findAllById(req.fieldIds());

        Map<Long, Field> fieldMap = fields.stream()
        .collect(Collectors.toMap(Field::getId, field -> field));

        for (int i = 0; i < req.fieldIds().size(); i++) {
            Long fieldId = req.fieldIds().get(i);
            Field field = fieldMap.get(fieldId);
            field.updateSortOrder(i + 1);
        }
        fieldRepository.saveAll(fields);
    }

}

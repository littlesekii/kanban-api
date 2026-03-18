package com.littlesekii.kanban_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.littlesekii.kanban_api.dto.board.BoardResponseDTO;
import com.littlesekii.kanban_api.repository.IBoardRepository;

@Service
public class BoardService {

    private final IBoardRepository repository;

    public BoardService(IBoardRepository repository) {
        this.repository = repository;
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

}

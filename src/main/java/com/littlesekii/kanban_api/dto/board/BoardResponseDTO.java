package com.littlesekii.kanban_api.dto.board;

import java.util.List;

import com.littlesekii.kanban_api.dto.field.FieldResponseDTO;
import com.littlesekii.kanban_api.model.Board;

// @JsonPropertyOrder({ "id", "title", "fields" })
public record BoardResponseDTO(
    Long id, 
    String title, 
    List<FieldResponseDTO> fields
) {

    public static BoardResponseDTO fromEntity(Board board) {
        return new BoardResponseDTO(
            board.getId(), 
            board.getTitle(), 
            board.getFields().stream()
                .map(FieldResponseDTO::fromEntity)
                .toList()
        );
    }
    
}

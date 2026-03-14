package com.littlesekii.kanban_api.dto.board;

import java.util.List;

import com.littlesekii.kanban_api.dto.field.FieldResponse;
import com.littlesekii.kanban_api.model.Board;

// @JsonPropertyOrder({ "id", "title", "fields" })
public record BoardResponse(
    Long id, 
    String title, 
    List<FieldResponse> fields
) {

    public static BoardResponse fromEntity(Board board) {
        return new BoardResponse(
            board.getId(), 
            board.getTitle(), 
            board.getFields().stream()
                .map(FieldResponse::fromEntity)
                .toList()
        );
    }
    
}

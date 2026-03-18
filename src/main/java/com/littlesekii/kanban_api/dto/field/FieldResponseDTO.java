package com.littlesekii.kanban_api.dto.field;

import java.util.List;

import com.littlesekii.kanban_api.dto.card.CardResponseDTO;
import com.littlesekii.kanban_api.model.Field;

// @JsonPropertyOrder({ "id", "title", "order", "cards" })
public record FieldResponseDTO(
    Long id, 
    String title, 
    Integer order, 
    List<CardResponseDTO> cards
) {

    public static FieldResponseDTO fromEntity(Field field) {
        return new FieldResponseDTO(
            field.getId(), 
            field.getTitle(), 
            field.getSortOrder(), 
            field.getCards().stream()
                .map(CardResponseDTO::fromEntity)
                .toList()
        );
    }
    
}

package com.littlesekii.kanban_api.dto.field;

import java.util.List;

import com.littlesekii.kanban_api.dto.card.CardResponse;
import com.littlesekii.kanban_api.model.Field;

// @JsonPropertyOrder({ "id", "title", "order", "cards" })
public record FieldResponse(
    Long id, 
    String title, 
    Integer order, 
    List<CardResponse> cards
) {

    public static FieldResponse fromEntity(Field field) {
        return new FieldResponse(
            field.getId(), 
            field.getTitle(), 
            field.getSortOrder(), 
            field.getCards().stream()
                .map(CardResponse::fromEntity)
                .toList()
        );
    }
    
}

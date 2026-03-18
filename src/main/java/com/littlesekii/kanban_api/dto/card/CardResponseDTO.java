package com.littlesekii.kanban_api.dto.card;

import com.littlesekii.kanban_api.model.Card;

// @JsonPropertyOrder({ "id", "title", "order" })
public record CardResponseDTO(
    Long id, 
    String title, 
    Integer order
) {

    public static CardResponseDTO fromEntity(Card card) {
        return new CardResponseDTO(
            card.getId(), 
            card.getTitle(), 
            card.getSortOrder()
        );
    }
    
}
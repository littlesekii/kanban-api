package com.littlesekii.kanban_api.dto.card;

import com.littlesekii.kanban_api.model.Card;

// @JsonPropertyOrder({ "id", "title", "order" })
public record CardResponse(
    Long id, 
    String title, 
    Integer order
) {

    public static CardResponse fromEntity(Card card) {
        return new CardResponse(
            card.getId(), 
            card.getTitle(), 
            card.getSortOrder()
        );
    }
    
}
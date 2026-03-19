package com.littlesekii.kanban_api.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.littlesekii.kanban_api.dto.field.FieldPatchDTO;
import com.littlesekii.kanban_api.dto.field.FieldPatchMoveCardsDTO;
import com.littlesekii.kanban_api.dto.field.FieldResponseDTO;
import com.littlesekii.kanban_api.model.Card;
import com.littlesekii.kanban_api.model.Field;
import com.littlesekii.kanban_api.repository.ICardRepository;
import com.littlesekii.kanban_api.repository.IFieldRepository;

@Service
public class FieldService {

    private final IFieldRepository repository;
    private final ICardRepository cardRepository;

    public FieldService(IFieldRepository repository, ICardRepository cardRepository) {
        this.repository = repository;
        this.cardRepository = cardRepository;
    }

    @Transactional
    public FieldResponseDTO partialUpdate(Long id, FieldPatchDTO data) {
        Field field = repository.findById(id).orElseThrow(
            () -> new RuntimeException("Resource not found")
        );

        field.updateTitle(data.title());
        return FieldResponseDTO.fromEntity(repository.save(field));
    }    

    @Transactional
    public void moveCards(List<FieldPatchMoveCardsDTO> req) {

        for (FieldPatchMoveCardsDTO reqItem : req) {
            Field field = repository.getReferenceById(reqItem.id());
            List<Card> cards = cardRepository.findAllById(reqItem.cardIds());

            Map<Long, Card> cardMap = cards.stream()
                .collect(Collectors.toMap(Card::getId, card -> card));
                
            for(int i = 0; i < reqItem.cardIds().size(); i++) {
                Long cardId = reqItem.cardIds().get(i);
                Card card = cardMap.get(cardId);

                if (card != null) {
                    card.updateField(field);
                    card.updateSortOrder(i + 1);
                }
            }
            cardRepository.saveAll(cards);
        }
    }
}
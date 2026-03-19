package com.littlesekii.kanban_api.dto.field;

import java.util.List;

public record FieldPatchMoveCardsDTO(Long id, List<Long> cardIds) {}

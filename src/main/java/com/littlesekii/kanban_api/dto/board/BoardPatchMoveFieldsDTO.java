package com.littlesekii.kanban_api.dto.board;

import java.util.List;

public record BoardPatchMoveFieldsDTO(List<Long> fieldIds) {}

package com.littlesekii.kanban_api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.littlesekii.kanban_api.dto.field.FieldPatchDTO;
import com.littlesekii.kanban_api.dto.field.FieldPatchMoveCardsDTO;
import com.littlesekii.kanban_api.dto.field.FieldResponseDTO;
import com.littlesekii.kanban_api.service.FieldService;


@RestController
@RequestMapping("/api/fields")
public class FieldController {

    private final FieldService service;

    public FieldController(FieldService service) {
        this.service = service;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<FieldResponseDTO> patchField(@PathVariable Long id, @RequestBody FieldPatchDTO req) {
        FieldResponseDTO res = service.partialUpdate(id, req);
        return ResponseEntity.ok().body(res);
    }

    @PatchMapping("/move-cards")
    public ResponseEntity<Void> patchField(@RequestBody List<FieldPatchMoveCardsDTO> req) {
        service.moveCards(req);
        return ResponseEntity.ok().build();
    }
    
}

package com.littlesekii.kanban_api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.littlesekii.kanban_api.dto.board.BoardResponseDTO;
import com.littlesekii.kanban_api.service.BoardService;



@RestController
@RequestMapping("/api/boards")
public class BoardController {

    private final BoardService service;

    public BoardController(BoardService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<BoardResponseDTO>> findAll() {
        List<BoardResponseDTO> res = service.findAll();
        return ResponseEntity.ok().body(res);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardResponseDTO> findById(@PathVariable Long id) {
        BoardResponseDTO res = service.findById(id);
        return ResponseEntity.ok().body(res);
    }
    
    
}

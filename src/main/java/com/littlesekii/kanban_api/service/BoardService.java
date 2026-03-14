package com.littlesekii.kanban_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.littlesekii.kanban_api.model.Board;
import com.littlesekii.kanban_api.resource.IBoardRepository;

@Service
public class BoardService {

    private final IBoardRepository repository;

    public BoardService(IBoardRepository repository) {
        this.repository = repository;
    }

    public List<Board> findAll() {
        return repository.findAll();
    }

}

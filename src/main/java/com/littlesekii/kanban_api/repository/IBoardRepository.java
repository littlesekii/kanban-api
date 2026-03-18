package com.littlesekii.kanban_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.littlesekii.kanban_api.model.Board;

@Repository
public interface IBoardRepository extends JpaRepository<Board, Long> {

} 

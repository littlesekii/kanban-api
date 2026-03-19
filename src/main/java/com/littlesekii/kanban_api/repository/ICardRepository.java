package com.littlesekii.kanban_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.littlesekii.kanban_api.model.Card;

@Repository
public interface ICardRepository extends JpaRepository<Card, Long> {
    
}

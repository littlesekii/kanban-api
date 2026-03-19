package com.littlesekii.kanban_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Integer sortOrder;

    @ManyToOne
    @JoinColumn(name = "field_id")
    private Field field;

    public Card() {}
    public Card(String title, Integer sortOrder) {
        this.title = title;
        this.sortOrder = sortOrder;
    }

    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public Integer getSortOrder() {
        return sortOrder;
    }

    public void updateField(Field field) {
        this.field = field;
    }

    public void updateSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Card other = (Card) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    } 
}

package com.cognizant.orm_learn.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qt_id")
    private int id;
    @Column(name = "qt_text")
    private String text;
    @OneToMany(mappedBy = "question")
    private Set<Options> optionsList;

    // Getters and setters...
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Set<Options> getOptionsList() {
        return optionsList;
    }

    public void setOptionsList(Set<Options> optionsList) {
        this.optionsList = optionsList;
    }
}
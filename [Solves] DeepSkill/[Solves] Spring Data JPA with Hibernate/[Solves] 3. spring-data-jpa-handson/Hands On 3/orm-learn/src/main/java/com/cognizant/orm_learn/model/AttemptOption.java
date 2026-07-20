package com.cognizant.orm_learn.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "attempt_option")
public class AttemptOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ao_id")
    private int id;
    @Column(name = "ao_selected")
    private boolean selected;
    @ManyToOne
    @JoinColumn(name = "ao_op_id")
    private Options option;
    @ManyToOne
    @JoinColumn(name = "ao_aq_id")
    private AttemptQuestion attemptQuestion;

    // Getters and setters...
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public Options getOption() {
        return option;
    }

    public void setOption(Options option) {
        this.option = option;
    }

    public AttemptQuestion getAttemptQuestion() {
        return attemptQuestion;
    }

    public void setAttemptQuestion(AttemptQuestion attemptQuestion) {
        this.attemptQuestion = attemptQuestion;
    }
}
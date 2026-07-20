package com.cognizant.orm_learn.model;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "attempt")
public class Attempt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "at_id")
    private int id;
    @Temporal(TemporalType.DATE) 
    @Column(name="at_date")
    private Date date;
    @Column(name = "at_score")
    private double score;
    @ManyToOne
    @JoinColumn(name = "at_us_id")
    private User user;
    @OneToMany(mappedBy = "attempt")
    private Set<AttemptQuestion> attemptQuestions;

    // Getters and setters...
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<AttemptQuestion> getAttemptQuestions() {
        return attemptQuestions;
    }

    public void setAttemptQuestions(Set<AttemptQuestion> attemptQuestions) {
        this.attemptQuestions = attemptQuestions;
    }
}
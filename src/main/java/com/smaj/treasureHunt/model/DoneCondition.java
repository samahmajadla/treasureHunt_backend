package com.smaj.treasureHunt.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class DoneCondition {

    public DoneCondition(){
        conditionMet = false;
    }
    @Id
    @GeneratedValue
    private long id;

    private boolean conditionMet;
    @OneToMany(mappedBy = "doneCondition")
    @JsonManagedReference
    private List<Solution> solutions;

    private boolean evaluateConditionMet(){
        return false;
    }

    public boolean isConditionMet() {
        return conditionMet;
    }

    public void setConditionMet(boolean conditionMet) {
        this.conditionMet = conditionMet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Solution> getSolutions() {
        return solutions;
    }

    public void setSolutions(List<Solution> solutions) {
        this.solutions = solutions;
    }
}

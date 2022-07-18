package com.smaj.treasureHunt.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.geo.Point;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class DoneCondition {

    public DoneCondition(){
        conditionMet = false;
        this.solutions = new LinkedList<>();
    }
    @Id
    @GeneratedValue
    private long id;

    private boolean conditionMet;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    @JoinColumn(name = "done_condition_id")
    private List<Solution> solutions;

    public boolean evaluateConditionMet(){
        boolean solved = true;
        for (Solution solution : solutions) {
            if (!solution.isSolution_found()){
                solved = false;
                break;
            }
        }
        conditionMet = solved;
        return conditionMet;
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

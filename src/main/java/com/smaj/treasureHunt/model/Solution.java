package com.smaj.treasureHunt.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = LocationBasedSolution.class, name = "location"),
        @JsonSubTypes.Type(value = StringMatchSolution.class, name = "string")})
@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "solution_type")
public abstract class Solution {

    public Solution(){
        solution_found = false;
    }
    @Id
    @GeneratedValue
    private long id;

    private boolean solution_found;

    @JsonBackReference
    @ManyToOne
    private DoneCondition doneCondition;

    public DoneCondition getDoneCondition() {
        return doneCondition;
    }

    public void setDoneCondition(DoneCondition doneCondition) {
        this.doneCondition = doneCondition;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isSolution_found() {
        return solution_found;
    }

    public void setSolution_found(boolean solution_found) {
        this.solution_found = solution_found;
    }

    public abstract boolean checkSolution(Solution guess);


}

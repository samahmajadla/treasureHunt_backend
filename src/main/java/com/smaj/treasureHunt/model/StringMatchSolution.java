package com.smaj.treasureHunt.model;

import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("string_match")
@JsonTypeName("string")
public class StringMatchSolution extends Solution{

    public StringMatchSolution() {
    }

    private String answer;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public boolean checkSolution(Object guess) {
        String string = (String) guess;
        if (answer.equals(string)){
            this.setSolution_found(true);
            return true;
        } else{
            return false;
        }
    }

}

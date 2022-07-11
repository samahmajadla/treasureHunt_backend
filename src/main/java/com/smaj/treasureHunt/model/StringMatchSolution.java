package com.smaj.treasureHunt.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("string_match")
public class StringMatchSolution extends Solution{

    private String answer;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public boolean checkSolution(String answer) {
        return false;
    }

}

package com.smaj.treasureHunt.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

import java.util.LinkedList;
import java.util.List;

@Entity
public class TreasureHunt {

    public TreasureHunt(){
        this.completionStatus = CompletionStatus.NOT_STARTED;
        this.steps = new LinkedList<>();
    }
    @Id
    @GeneratedValue
    private long id;

    private String recipient;

    private String creator;

    private String name;
    @OneToMany(mappedBy = "treasureHunt", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<TreasureHuntStep> steps;

    @Enumerated(EnumType.STRING)
    private CompletionStatus completionStatus;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CompletionStatus getCompletionStatus() {
        return completionStatus;
    }

    public void setCompletionStatus(CompletionStatus completionStatus) {
        this.completionStatus = completionStatus;
    }

    public List<TreasureHuntStep> getSteps() {
        return steps;
    }

    public void setSteps(List<TreasureHuntStep> steps) {
        this.steps = steps;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
}

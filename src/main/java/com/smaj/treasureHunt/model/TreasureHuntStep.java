package com.smaj.treasureHunt.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(
        name="treasureHuntStep",
        uniqueConstraints = {@UniqueConstraint(name="uniqueOrderInEachTreasureHunt", columnNames = {"orderNumber", "treasureHunt_id"})
        })
public class TreasureHuntStep {

    public TreasureHuntStep(){
        this.completionStatus = CompletionStatus.NOT_STARTED;
    }
    @Id
    @GeneratedValue
    private long id;

    private int orderNumber;
    private String clue;

    private String title;
    private String reward;

    @Enumerated(EnumType.STRING)
    private CompletionStatus completionStatus;

    @OneToOne
    @JsonManagedReference
    private DoneCondition doneCondition;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="treasureHunt_id")
    private TreasureHunt treasureHunt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClue() {
        return clue;
    }

    public void setClue(String clue) {
        this.clue = clue;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    public CompletionStatus getCompletionStatus() {
        return completionStatus;
    }

    public void setCompletionStatus(CompletionStatus completionStatus) {
        this.completionStatus = completionStatus;
    }

    public DoneCondition getDoneCondition() {
        return doneCondition;
    }

    public void setDoneCondition(DoneCondition doneCondition) {
        this.doneCondition = doneCondition;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TreasureHunt getTreasureHunt() {
        return treasureHunt;
    }

    public void setTreasureHunt(TreasureHunt treasureHunt) {
        this.treasureHunt = treasureHunt;
    }
}

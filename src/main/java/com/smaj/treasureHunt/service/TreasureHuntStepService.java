package com.smaj.treasureHunt.service;

import com.smaj.treasureHunt.model.CompletionStatus;
import com.smaj.treasureHunt.model.Solution;
import com.smaj.treasureHunt.model.TreasureHunt;
import com.smaj.treasureHunt.model.TreasureHuntStep;
import com.smaj.treasureHunt.repository.TreasureHuntStepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TreasureHuntStepService {

    @Autowired
    private TreasureHuntStepRepository treasureHuntStepRepository;

    public TreasureHuntStepService(@Autowired TreasureHuntStepRepository treasureHuntStepRepository){
        this.treasureHuntStepRepository = treasureHuntStepRepository;
    }
    public TreasureHuntStep addStep(TreasureHuntStep step) {
        return treasureHuntStepRepository.save(step);
    }

    public TreasureHuntStep getStep(long stepId) {
        return treasureHuntStepRepository.findById(stepId).get();
    }

    public List getAllStepsForTreasureHunt(long treasureHuntId) {
        return treasureHuntStepRepository.findAllBytreasureHuntId(treasureHuntId);
    }

    public void deleteAllStepsForTreasureHunt(long treasureHuntId) {
        treasureHuntStepRepository.deleteAllByTreasureHuntId(treasureHuntId);
    }

    public TreasureHuntStep updateStep(TreasureHuntStep step) throws Exception{
        Optional<TreasureHuntStep> byId = treasureHuntStepRepository.findById(step.getId());
        if (byId.isPresent()) {
            return treasureHuntStepRepository.save(byId.get());
        }
        else {
            throw new Exception();
        }
    }

    public TreasureHuntStep isStepComplete(long id) {
        TreasureHuntStep treasureHuntStep = treasureHuntStepRepository.findById(id).get();

        boolean conditionMet = treasureHuntStep.getDoneCondition().evaluateConditionMet();
        if (conditionMet){
            treasureHuntStep.setCompletionStatus(CompletionStatus.COMPLETED);
            TreasureHunt treasureHunt = treasureHuntStep.getTreasureHunt();

            if (treasureHunt.getSteps().size()> treasureHuntStep.getOrderNumber()){
                treasureHunt.setCurrentStep(treasureHunt.getCurrentStep()+1);
            } else{
                treasureHunt.setCompletionStatus(CompletionStatus.COMPLETED);
            }
            treasureHuntStepRepository.save(treasureHuntStep);
        }
        return treasureHuntStep;
    }


}

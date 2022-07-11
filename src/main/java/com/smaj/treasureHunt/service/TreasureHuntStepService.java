package com.smaj.treasureHunt.service;

import com.smaj.treasureHunt.model.TreasureHuntStep;
import com.smaj.treasureHunt.repository.TreasureHuntStepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}

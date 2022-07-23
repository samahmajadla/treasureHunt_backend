package com.smaj.treasureHunt.service;

import com.smaj.treasureHunt.model.CompletionStatus;
import com.smaj.treasureHunt.model.TreasureHunt;
import com.smaj.treasureHunt.repository.TreasureHuntRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreasureHuntService {

    @Autowired
    private TreasureHuntRepository treasureHuntRepository;

    public TreasureHuntService(@Autowired TreasureHuntRepository treasureHuntRepository){
        this.treasureHuntRepository = treasureHuntRepository;
    }

    public TreasureHunt addTreasureHunt(TreasureHunt treasureHunt) {
        return treasureHuntRepository.save(treasureHunt);
    }

    public TreasureHunt getTreasureHunt(long id) {
        return treasureHuntRepository.findById(id).get();
    }

    public List<TreasureHunt> getAllTreasureHunts() {
        return (List) treasureHuntRepository.findAll();
    }

    public void deleteTreasureHunt(long id) {
        treasureHuntRepository.deleteById(id);
    }

    public TreasureHunt startTreasureHunt(long id) {
        TreasureHunt treasureHunt = treasureHuntRepository.findById(id).get();
        treasureHunt.setCompletionStatus(CompletionStatus.STARTED);
        treasureHunt.setCurrentStep(1);
        return treasureHuntRepository.save(treasureHunt);
    }

    public long loginToTreasureHunt(String keyword, String password){
        TreasureHunt treasureHunt = treasureHuntRepository.findByKeyword(keyword);
        if (treasureHunt.getPassword().equals(password)){
            return treasureHunt.getId();
        } else{
            return -1;
        }


    }
}

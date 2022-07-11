package com.smaj.treasureHunt.repository;

import com.smaj.treasureHunt.model.TreasureHuntStep;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TreasureHuntStepRepository extends CrudRepository<TreasureHuntStep, Long> {
    void deleteAllByTreasureHuntId(long treasureHuntId);

    List findAllBytreasureHuntId(long treasureHuntId);

}

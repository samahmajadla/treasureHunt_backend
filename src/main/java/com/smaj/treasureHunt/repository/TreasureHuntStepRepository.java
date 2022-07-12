package com.smaj.treasureHunt.repository;

import com.smaj.treasureHunt.model.TreasureHuntStep;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreasureHuntStepRepository extends CrudRepository<TreasureHuntStep, Long> {
    void deleteAllByTreasureHuntId(long treasureHuntId);

    List findAllBytreasureHuntId(long treasureHuntId);

}

package com.smaj.treasureHunt.repository;

import com.smaj.treasureHunt.model.TreasureHunt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreasureHuntRepository extends CrudRepository<TreasureHunt, Long> {
    TreasureHunt findByKeyword(String keyword);
}

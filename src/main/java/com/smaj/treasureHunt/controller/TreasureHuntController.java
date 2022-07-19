package com.smaj.treasureHunt.controller;

import com.smaj.treasureHunt.model.TreasureHunt;
import com.smaj.treasureHunt.service.TreasureHuntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class TreasureHuntController {

    @Autowired
    private TreasureHuntService treasureHuntService;

    public TreasureHuntController(@Autowired TreasureHuntService treasureHuntService){
        this.treasureHuntService = treasureHuntService;
    }

    @PostMapping("/addTreasureHunt")
    public ResponseEntity addTreasureHunt(@RequestBody TreasureHunt treasureHunt){
        return ResponseEntity.ok(treasureHuntService.addTreasureHunt(treasureHunt));
    }

    @PutMapping("/updateTreasureHunt")
    public ResponseEntity updateTreasureHunt(@RequestBody TreasureHunt treasureHunt){
        return ResponseEntity.ok(treasureHuntService.addTreasureHunt(treasureHunt));

    }

    @GetMapping("/getTreasureHunt")
    public ResponseEntity getTreasureHunt(@RequestParam long id){
        return ResponseEntity.ok(treasureHuntService.getTreasureHunt(id));
    }
    @GetMapping("/getAllTreasureHunts")
    public ResponseEntity getAllTreasureHunts(){
        return ResponseEntity.ok(treasureHuntService.getAllTreasureHunts());
    }

    @DeleteMapping("/deleteTreasureHunt")
    public ResponseEntity deleteTreasureHunt(@RequestParam long id){
        treasureHuntService.deleteTreasureHunt(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/startTreasureHunt")
    public ResponseEntity startTreasureHunt(@RequestParam long id){
        return ResponseEntity.ok(treasureHuntService.startTreasureHunt(id));
    }
}

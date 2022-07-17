package com.smaj.treasureHunt.controller;


import com.smaj.treasureHunt.model.TreasureHuntStep;
import com.smaj.treasureHunt.service.TreasureHuntStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class TreasureHuntStepController {

    @Autowired
    private TreasureHuntStepService treasureHuntStepService;

    public TreasureHuntStepController(@Autowired TreasureHuntStepService treasureHuntStepService){
        this.treasureHuntStepService = treasureHuntStepService;
    }

    @PostMapping("/addStep")
    public ResponseEntity addStep(@RequestBody TreasureHuntStep step){
        return ResponseEntity.ok(treasureHuntStepService.addStep(step));
    }

    @PutMapping("/updateStep")
    public ResponseEntity updateStep(@RequestBody TreasureHuntStep step){
        try {
           return ResponseEntity.ok(treasureHuntStepService.updateStep(step));
        } catch (Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getStep")
    public ResponseEntity getStep(@RequestParam long stepId){
        return ResponseEntity.ok(treasureHuntStepService.getStep(stepId));
    }
    @GetMapping("/getAllSteps")
    public ResponseEntity getAllSteps(@RequestParam long treasureHuntId){
        return ResponseEntity.ok(treasureHuntStepService.getAllStepsForTreasureHunt(treasureHuntId));
    }

    @DeleteMapping("/deleteSteps")
    public ResponseEntity deleteStep(@RequestParam long treasureHuntId){
        treasureHuntStepService.deleteAllStepsForTreasureHunt(treasureHuntId);
        return ResponseEntity.ok().build();
    }

}

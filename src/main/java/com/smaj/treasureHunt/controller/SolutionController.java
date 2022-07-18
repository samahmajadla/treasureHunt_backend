package com.smaj.treasureHunt.controller;

import com.smaj.treasureHunt.model.Solution;
import com.smaj.treasureHunt.model.TreasureHuntStep;
import com.smaj.treasureHunt.service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class SolutionController {
    @Autowired
    private SolutionService solutionService;

    public SolutionController(@Autowired SolutionService solutionService){
        this.solutionService = solutionService;
    }

    @PostMapping("/addSolution")
    public ResponseEntity addSolution(@RequestBody Solution solution){
        return ResponseEntity.ok(solutionService.addSolution(solution));
    }

    @PostMapping("/checkStringSolution")
    public ResponseEntity checkSolution(@RequestBody Solution guess, @RequestParam long id){
        if (solutionService.checkSolution(guess, id)){
            return ResponseEntity.ok().build();
        }else{
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }


}


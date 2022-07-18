package com.smaj.treasureHunt.service;

import com.smaj.treasureHunt.model.LocationBasedSolution;
import com.smaj.treasureHunt.model.Solution;
import com.smaj.treasureHunt.model.StringMatchSolution;
import com.smaj.treasureHunt.repository.SolutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolutionService {

    @Autowired
    SolutionRepository solutionRepository;

    public SolutionService(SolutionRepository solutionRepository) {
        this.solutionRepository = solutionRepository;
    }

    public Solution addSolution(Solution solution) {
        return this.solutionRepository.save(solution);
    }

    public Solution checkSolution(Solution guess, long id) {
        Solution actualSolution = solutionRepository.findById(id).get();

        if (guess.getClass().equals(LocationBasedSolution.class)){
            LocationBasedSolution locationBasedSolution = (LocationBasedSolution) guess;
            if (actualSolution.checkSolution(locationBasedSolution.getLocation())){
                return solutionRepository.save(actualSolution);

            }
        }
       else {
            StringMatchSolution stringGuess = (StringMatchSolution) guess;
            if (actualSolution.checkSolution(stringGuess.getAnswer())) {
                return solutionRepository.save(actualSolution);
            }
        }
       return guess;
    }
}

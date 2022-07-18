package com.smaj.treasureHunt.service;

import com.smaj.treasureHunt.model.Solution;
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
}

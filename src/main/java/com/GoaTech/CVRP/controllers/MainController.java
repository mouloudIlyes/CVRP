package com.GoaTech.CVRP.controllers;

import com.GoaTech.CVRP.dto.ProblemDto;
import com.GoaTech.CVRP.dto.SolutionDto;
import com.GoaTech.CVRP.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
public class MainController {
    @Autowired
    MainService mainService;
    @PostMapping("simulated-annealing")
    SolutionDto simulatedAnnealing(@RequestBody ProblemDto problemDto){
        return simulatedAnnealing(problemDto);
    }
}

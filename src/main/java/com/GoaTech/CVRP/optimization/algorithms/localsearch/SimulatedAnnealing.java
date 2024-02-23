package com.GoaTech.CVRP.optimization.algorithms.localsearch;


import com.GoaTech.CVRP.optimization.constraints.Constraint;
import com.GoaTech.CVRP.optimization.mechanisms.perturbations.Perturbator;
import com.GoaTech.CVRP.optimization.objectivefunction.ObjectiveFunction;
import com.GoaTech.CVRP.optimization.problem.Problem;
import com.GoaTech.CVRP.optimization.solution.Solution;

import java.util.List;
import java.util.Random;

public record SimulatedAnnealing(int iterations, float initTemperature, float finalTemperature, float gama, Perturbator perturbator) implements LocalSearch {
    private final static float boltzmann = 0.00008617333262145f;
    public Solution decent(Problem problem, Solution solution, List<Constraint> constraints, ObjectiveFunction objectiveFunction){
        float temperature = initTemperature;
        Solution optimaSolution = solution;
        for (int i = 0; i <iterations; i++) {
            Solution newSolution = perturbator.perturbate(problem, solution);
            long delta = objectiveFunction.objective(problem, newSolution)-objectiveFunction.objective(problem, optimaSolution);
            if (delta<=0){
                solution = newSolution;
                optimaSolution = newSolution;
            } else {
                float probability = (float) Math.exp(-((delta/boltzmann)*temperature));
                float theta = new Random().nextFloat();
                if (theta <= probability) solution = newSolution;
            }
            if (temperature <= finalTemperature){
                System.out.println("SA:i=" + i);
                break;
            }
            temperature = temperature * gama;

        }
        return optimaSolution;
    }
}

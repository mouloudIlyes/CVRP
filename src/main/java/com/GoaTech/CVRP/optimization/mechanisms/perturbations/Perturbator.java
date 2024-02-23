package com.GoaTech.CVRP.optimization.mechanisms.perturbations;


import com.GoaTech.CVRP.optimization.problem.Problem;
import com.GoaTech.CVRP.optimization.solution.Solution;

public interface Perturbator {
    Solution perturbate(Problem problem, Solution solution);

}

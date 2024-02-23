package com.GoaTech.CVRP.optimization.objectivefunction;


import com.GoaTech.CVRP.optimization.problem.Problem;
import com.GoaTech.CVRP.optimization.solution.Solution;

public interface ObjectiveFunction {
    Integer objective(Problem problem, Solution solution);
    Boolean betterThen(Problem problem, Solution first, Solution second);
}

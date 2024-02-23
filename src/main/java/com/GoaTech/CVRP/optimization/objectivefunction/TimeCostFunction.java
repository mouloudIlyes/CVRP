package com.GoaTech.CVRP.optimization.objectivefunction;

import com.GoaTech.CVRP.optimization.problem.Problem;
import com.GoaTech.CVRP.optimization.solution.Solution;

import java.util.List;

public class TimeCostFunction implements ObjectiveFunction {
    @Override
    public Integer objective(Problem problem, Solution solution) {
        List<List<Integer>> segments = solution.getSegments(problem.capacities(), problem.wights());
        int cost = 0;
        for (List<Integer> segment : segments) {
            cost += problem.getValue(segment.get(0)) + problem.getValue(segment.get(segment.size() - 1));
            for (int i = 0; i < segment.size() - 1; i++) {
                cost += problem.getEdge(segment.get(i), segment.get(i + 1));
            }
        }
        return cost;
    }

    @Override
    public Boolean betterThen(Problem problem, Solution first, Solution second) {
        return objective(problem, first) < objective(problem, second);
    }
}

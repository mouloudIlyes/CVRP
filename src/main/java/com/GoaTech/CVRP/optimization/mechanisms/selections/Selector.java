package com.GoaTech.CVRP.optimization.mechanisms.selections;

import com.GoaTech.CVRP.optimization.objectivefunction.ObjectiveFunction;
import com.GoaTech.CVRP.optimization.problem.Problem;
import com.GoaTech.CVRP.optimization.solution.Solution;

import java.util.List;

public interface Selector {
    List<Solution> select(Problem problem, List<Solution> solutions, ObjectiveFunction objectiveFunction, int length);
}

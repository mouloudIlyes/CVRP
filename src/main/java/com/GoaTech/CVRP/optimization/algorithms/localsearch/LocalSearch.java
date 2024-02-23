package com.GoaTech.CVRP.optimization.algorithms.localsearch;


import com.GoaTech.CVRP.optimization.constraints.Constraint;
import com.GoaTech.CVRP.optimization.objectivefunction.ObjectiveFunction;
import com.GoaTech.CVRP.optimization.problem.Problem;
import com.GoaTech.CVRP.optimization.solution.Solution;

import java.util.List;

public interface LocalSearch {
    Solution decent(Problem problem, Solution solution, List<Constraint> constraints, ObjectiveFunction objectiveFunction);
}

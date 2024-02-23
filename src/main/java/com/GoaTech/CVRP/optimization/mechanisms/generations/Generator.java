package com.GoaTech.CVRP.optimization.mechanisms.generations;


import com.GoaTech.CVRP.optimization.problem.Problem;
import com.GoaTech.CVRP.optimization.solution.Solution;

public interface Generator {
    Solution generate(Problem problem);
}

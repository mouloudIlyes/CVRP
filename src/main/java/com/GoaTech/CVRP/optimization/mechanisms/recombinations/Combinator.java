package com.GoaTech.CVRP.optimization.mechanisms.recombinations;


import com.GoaTech.CVRP.optimization.constraints.Constraint;
import com.GoaTech.CVRP.optimization.objectivefunction.ObjectiveFunction;
import com.GoaTech.CVRP.optimization.problem.Problem;
import com.GoaTech.CVRP.optimization.solution.Solution;
import org.apache.tomcat.util.bcel.classfile.Constant;

import java.util.List;

public interface Combinator {
    Solution combine(Solution first, Solution second, Problem problem, ObjectiveFunction objectiveFunction);
}

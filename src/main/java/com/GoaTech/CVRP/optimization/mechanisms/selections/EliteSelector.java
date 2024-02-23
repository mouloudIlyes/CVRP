package com.GoaTech.CVRP.optimization.mechanisms.selections;

import com.GoaTech.CVRP.optimization.objectivefunction.ObjectiveFunction;
import com.GoaTech.CVRP.optimization.problem.Problem;
import com.GoaTech.CVRP.optimization.solution.Solution;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EliteSelector implements Selector {
    @Override
    public List<Solution> select(Problem problem, List<Solution> solutions, ObjectiveFunction objectiveFunction, int length) {
        List<Solution> newSolution;
        if (length > solutions.size() / 2) {
            newSolution = new ArrayList<>(solutions);
            while (newSolution.size() > length) {
                newSolution.remove(getWorst(problem, newSolution, objectiveFunction));
            }

       } else {
            newSolution = new ArrayList<>();
            List<Solution> tmpSolution = new ArrayList<>(solutions);
            while (newSolution.size() < length) {
                Solution solution = getBest(problem, tmpSolution, objectiveFunction);
                newSolution.add(solution);
                tmpSolution.remove(solution);
            }
        }
        return newSolution;
    }

    private static Solution getWorst(Problem problem, List<Solution> solutions, ObjectiveFunction objectiveFunction) {
        return solutions.stream().max(new Comparator<Solution>() {
            @Override
            public int compare(Solution o1, Solution o2) {
                if (objectiveFunction.betterThen(problem, o2, o1)) return 1;
                else return -1;
            }
        }).get();
    }

    private static Solution getBest(Problem problem, List<Solution> solutions, ObjectiveFunction objectiveFunction) {
        return solutions.stream().min(new Comparator<Solution>() {
            @Override
            public int compare(Solution o1, Solution o2) {
                if (objectiveFunction.betterThen(problem, o2, o1)) return 1;
                else return -1;
            }
        }).get();
    }
}

package com.GoaTech.CVRP.optimization.mechanisms.perturbations;

import com.GoaTech.CVRP.optimization.problem.Problem;
import com.GoaTech.CVRP.optimization.solution.Solution;

import java.util.Random;

public class RandomPerturbator implements Perturbator {
    @Override
    public Solution perturbate(Problem problem, Solution solution) {
        int[] vector = solution.vector().clone();
        Random random = new Random();
        int value1, value2;
        value1 = random.nextInt(vector.length);
        do {
            value2 = random.nextInt(vector.length);
        } while (value1 == value2);
        int tmp = vector[value1];
        vector[value1] = vector[value2];
        vector[value2] = tmp;
        return new Solution(vector);
    }
}

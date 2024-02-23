package com.GoaTech.CVRP.optimization.mechanisms.generations;

import com.GoaTech.CVRP.optimization.problem.Problem;
import com.GoaTech.CVRP.optimization.solution.Solution;

import java.util.Random;

public class RandomGenerator implements Generator {
    public Solution generate(Problem problem) {
        int size = problem.getGraphSize();
        int[] vector = new int[size];
        boolean[] taken = new boolean[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int value = random.nextInt(size);
            if (taken[value]) do value = (value + 1) % size; while (taken[value]);
            vector[i] = value;
        }
        return new Solution(vector);
    }
}

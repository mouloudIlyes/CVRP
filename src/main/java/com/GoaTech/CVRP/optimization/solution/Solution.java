package com.GoaTech.CVRP.optimization.solution;

import java.util.ArrayList;
import java.util.List;

public record Solution(int[] vector) {
    public List<List<Integer>> getSegments(float[] capacities, float[] wights) {
        List<List<Integer>> segments = new ArrayList<>();
        List<Integer> segment = new ArrayList<>();
        float sum = 0;
        int i = 0;
        int j = 0;
        //TODO... TODO... TODO...
        while (true) {
            if (i >= capacities.length) throw new IllegalStateException("Not Spurted State : No More Trucks");
            sum += wights[j];
            if (sum < capacities[i]) {
                segment.add(j);
                j++;
            } else if (j < wights.length) {
                segments.add(segment);
                break;
            } else {
                segments.add(segment);
                segment = new ArrayList<>();
                sum = 0;
                i++;
            }
        }
        return segments;
    }

}

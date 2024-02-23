package com.GoaTech.CVRP.optimization.problem;

import java.util.Arrays;

public record Problem(long[][] graph, long[] vector, float[] wights, float[] capacities) {

    public Long[] getAdjacent(int node) {
        return Arrays.stream(graph[node]).boxed().toArray(Long[]::new);
    }

    public Long getEdge(int firstNode, int secondNode) {
        return Long.valueOf(graph[firstNode][secondNode]);
    }

    public Long getValue(int node) {
        return vector[node];
    }

    public Long getDegree(int node) {
        return Arrays.stream(graph[node]).sum();
    }
    public Float getWight(int node) {
        return wights[node];
    }

    public Float getCapacity(int index) {
        return capacities[index];
    }

    public Integer getGraphSize() {
        return graph.length;
    }

    public Integer getVectorSize() {
        return capacities.length;
    }

}

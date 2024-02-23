package com.GoaTech.CVRP.services;

import com.GoaTech.CVRP.dto.ProblemDto;
import com.GoaTech.CVRP.dto.SolutionDto;
import com.GoaTech.CVRP.dto.embiddable.Affectation;
import com.GoaTech.CVRP.dto.embiddable.Coordinate;
import com.GoaTech.CVRP.dto.embiddable.Order;
import com.GoaTech.CVRP.dto.embiddable.Truck;
import com.GoaTech.CVRP.optimization.algorithms.localsearch.SimulatedAnnealing;
import com.GoaTech.CVRP.optimization.mechanisms.generations.RandomGenerator;
import com.GoaTech.CVRP.optimization.mechanisms.perturbations.RandomPerturbator;
import com.GoaTech.CVRP.optimization.objectivefunction.ObjectiveFunction;
import com.GoaTech.CVRP.optimization.problem.Problem;
import com.GoaTech.CVRP.optimization.solution.Solution;
import com.GoaTech.CVRP.remote.OsrmClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MainService {
    @Autowired
    OsrmClient openStreetMapClient;

    public MainService(OsrmClient openStreetMapClient) {
        this.openStreetMapClient = openStreetMapClient;
    }

    SolutionDto simulatedAnnealing(ProblemDto problemDto) {
        //
        Problem problem = mapProblem(problemDto);
        //
        RandomGenerator generator = new RandomGenerator();
        Solution initSolution = generator.generate(problem);
        SimulatedAnnealing simulatedAnnealing = new SimulatedAnnealing(200, 10f, 0.1f, 0.95f, new RandomPerturbator());
        Solution finalSolution = simulatedAnnealing.decent(problem, initSolution, null, new ObjectiveFunction() {
            @Override
            public Integer objective(Problem problem, Solution solution) {
                return null;
            }

            @Override
            public Boolean betterThen(Problem problem, Solution first, Solution second) {
                return null;
            }
        });
        //
        SolutionDto solutionDto = mapSolution(problem, finalSolution, problemDto);
        return solutionDto;
    }

    private Problem mapProblem(ProblemDto problemDto) {
        Coordinate coordinatesFrom = problemDto.getCoordinatesFrom();
        List<Order> orders = problemDto.getOrders();
        List<Truck> trucks = problemDto.getTrucks();

        int orderSize = orders.size();
        int truckSize = trucks.size();

        long[][] graph = new long[orderSize][orderSize];
        long[] vector = new long[orderSize];
        float[] capacities = new float[truckSize];
        float[] wights = new float[orderSize];

        for (int i = 0; i < orderSize; i++) {
            vector[i] = openStreetMapClient.getDuration(coordinatesFrom, orders.get(i).getCoordinatesTo());
            wights[i] = orders.get(i).getWight();
            for (int j = i + 1; j < orderSize; j++) {
                graph[i][j] = graph[j][i] = openStreetMapClient.getDuration(orders.get(i).getCoordinatesTo(), orders.get(j).getCoordinatesTo());
            }
        }
        for (int i = 0; i < truckSize; i++) {
            capacities[i] = trucks.get(i).getCapacity();
        }

        Problem problem = new Problem(graph, vector, wights, capacities);
        return problem;
    }

    private SolutionDto mapSolution(Problem problem, Solution solution, ProblemDto problemDto) {
        List<Order> orders = problemDto.getOrders();
        List<Truck> trucks = problemDto.getTrucks();

        List<List<Integer>> segments = solution.getSegments(problem.capacities(), problem.wights());
        List<Affectation> affectations = new ArrayList<>();
        for (int i = 0; i < segments.size(); i++) {
            affectations.add(new Affectation(trucks.get(i).getId(), orders.stream().map(o -> o.getId()).collect(Collectors.toList())));
        }
        SolutionDto solutionDto = new SolutionDto();
        return solutionDto;
    }
}

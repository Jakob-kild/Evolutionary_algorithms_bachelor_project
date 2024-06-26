package group.ea.algorithm;

import group.ea.problem.TSP.City;
import group.ea.problem.TSP.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class TSPDATA {
    public int optCase;
    public Solution solution;
    public int generation;
    public int fitness;
    public ArrayList<City> slSolution;
    public double improvement;
    private long timeElapsed = 0;
    public City X1, X2, X3, X4, X5, X6;
    private boolean stopped = false;

    public boolean opt3;

    public String name;


    private int functionEvaluations = 0;

    static ArrayList<TSPDATA> allSolutions = new ArrayList<>();
    private double[][] pheromone;


    private boolean improved = false;

    public TSPDATA(Solution solution, ArrayList<City> slSolution, int generation, int fitness, double improvement, City X1, City X2, City X3, City X4, Optional<City> A5, Optional<City> A6, Optional<Integer> optCase, boolean b, String name) {
        this.solution = solution;
        this.generation = generation;
        this.fitness = fitness;
        this.improvement = improvement;
        this.X1 = X1;
        this.X2 = X2;
        this.X3 = X3;
        this.X4 = X4;
        this.X5 = A5.orElse(null); // Assign null if A5 is not present
        this.X6 = A6.orElse(null); // Assign null if A6 is not present
        this.optCase = optCase.orElse(-1); // Assign null if optCase is not present
        this.opt3 = b;
        this.slSolution = slSolution;
        allSolutions.add(this);
        this.name = name;
    }

    public TSPDATA(Solution solution, ArrayList<City> slSolution, int generation, int fitness, double improvement, String name) {
        this.solution = solution;
        this.generation = generation;
        this.fitness = fitness;
        this.improvement = improvement;
        this.slSolution = slSolution;
        this.name = name;
        allSolutions.add(this);


    }

    public TSPDATA(Solution solution, ArrayList<City> slSolution, int generation, int fitness, int functionEvaluations, String name, boolean stopped) {
        this.solution = solution;
        this.generation = generation;
        this.fitness = fitness;
        this.functionEvaluations = functionEvaluations;
        this.slSolution = slSolution;
        allSolutions.add(this);
        this.name = name;
        this.stopped = stopped;

    }

    public String getName() {
        return name;
    }

    public void setPhermone(double[][] pheromone) {
        this.pheromone = pheromone;
    }

    public double[][] getPheromone() {
        return pheromone;
    }


    public Solution getSolution() {
        return solution;
    }

    public void setTimeElapsed(long timeElapsed) {
        this.timeElapsed = timeElapsed;
    }

    public long getTimeElapsed() {
        return timeElapsed;
    }

    public void setSolution(Solution solution) {
        this.solution = solution;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public int getFitness() {
        return fitness;
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;
    }

    public double getImprovement() {
        return improvement;
    }

    public void setImprovement(double improvement) {
        this.improvement = improvement;
    }


    public void setFunctionEvaluations(int functionEvaluations) {
        this.functionEvaluations = functionEvaluations;
    }

    public int getFunctionEvaluations() {
        return functionEvaluations;
    }

    public int getOptimum() {
        String name = solution.get_tsp().getLastPartOfFilename();
        if (Objects.equals(name, "berlin52")) {
            return 7544;
        } else if (Objects.equals(name, "a280")) {
            return 2579;
        } else if (Objects.equals(name, "bier127")) {
            return 118282;
        }
        return 0;
    }

    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }

    public boolean isStopped() {
        return stopped;
    }

    public void improved() {
        this.improved = true;
    }

    public boolean isImproved() {
        return improved;
    }

}



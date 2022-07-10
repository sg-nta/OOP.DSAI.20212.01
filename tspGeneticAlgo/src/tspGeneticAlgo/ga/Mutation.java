package tspGeneticAlgo.ga;

import java.util.ArrayList;
import java.util.Random;

import tspGeneticAlgo.components.Individual;
import tspGeneticAlgo.components.Population;

public class Mutation extends GeneticOperator{

	private double mutationRate;
	private int elitism;
	public Mutation(Population population, double mutationRate, int elitism) {
		super(population);
		this.mutationRate = mutationRate;
		this.elitism = elitism;
		// TODO Auto-generated constructor stub
	}
	public void execute() {
		Population result = new Population(population.getSize());
		for (int i = 0; i < population.getSize(); i++) {
			Individual individual = population.sortByFitness().get(i);
			if (i >= this.elitism) {
				if (this.mutationRate >= Math.random()) {
					Random rd = new Random();
					int rand1 = rd.nextInt(1, individual.getLength());
					int rand2 = rd.nextInt(1, individual.getLength());

					int start = Math.min(rand1, rand2);
					int end = Math.max(rand1, rand2);

					if (start == end) {
						end += 1;
					}
					ArrayList<Integer> mutationList = new ArrayList<Integer>();
					for (int j = start; j < end; j ++) {
						mutationList.add(individual.getElement(j));
					}

					for (int j = start; j < end; j ++) {
						individual.setElement(j, mutationList.get(mutationList.size() - 1));
						mutationList.remove(mutationList.size() - 1);
					}
				}
			}
			result.setIndividual(i, individual);
		}
		this.population = result;
	}


}

package tspGeneticAlgo.ga;

import java.util.Random;

import tspGeneticAlgo.components.Individual;
import tspGeneticAlgo.components.Population;

public class TwoPointSwappingMutation extends Mutation{


	public TwoPointSwappingMutation(Population population, double mutationRate, int elitism) {
		super(population, mutationRate, elitism);
		// TODO Auto-generated constructor stub
	}

	public void execute() {
		Population result = new Population(population.getSize());
		for (int i = 0; i < population.getSize(); i++) {
			Individual individual = population.sortByFitness().get(i);
			if (i >= this.elitism) {
				if (this.mutationRate >= Math.random()) {
					Random rd = new Random();
					int rand1 = rd.nextInt(1, individual.getLength() - 1);
					int rand2 = rd.nextInt(1, individual.getLength() - 1 );

					int start = Math.min(rand1, rand2);
					int end = Math.max(rand1, rand2);

					if (start == end) {
						end += 1;
					}
					
					int temp = individual.getElement(start);
					individual.setElement(start, individual.getElement(end));
					individual.setElement(end, temp);

				}
			}
			result.setIndividual(i, individual);
		}
		this.population = result;
	}
}

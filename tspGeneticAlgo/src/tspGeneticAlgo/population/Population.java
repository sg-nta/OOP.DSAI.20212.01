package tspGeneticAlgo.population;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tspGeneticAlgo.individual.Individual;


public class Population {
	private ArrayList<Individual> population = new ArrayList<Individual>();

//	========== Constructor ===========
//	A population consist of n individual (population size = n)
	public Population(int populationSize) {
		this.population = new ArrayList<Individual>(Collections.nCopies(populationSize, null));
	}
/*	More specifically, a population consist of n individual with (a number of genes
	- chromosomeLength) in each individual */

	public Population(int populationSize, int chromosomeLength) {
		this.population = new ArrayList<Individual>();
		for (int individualCount = 1; individualCount < populationSize; individualCount++) {
			Individual individual = new Individual(chromosomeLength);
			this.population.add(individual);
		}
	}
//	========== Get & set =============
	public ArrayList<Individual> getPopulation() {
		return population;
	}

	public void setIndividual(int index, Individual individual) {
		this.population.set(index, individual);
	}

	public Individual getIndividual(int index) {
		return this.population.get(index);
	}
	public int getSize() {
		return this.population.size();
	}

	public List<Individual> sortByFitness(){
		Collections.sort(population, Individual.COMPARE_BY_FITNESS);
		return population;
	}

}

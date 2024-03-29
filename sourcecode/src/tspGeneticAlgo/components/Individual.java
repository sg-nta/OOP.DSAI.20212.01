package tspGeneticAlgo.components;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Individual {
	private ArrayList<Integer> chromosome;
	private double fitness;
	public static final Comparator<Individual> COMPARE_BY_FITNESS = new IndividualComparatorByFitness();

//	============= Constructor ============
	public Individual(ArrayList<Integer> chromosome) {
		this.chromosome = chromosome;
		// TODO Auto-generated constructor stub
	}

	public Individual(int nGene) {
		ArrayList<Integer> individual = new ArrayList<>();
		for (int gene = 0; gene < nGene; gene++) {
			individual.add(gene);
		}

		this.chromosome = individual;
	}
//	============== Get & Set ==============
	public ArrayList<Integer> getChromosome() {
		return this.chromosome;
	}
	public double getFitness() {
		return fitness;
	}
	public void setFitness(double fitness) {
		this.fitness = fitness;
	}
	public int getElement(int index) {
		return this.chromosome.get(index);
	}
	public void setElement(int index, int value) {
		this.chromosome.set(index, value);
	}
	public int getLength() {
		return this.chromosome.size();
	}

	public boolean containElement(int value) {
		for (int e: this.chromosome) {
			if (e == value) {
				return true;
			}
		}
		return false;
	}

	public String toString() {
		StringBuilder res = new StringBuilder();
		for (Integer i : chromosome) {
			res.append(i);
			res.append(" - ");
		}
		res.append(chromosome.get(0));
		return res.toString();
	}

}

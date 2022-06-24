package tspGeneticAlgo.individual;

import java.util.ArrayList;
import java.util.Comparator;

public class Individual {
	private ArrayList<Integer> chromosome = new ArrayList<Integer>();;
	private double fitness;
	public static final Comparator<Individual> COMPARE_BY_FITNESS = new IndividualComparatorByFitness();
	public Individual(ArrayList<Integer> chromosome) {
		this.chromosome = chromosome;
		// TODO Auto-generated constructor stub
	}
	public Individual(int chromosomeLength) {
		ArrayList<Integer> individual = new ArrayList<Integer>();
		for (int gene = 0; gene < chromosomeLength; gene++) {
			individual.add(gene);
		}
		
		this.chromosome = individual;
	}
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
		String res = "";
		for (Integer i : chromosome) {
			res += i;
			res += " - ";
		}
		res += "0.";
		return res;
	}
	
	
	

}

package tspGeneticAlgo.individual;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

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
<<<<<<< HEAD

//		randomize(individual, nGene);
//		randomizeIncludeInitCity(individual, nGene);
//		randomizeIncludeInitCity give the best performance
//		(faster convergence and shortest optimal result)
=======
		
>>>>>>> main
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
<<<<<<< HEAD

=======
>>>>>>> main
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
<<<<<<< HEAD
		res.append(chromosome.get(0));
		return res.toString();
	}

	public void randomize(ArrayList<Integer> individual, int nGene){
		for (int i = nGene - 1; i > 0; i--){
			Random rand = new Random();
			int index = rand.nextInt(1, nGene);
			int a = individual.get(index);
			individual.set(index, individual.get(i));
			individual.set(i, a);
		}
	}

	public void randomizeIncludeInitCity(ArrayList<Integer> individual, int nGene){
		for (int i = nGene - 1; i > 0; i--){
			Random rand = new Random();
			int index = rand.nextInt(0, nGene);
			int a = individual.get(index);
			individual.set(index, individual.get(i));
			individual.set(i, a);
		}
	}
=======
		res += "0.";
		return res;
	}
	
	
	

>>>>>>> main
}

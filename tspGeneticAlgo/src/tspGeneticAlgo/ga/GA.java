package tspGeneticAlgo.ga;

import java.lang.Math;
import java.util.*;

import tspGeneticAlgo.individual.Individual;
import tspGeneticAlgo.node.Node;
import tspGeneticAlgo.population.Population;
import tspGeneticAlgo.route.Route;


public class GA {
	private double mutationRate;
	private double crossOverRate;
	private int populationSize;
    private int survival;
	private int tournamentSize;


	public GA(int populationSize, double mutationRate, double crossOverRate, int survival,
			int tournamentSize) {
		this.crossOverRate = crossOverRate;
		this.mutationRate = mutationRate;
		this.populationSize = populationSize;
        this.survival = survival;
		this.tournamentSize = tournamentSize;

	}
	public Population initPopulation(int chromosomeLength) {
		return new Population(this.populationSize, chromosomeLength);
	}
<<<<<<< HEAD

	public void updateFitness(Population population, Node[]nodes) {
		for (Individual individual : population.getPopulation()) {
			Set<Integer> uniqueGenes = new HashSet<Integer>(individual.getChromosome());
			if (uniqueGenes.size() < individual.getLength()){
				individual.setFitness(- Math.pow(10,10));
			} else {
				Route route = new Route(individual, nodes);
				double fitness = - route.totalDistance();
				individual.setFitness(fitness);
=======
	public void updateFitness(Population population, Node[] nodes) {
		for (Individual individual : population.getPopulation()) {
			Route route = new Route(individual, nodes);
			double fitness = 1/route.totalDistance();
			individual.setFitness(fitness);
		}
	}
	public Individual selectMother(Population population, Individual father) {
		ArrayList<Individual> tournament = new ArrayList<Individual>();
		int[] indexList = new int[this.tournamentSize];
		while (tournament.size() < this.tournamentSize) {
			int rand = (int) (Math.random()*population.getSize());
			int check = 0;
			for (int index:indexList) {
				if (rand == index) {
					check += 1;
				}
			}
			if (check == 0 && population.getIndividual(rand) != father) {
				tournament.add(population.getIndividual(rand));
>>>>>>> main
			}
		}
	}
<<<<<<< HEAD
	public Individual selection(Population population) {
		Population selected = new Population((int)(population.getSize()/(nGene)) + 5);
		Random rnd = new Random();
		for (int i = 0; i < selected.getSize(); i++) {
			int index = rnd.nextInt(i + 1);
			selected.setIndividual(i, population.getIndividual(index));
		}
		// Return the best
		return selected.sortByFitness().get(0);
	}

=======
	
>>>>>>> main
	public Population crossOver(Population population) {
		Population result = new Population(population.getSize());
		for (int i = 0; i < population.getSize(); i++) {
			Individual father = population.sortByFitness().get(i);
<<<<<<< HEAD
			if (this.crossOverRate > Math.random() && i >= this.elitism ) {
				Individual mother = this.selection(population);
=======
			if (this.crossOverRate > Math.random() && i >= this.survival ) {
				Individual mother = this.selectMother(population, father);
>>>>>>> main
				ArrayList<Integer> childChromosome = new ArrayList<Integer>(Collections.nCopies(father.getLength(), -1));
				
				Individual child = new Individual(childChromosome);
				int rand1 = (int) (Math.random()*father.getLength());
				int rand2 = (int) (Math.random()*father.getLength());
				
				int start = Math.min(rand1, rand2);
				int end = Math.max(rand1, rand2);
				child.setElement(0, father.getElement(0));
				for (int j = start; j < end; j++) {
					child.setElement(j, father.getElement(j));
				}
				for (int j = 0; j < father.getLength(); j++) {
					int index = j + end;
					if (index >= father.getLength()) {
						index -= father.getLength();
					}
					if (child.containElement(mother.getElement(index)) == false) {
						for (int k = 0; k < child.getLength(); k++) {
							if (child.getElement(k) == -1) {
								child.setElement(k, mother.getElement(index));
								break;
							}
						}
					}
				}
				result.setIndividual(i, child);
			}
			else {
				result.setIndividual(i, father);
			}
		}
		return result;
	}
<<<<<<< HEAD

=======
	
>>>>>>> main
	public Population mutation(Population population) {
		Population result = new Population(population.getSize());
		for (int i = 0; i < population.getSize(); i++) {
			Individual individual = population.sortByFitness().get(i);
<<<<<<< HEAD
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
=======
			
			if (i >= this.survival) {
				if (this.mutationRate >= Math.random()) {

						int rand1 = (int) (Math.random()*individual.getLength());
						int rand2 = (int) (Math.random()*individual.getLength());
						
						int start = Math.min(rand1, rand2);
						int end = Math.max(rand1, rand2);
						if (start == 0) {
							start = 1;
						}
						if (start > end) {
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
						 
>>>>>>> main
				}
			}
			result.setIndividual(i, individual);
		}
		return result;
	}
	
	

}

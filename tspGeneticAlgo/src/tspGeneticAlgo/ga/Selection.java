package tspGeneticAlgo.ga;

import java.util.Random;

import tspGeneticAlgo.components.Individual;
import tspGeneticAlgo.components.Population;

public class Selection extends GeneticOperator{
	private int elitism;
	private int tournamentSize;
	private Individual father;
	private Individual mother;
	private int index;
	public Selection(Population population, int elitism, int tournamentSize, int index) {
		super(population);
		this.elitism = elitism;
		this.tournamentSize = tournamentSize;
		this.index = index;
		// TODO Auto-generated constructor stub
	}

	public Individual getFather() {
		return father;
	}
	public Individual getMother() {
		return mother;
	}
	public void execute() {

		this.father = this.population.sortByFitness().get(this.index);
		if (this.index >= this.elitism) {
			Population selected = new Population(this.tournamentSize);
			Random rnd = new Random();
			for (int i = 0; i < selected.getSize(); i++) {
				int id = rnd.nextInt(i + 1);
				selected.setIndividual(i, this.population.getIndividual(id));
			}
			// Return the best
			this.mother =  selected.sortByFitness().get(0);
		}
		else {
			this.mother = null;
		}

	}
	
}

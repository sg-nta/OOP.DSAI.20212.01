package tspGeneticAlgo.ga;

import java.util.Random;

import tspGeneticAlgo.components.Population;

public class TournamentSelection extends Selection{

	private int tournamentSize;
	private int index;

	public TournamentSelection(Population population, int elitism, int tournamentSize, int index) {
		super(population, elitism);
		this.tournamentSize = tournamentSize;
		this.index = index;
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

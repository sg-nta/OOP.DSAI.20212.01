package tspGeneticAlgo.ga;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import tspGeneticAlgo.components.Individual;
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
			ArrayList<Individual> randomIndividuals = new ArrayList<Individual>();
			int[] indexList = new int[this.tournamentSize];
			while (randomIndividuals.size() < this.tournamentSize) {
				int rand = (int) (Math.random()*population.getSize());
				int check = 0;
				for (int index:indexList) {
					if (rand == index) {
						check += 1;
					}
				}
				if (check == 0 && population.getIndividual(rand) != father) {
					randomIndividuals.add(population.getIndividual(rand));
				}
			}
			Population tournament = new Population(this.tournamentSize);
			for (int i = 0; i < tournamentSize; i++) {
				tournament.setIndividual(i, randomIndividuals.get(i));
			}
			List<Individual> sortedTournament = tournament.sortByFitness();
			this.mother =  sortedTournament.get(0);
		}
		else {
			this.mother = null;
		}
	}
}

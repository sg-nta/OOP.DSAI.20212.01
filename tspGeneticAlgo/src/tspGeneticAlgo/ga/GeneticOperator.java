package tspGeneticAlgo.ga;

import tspGeneticAlgo.components.Population;

public abstract class GeneticOperator {
	protected Population population;
	public GeneticOperator(Population population) {
		this.population = population;
	}
	public abstract void execute();
	public Population getPopulation() {
		return population;
	}
	
}

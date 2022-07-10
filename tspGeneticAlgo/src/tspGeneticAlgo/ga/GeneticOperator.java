package tspGeneticAlgo.ga;

import tspGeneticAlgo.components.Population;

public abstract class GeneticOperator {
	protected Population population;
	public GeneticOperator(Population population) {
		this.population = population;
	}
	public void execute() {
		
	}
	public Population getPopulation() {
		return population;
	}
	
}

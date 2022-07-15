package tspGeneticAlgo.ga;


import tspGeneticAlgo.components.Individual;
import tspGeneticAlgo.components.Population;

public abstract class Selection extends GeneticOperator{
	protected int elitism;
	protected Individual father;
	protected Individual mother;
	public Selection(Population population, int elitism) {
		super(population);
		this.elitism = elitism;
	}

	public Individual getFather() {
		return father;
	}
	public Individual getMother() {
		return mother;
	}
	
	public abstract void execute();
}

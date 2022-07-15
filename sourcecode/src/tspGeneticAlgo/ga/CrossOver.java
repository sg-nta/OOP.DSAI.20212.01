package tspGeneticAlgo.ga;

import java.util.ArrayList;
import java.util.Collections;

import tspGeneticAlgo.components.Individual;
import tspGeneticAlgo.components.Population;

public abstract class CrossOver extends GeneticOperator {

	protected double crossOverRate;
	protected Individual father;
	protected Individual mother;
	protected Population result;
	public CrossOver(Population population, double crossOverRate, Individual father, Individual mother) {
		super(population);
		this.crossOverRate = crossOverRate;
		this.father = father;
		this.mother = mother;
		// TODO Auto-generated constructor stub
	}
	public abstract void execute();
	public Population getResult() {
		return result;
	}
	public void setResult(Population result) {
		this.result = result;
	}
	

}

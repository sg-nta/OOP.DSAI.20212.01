package tspGeneticAlgo.ga;

import java.util.ArrayList;
import java.util.Random;

import tspGeneticAlgo.components.Population;

public abstract class Mutation extends GeneticOperator{

	protected double mutationRate;
	protected int elitism;
	public Mutation(Population population, double mutationRate, int elitism) {
		super(population);
		this.mutationRate = mutationRate;
		this.elitism = elitism;
		// TODO Auto-generated constructor stub
	}
	public abstract void execute();


}

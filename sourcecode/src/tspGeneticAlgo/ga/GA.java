package tspGeneticAlgo.ga;

import java.util.HashSet;
import java.util.Set;

import tspGeneticAlgo.components.Individual;
import tspGeneticAlgo.components.Node;
import tspGeneticAlgo.components.Population;
import tspGeneticAlgo.components.Route;

public class GA {

	private double mutationRate;
	private double crossOverRate;
	private int populationSize;
    private int elitism;
	private int nGene;
	private int tournamentSize;

	public GA(int populationSize, int nGene, double mutationRate, double crossOverRate, int elitism, int tournamentSize) {
		this.crossOverRate = crossOverRate;
		this.mutationRate = mutationRate;
		this.populationSize = populationSize;
        this.elitism = elitism;
		this.nGene = nGene;
		this.tournamentSize = tournamentSize;
	}
	public Node[] generateNodes() {
		Node[] nodes = new Node[this.nGene];
		for (int i = 0; i < this.nGene; i++) {
			int xPos = (int) (100 * Math.random() + 10);
			int yPos = (int) (100 * Math.random() + 10);
			nodes[i] = new Node(xPos, yPos);
		}
		return nodes;
	}
	public Population initPopulation() {
		return new Population(this.populationSize, nGene);
	}

	public void updateFitness(Population population, Node[]nodes) {
		for (Individual individual : population.getPopulation()) {
			Set<Integer> uniqueGenes = new HashSet<Integer>(individual.getChromosome());
			if (uniqueGenes.size() < individual.getLength()){
				individual.setFitness(- Math.pow(10,10));
			} else {
				Route route = new Route(individual, nodes);
				double fitness = - route.totalDistance();
				individual.setFitness(fitness);
			}
		}
	}
	public Population execute(Population population) {
		Population result = new Population(population.getSize());
		for (int i = 0; i < population.getSize(); i++) {
			
			Selection selection = new TournamentSelection(population,elitism,tournamentSize,i);
			selection.execute();
			Individual father = selection.getFather();
			Individual mother = selection.getMother();
			
			CrossOver crossOver = new TwoPointCrossOver(population, crossOverRate, father, mother, i);
			crossOver.setResult(result);
			crossOver.execute();
			
			result = crossOver.getResult();
		}
		population = result;
		Mutation mutation = new TwoPointSwappingMutation(population, mutationRate, elitism);
		mutation.execute();
		population = mutation.getPopulation();
		return population;
	}
}

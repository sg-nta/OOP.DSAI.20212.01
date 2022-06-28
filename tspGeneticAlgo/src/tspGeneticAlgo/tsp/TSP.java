package tspGeneticAlgo.tsp;

import java.util.List;

import tspGeneticAlgo.ga.GA;
import tspGeneticAlgo.individual.Individual;
import tspGeneticAlgo.node.Node;
import tspGeneticAlgo.population.Population;
import tspGeneticAlgo.route.Route;

public class TSP {
	private final static int maxGenerations = 1000;
	private static Node[] nodes;
	private static Population population;
	private static GA ga;
	private static Route route;
	public static void main (String [] args) {
		List<Individual> sortedPopulation;

		
		ga = new GA(100, 10, 0.001, 0.9, 7);
		population = ga.initPopulation();

		nodes = new Node[ga.getnGene()];
		for (int i = 0; i < ga.getnGene(); i++) {
			int xPos = (int) (100 * Math.random());
			int yPos = (int) (100 * Math.random());
			nodes[i] = new Node(xPos, yPos);
		}
		ga.updateFitness(population, nodes);
		sortedPopulation = population.sortByFitness();
		route = new Route(sortedPopulation.get(0), nodes);
		System.out.println("Start Distance: " + route.totalDistance());
		int generation = 1;
		
		while(generation < maxGenerations + 1) {
			sortedPopulation = population.sortByFitness();
			route = new Route(sortedPopulation.get(0), nodes);
			System.out.println("G"+generation+" Best distance: " + route.totalDistance());
			//System.out.println("Best route: " + sortedPopulation.get(0).toString());
			population = ga.crossOver(population);
			population = ga.mutation(population);
			ga.updateFitness(population, nodes);
			generation ++;
		}

		System.out.println("Stopped after " + maxGenerations + " generations.");
		sortedPopulation = population.sortByFitness();
		Route route = new Route(sortedPopulation.get(0), nodes);
		System.out.println("Best distance: " + route.totalDistance());
		System.out.println("Route: " + sortedPopulation.get(0));
	}
}

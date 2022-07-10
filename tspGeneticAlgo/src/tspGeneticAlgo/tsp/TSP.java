package tspGeneticAlgo.tsp;

import java.util.List;

import tspGeneticAlgo.components.Individual;
import tspGeneticAlgo.components.Node;
import tspGeneticAlgo.components.Population;
import tspGeneticAlgo.components.Route;
import tspGeneticAlgo.ga.GA;

public class TSP {
	private final static int numNodes = 100;
	private final static int maxGenerations = 10000;
	private static Node[] nodes;
	private static Population population;
	private static GA ga;
	private static Route route;
	public static void main (String [] args) {
		List<Individual> sortedPopulation;
		nodes = new Node[100];
		for (int i = 0; i < 100; i++) {
			int xPos = (int) (100 * Math.random() + 10);
			int yPos = (int) (100 * Math.random() + 10);

			nodes[i] = new Node(xPos, yPos);
		}
		ga = new GA(200, 100, 0.05, 0.9, 7, 10);
		population = ga.initPopulation();

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
			population = ga.execute(population);
			ga.updateFitness(population, nodes);
			generation ++;
		}

		System.out.println("Stopped after " + maxGenerations + " generations.");
		sortedPopulation = population.sortByFitness();
		Route route = new Route(sortedPopulation.get(0), nodes);
		System.out.println("Best distance: " + route.totalDistance());
	}
}

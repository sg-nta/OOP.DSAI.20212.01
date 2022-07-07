package tspGeneticAlgo.individual;

import java.util.Comparator;

public class IndividualComparatorByFitness implements Comparator<Individual>{

	@Override
	public int compare(Individual o1, Individual o2) {
		return - Double.compare(o1.getFitness(),o2.getFitness());
	}

}

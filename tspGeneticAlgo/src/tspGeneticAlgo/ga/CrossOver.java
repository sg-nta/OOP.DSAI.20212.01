package tspGeneticAlgo.ga;

import java.util.ArrayList;
import java.util.Collections;

import tspGeneticAlgo.components.Individual;
import tspGeneticAlgo.components.Population;

public class CrossOver extends GeneticOperator {

	private double crossOverRate;
	private Individual father;
	private Individual mother;
	private int index;
	private Population result;
	public CrossOver(Population population, double crossOverRate, Individual father, Individual mother, int index) {
		super(population);
		this.crossOverRate = crossOverRate;
		this.father = father;
		this.mother = mother;
		this.index = index;
		// TODO Auto-generated constructor stub
	}
	public void execute() {
		
		if (this.crossOverRate > Math.random() && this.mother != null) {
			ArrayList<Integer> childChromosome = new ArrayList<Integer>(Collections.nCopies(father.getLength(), -1));

			Individual child = new Individual(childChromosome);
			int rand1 = (int) (Math.random()*father.getLength());
			int rand2 = (int) (Math.random()*father.getLength());

			int start = Math.min(rand1, rand2);
			int end = Math.max(rand1, rand2);
			child.setElement(0, father.getElement(0));
			for (int j = start; j < end; j++) {
				child.setElement(j, father.getElement(j));
			}
			for (int j = 0; j < father.getLength(); j++) {
				int index = j + end;
				if (index >= father.getLength()) {
					index -= father.getLength();
				}
				if (child.containElement(mother.getElement(index)) == false) {
					for (int k = 0; k < child.getLength(); k++) {
						if (child.getElement(k) == -1) {
							child.setElement(k, mother.getElement(index));
							break;
						}
					}
				}
			}
			result.setIndividual(index, child);
		}
		else {
			result.setIndividual(index, father);
		}
	}
	public Population getResult() {
		return result;
	}
	public void setResult(Population result) {
		this.result = result;
	}
	

}

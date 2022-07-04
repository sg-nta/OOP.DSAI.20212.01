package tspGeneticAlgo.gui;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import tspGeneticAlgo.ga.GA;
import tspGeneticAlgo.gui.Draw;
import tspGeneticAlgo.individual.Individual;
import tspGeneticAlgo.node.Node;
import tspGeneticAlgo.population.Population;
import tspGeneticAlgo.route.Route;

public class GUI extends JFrame{
	private Route route;
	private Route prevRoute;
	private JTextField populationSizeText;
	private JTextField numGensText;
	private JTextField numNodesText;
	private JTextField numSurvivalText;
	private JTextField generations;
	private JTextField bestDistance;
	private int generation = 1;
	private Population population;
	private Timer time;
	private JButton btnSubmit;
	private JButton btnStop;
	private int populationSize;
	private int numGens;
	private int numNodes;
	private int numSurvival;
	private int status = 0;
	private Draw draw = new Draw();
	private List<Individual> sortedPopulation;
	
	public GUI() {
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		setTitle("Genetic Algorithm for TSP");
		cp.add(createEast(), BorderLayout.EAST);
		cp.add(draw, BorderLayout.CENTER);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public static void main(String[] args) {
		new GUI();
	}
	private JPanel createEast() {
		JPanel east = new JPanel();
		east.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		east.add(new JLabel("Population size: "), gbc);
		gbc.gridy += 1;
		east.add(new JLabel("Number of generations: "), gbc);
		gbc.gridy += 1;
		east.add(new JLabel("Number of nodes: "), gbc);
		gbc.gridy += 1;
		east.add(new JLabel("Number of survivals: "), gbc);
		gbc.gridy += 3;
		east.add(new JLabel("Generations: "), gbc);
		gbc.gridy += 1;
		east.add(new JLabel("Best Distance: "), gbc);

		gbc.gridx++;
		gbc.gridy = 0;
		
		populationSizeText = new JTextField(10);
		east.add(populationSizeText, gbc);
		gbc.gridy+= 1;
		
		numGensText = new JTextField(10);
		east.add(numGensText, gbc);
		gbc.gridy+= 1;
		
		numNodesText = new JTextField(10);
		east.add(numNodesText, gbc);
		gbc.gridy+= 1;
		
		numSurvivalText = new JTextField(10);
		east.add(numSurvivalText, gbc);
		gbc.gridy+= 1;
		
		btnSubmit = new JButton("Enter");
		btnSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (status == 0) {
					status = 1;
					generations.setText("");
					bestDistance.setText("");
					generation = 1;
					populationSize = Integer.parseInt(populationSizeText.getText()) ;
					numGens = Integer.parseInt(numGensText.getText()) ;
					numNodes = Integer.parseInt(numNodesText.getText()) ;
					numSurvival = Integer.parseInt(numSurvivalText.getText());
	
					Node nodes[] = new Node[numNodes];
					for (int i = 0; i < numNodes; i++) {
						int xPos = (int) (100 * Math.random());
						int yPos = (int) (100 * Math.random());
	
						nodes[i] = new Node(xPos, yPos);
					}
					
					GA ga = new GA(populationSize, 0.001, 0.9, numSurvival, 5);
					population = ga.initPopulation(numNodes);
					ga.updateFitness(population, nodes);
					sortedPopulation = population.sortByFitness();
					Route startRoute = new Route(sortedPopulation.get(0), nodes);
					prevRoute = startRoute;
					
					time = new Timer(20, new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							sortedPopulation = population.sortByFitness();
							Route route = new Route(sortedPopulation.get(0), nodes);
							System.out.println("G"+generation+" Best distance: " + route.totalDistance());
							generations.setText(String.valueOf(generation));
							bestDistance.setText(String.valueOf((double)Math.round(route.totalDistance()*100)/100));
							population = ga.crossOver(population);
							population = ga.mutation(population);
							ga.updateFitness(population, nodes);
							if (prevRoute.getRoute().equals(route.getRoute()) == false) {
	
								draw.setRoute(route);
								draw.paint(getGraphics());
							}
							generation ++;
							prevRoute = route;
							if ((generation == numGens + 1) || (status == 0)){
								time.stop();
								status = 0;
							}
	
	
							
						}
						
					});
					time.start();
				}
			}
			
		});
		east.add(btnSubmit, gbc);
		gbc.gridy++;
		
		btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				status = 0;
			}
			
		});
		east.add(btnStop, gbc);
		gbc.gridy++;

		generations = new JTextField(10);
		generations.setEditable(false);
		east.add(generations, gbc);
		gbc.gridy++;
		
		bestDistance = new JTextField(10);
		bestDistance.setEditable(false);
		east.add(bestDistance, gbc);
		
		return east;
		
	}
	

}
	

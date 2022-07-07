package tspGeneticAlgo.gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

import tspGeneticAlgo.ga.GA;
import tspGeneticAlgo.individual.Individual;
import tspGeneticAlgo.node.Node;
import tspGeneticAlgo.population.Population;
import tspGeneticAlgo.route.Route;

public class GUI extends JFrame{
//	private Route route;
	private Route prevRoute;
	private JTextField populationSizeText;
	private JTextField numGensText;
	private JTextField numNodesText;
	private JTextField numSurvivalText;
	private JTextField rCrossOverText;
	private JTextField rMutationText;
	private JLabel lblgenerations;
	private JLabel bestDistance;
	private int generation = 1;
	private Population population;
	private Timer time;

	private int status = 0;
	private Draw draw = new Draw();
	private List<Individual> sortedPopulation;

	public GUI() {
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		setTitle("Genetic Algorithm for TSP");
		cp.add(createEast(), BorderLayout.EAST);
		cp.add(draw, BorderLayout.CENTER);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1080, 720);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public static void main(String[] args) {
		new GUI();
	}
	private JPanel createEast() {
		JPanel east = new JPanel();

		east.setLayout(new GridBagLayout());
		east.setBackground(new Color(240, 235, 227));
		GridBagConstraints gbc = new GridBagConstraints();
		east.setPreferredSize(new Dimension(320, 720));
		gbc.gridx = 0;
		gbc.gridy = 0;
		east.add(new JLabel(""), gbc);
		gbc.gridy += 1;

//		==== Create general Font and Dimension=====
		Font myFont = new Font("Arial", 0, 18);
		Dimension lblDim = new Dimension(150, 18);
		Dimension tfDim = new Dimension(80, 50);
		Dimension btnDim = new Dimension(120, 50);
		Color lblColor = new Color(63, 78, 79);
//		=================================================

		JLabel lblSize = new JLabel("Population size: ", 2);
		lblSize.setPreferredSize(lblDim);
		lblSize.setFont(myFont);
		lblSize.setForeground(lblColor);
		east.add(lblSize, gbc);
		gbc.gridy += 1;

		JLabel lblGen = new JLabel("Total generations: ", 2);
		lblGen.setPreferredSize(lblDim);
		lblGen.setFont(myFont);
		lblGen.setForeground(lblColor);
		east.add(lblGen, gbc);
		gbc.gridy += 1;

		JLabel lblNode = new JLabel("Cities: ", 2);
		lblNode.setPreferredSize(lblDim);
		lblNode.setFont(myFont);
		lblNode.setForeground(lblColor);
		east.add(lblNode, gbc);
		gbc.gridy += 1;


		JLabel lblSurvival = new JLabel("Elitism: ", 2);
		lblSurvival.setPreferredSize(lblDim);
		lblSurvival.setFont(myFont);
		lblSurvival.setForeground(lblColor);
		east.add(lblSurvival, gbc);
		gbc.gridy += 1;

		JLabel lblCrossover = new JLabel("Crossover rate: ", 2);
		lblCrossover.setPreferredSize(lblDim);
		lblCrossover.setFont(myFont);
		lblCrossover.setForeground(lblColor);
		east.add(lblCrossover, gbc);
		gbc.gridy += 1;

		JLabel lblMutation = new JLabel("Mutation rate: ", 2);
		lblMutation.setPreferredSize(lblDim);
		lblMutation.setFont(myFont);
		lblMutation.setForeground(lblColor);
		east.add(lblMutation, gbc);
		gbc.gridy++;

		JButton btnSubmit = new JButton("Enter");
		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (status == 0) {
					status = 1;
					lblgenerations.setText("");
					bestDistance.setText("");
					generation = 1;
					int populationSize = Integer.parseInt(populationSizeText.getText()) ;
					int numGens = Integer.parseInt(numGensText.getText()) ;
					int numNodes = Integer.parseInt(numNodesText.getText()) ;
					int numSurvival = Integer.parseInt(numSurvivalText.getText());
					float rOfCrossOver = Float.parseFloat(rCrossOverText.getText());
					float rOfMutation = Float.parseFloat(rMutationText.getText());
					Node[] nodes = new Node[numNodes];
					for (int i = 0; i < numNodes; i++) {
						int xPos = (int) (100 * Math.random() + 10);
						int yPos = (int) (100 * Math.random() + 10);
						nodes[i] = new Node(xPos, yPos);
					}

					GA ga = new GA(populationSize, numNodes, rOfMutation, rOfCrossOver, numSurvival);
					population = ga.initPopulation();
					ga.updateFitness(population, nodes);
					sortedPopulation = population.sortByFitness();
					prevRoute = new Route(sortedPopulation.get(0), nodes);

					time = new Timer(20, new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							sortedPopulation = population.sortByFitness();
							Route route = new Route(sortedPopulation.get(0), nodes);
							System.out.println("G"+generation+" Best distance: " + route.totalDistance());
							lblgenerations.setText(String.valueOf(generation));
							bestDistance.setText(String.valueOf((double)Math.round(route.totalDistance()*100)/100));
							population = ga.crossOver(population);
							population = ga.mutation(population);
							ga.updateFitness(population, nodes);
							if (!prevRoute.getRoute().equals(route.getRoute())) {
								draw.setRoute(route);
								draw.paint(getGraphics());
							}
							generation ++;
							prevRoute = route;
							if ((generation == numGens + 1) || (status == 0)){
								time.stop();
								status = 0;
								System.out.println(route.getIndividual());
							}
						}

					});
					time.start();
				}
			}
		});
		btnSubmit.setPreferredSize(btnDim);
		btnSubmit.setForeground(lblColor);
		east.add(btnSubmit, gbc);
		gbc.gridy ++;

		JButton btnHelp = new JButton("Help");
		btnHelp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame f = new JFrame();
//				JDialog d = new JDialog(f, "Help");
				f.setLayout(new BorderLayout());

				JPanel heading = new JPanel();
				JLabel lblHeading = new JLabel("Guidance to run this application");
				lblHeading.setFont(new Font("Arial", Font.BOLD, 30));
				lblHeading.setForeground(new Color(142,50, 10));
				lblHeading.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

				heading.add(lblHeading);
				f.add(heading, BorderLayout.NORTH);

				JPanel center = new JPanel(new FlowLayout(FlowLayout.LEFT));
				center.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
				Instruction instruction = new Instruction();
				JLabel content = new JLabel();
				content.setText(instruction.getContentText());
				content.setForeground(lblColor);
				center.add(content);
				f.add(center, BorderLayout.CENTER);

				JPanel south = new JPanel();
				JButton close = new JButton("Cancel");
				close.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						f.dispose();
					}
				});
				close.setPreferredSize(new Dimension(100, 30));
				south.add(close);
				f.add(south, BorderLayout.SOUTH);

				f.setSize(720, 800);
				f.setLocation(400, 300);
				f.setVisible(true);
			}
		});
		btnHelp.setPreferredSize(btnDim);
		btnHelp.setForeground(Color.gray);
		east.add(btnHelp, gbc);
		gbc.gridy ++;

		JLabel lblGenerations = new JLabel("Generations: ", 2);
		lblGenerations.setPreferredSize(lblDim);
		lblGenerations.setFont(myFont);
		lblGenerations.setForeground(lblColor);
		east.add(lblGenerations, gbc);
		gbc.gridy += 1;

		JLabel lblBestDistance = new JLabel("Best Distance: ", 2);
		lblBestDistance.setPreferredSize(lblDim);
		lblBestDistance.setFont(myFont);
		lblBestDistance.setForeground(lblColor);
		east.add(lblBestDistance, gbc);


		gbc.gridx ++;
		gbc.gridy = 0;
		JLabel nameProgram = new JLabel("TSP-GA", SwingConstants.CENTER);
		nameProgram.setFont(new Font("Arial", Font.BOLD, 25));
		nameProgram.setPreferredSize(new Dimension(100, 50));
		nameProgram.setForeground(new Color(142, 50, 10));
		east.add(nameProgram);
		gbc.gridy+= 1;


		populationSizeText = new JTextField("1000",10);
		populationSizeText.setPreferredSize(tfDim);
		east.add(populationSizeText, gbc);
		gbc.gridy+= 1;

		numGensText = new JTextField("2000", 10);
		numGensText.setPreferredSize(tfDim);
		east.add(numGensText, gbc);
		gbc.gridy+= 1;

		numNodesText = new JTextField("100", 10);
		numNodesText.setPreferredSize(tfDim);
		east.add(numNodesText, gbc);
		gbc.gridy+= 1;

		numSurvivalText = new JTextField("10",10);
		numSurvivalText.setPreferredSize(tfDim);
		east.add(numSurvivalText, gbc);
		gbc.gridy+= 1;

		rCrossOverText = new JTextField("0.9",10);
		rCrossOverText.setPreferredSize(tfDim);
		east.add(rCrossOverText, gbc);
		gbc.gridy+= 1;

		rMutationText = new JTextField("0.05",10);
		rMutationText.setPreferredSize(tfDim);
		east.add(rMutationText, gbc);
		gbc.gridy+= 1;


		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				status = 0;
			}
		});
		btnStop.setPreferredSize(btnDim);
		btnStop.setForeground(new Color(166,75,42));
		east.add(btnStop, gbc);
		gbc.gridy++;


		JButton btnRestart = new JButton("Restart");
		btnRestart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new GUI();
				dispose();
			}
		});
		btnRestart.setPreferredSize(btnDim);
		btnRestart.setForeground(new Color(166,75,42));
		east.add(btnRestart, gbc);
		gbc.gridy++;

		lblgenerations = new JLabel("0", 0);
		lblgenerations.setPreferredSize(new Dimension(100, 50));
		lblgenerations.setForeground(new Color(215,168 ,110));
		lblgenerations.setFont(new Font("Arial", Font.ITALIC, 20));
		east.add(lblgenerations, gbc);
		gbc.gridy++;

		bestDistance = new JLabel("Unknown", 0);
		bestDistance.setPreferredSize(new Dimension(100, 50));
		bestDistance.setForeground(new Color(215,168 ,110));

		bestDistance.setFont(new Font("Arial", Font.BOLD, 18));
		east.add(bestDistance, gbc);

		return east;
	}
}
	

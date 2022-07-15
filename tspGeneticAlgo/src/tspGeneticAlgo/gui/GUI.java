package tspGeneticAlgo.gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.border.LineBorder;

import tspGeneticAlgo.components.Individual;
import tspGeneticAlgo.components.Node;
import tspGeneticAlgo.components.Population;
import tspGeneticAlgo.components.Route;
import tspGeneticAlgo.ga.GA;

public class GUI extends JFrame{
	private Route route;
	private Route prevRoute;
	private JTextField populationSizeText;
	private JTextField numGensText;
	private JTextField numNodesText;
	private JTextField numSurvivalText;
	private JTextField rCrossOverText;
	private JTextField rMutationText;
	private JTextField sTournamentText;
	private JLabel lblgenerations;
	private JLabel bestDistance;
	private int generation = 1;
	private Population population;
	private Timer time;
	private int status = 0;
	private Draw draw = new Draw();
	private List<Individual> sortedPopulation;
	private JComboBox cbSpeed;
	private int speed;
	private JButton btnPrint;

	public GUI() {

		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createEast(), BorderLayout.EAST);
		cp.add(draw, BorderLayout.CENTER);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1080, 720);
		setTitle("Genetic Algorithm for TSP");
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public static void main(String[] args) {
		new GUI();
	}
	JPanel createEast() {
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
		Font myFont = new Font("Arial", Font.PLAIN, 18);
		Dimension lblDim = new Dimension(150, 40);
		Dimension tfDim = new Dimension(120, 30);
		Dimension btnDim = new Dimension(120, 40);
		Color lblColor = new Color(63, 78, 79);

//		=================================================
		ButtonListener btnListener = new ButtonListener();
//		=================================================
		JLabel lblSize = new JLabel("Population size: ", SwingConstants.LEFT);
		lblSize.setPreferredSize(lblDim);
		lblSize.setFont(myFont);
		lblSize.setForeground(lblColor);
		east.add(lblSize, gbc);
		gbc.gridy += 1;

		JLabel lblGen = new JLabel("Total generations: ", SwingConstants.LEFT);
		lblGen.setPreferredSize(lblDim);
		lblGen.setFont(myFont);
		lblGen.setForeground(lblColor);
		east.add(lblGen, gbc);
		gbc.gridy += 1;

		JLabel lblNode = new JLabel("Cities: ", SwingConstants.LEFT);
		lblNode.setPreferredSize(lblDim);
		lblNode.setFont(myFont);
		lblNode.setForeground(lblColor);
		east.add(lblNode, gbc);
		gbc.gridy += 1;


		JLabel lblSurvival = new JLabel("Elitism: ", SwingConstants.LEFT);
		lblSurvival.setPreferredSize(lblDim);
		lblSurvival.setFont(myFont);
		lblSurvival.setForeground(lblColor);
		east.add(lblSurvival, gbc);
		gbc.gridy += 1;

		JLabel lblCrossover = new JLabel("Crossover rate: ", SwingConstants.LEFT);
		lblCrossover.setPreferredSize(lblDim);
		lblCrossover.setFont(myFont);
		lblCrossover.setForeground(lblColor);
		east.add(lblCrossover, gbc);
		gbc.gridy += 1;

		JLabel lblMutation = new JLabel("Mutation rate: ", SwingConstants.LEFT);
		lblMutation.setPreferredSize(lblDim);
		lblMutation.setFont(myFont);
		lblMutation.setForeground(lblColor);
		east.add(lblMutation, gbc);
		gbc.gridy++;

		JLabel lblTournament = new JLabel("Tournament size: ", SwingConstants.LEFT);
		lblTournament.setPreferredSize(lblDim);
		lblTournament.setFont(myFont);
		lblTournament.setForeground(lblColor);
		east.add(lblTournament, gbc);
		gbc.gridy++;

		JLabel lblSpeed = new JLabel("Speed: ", SwingConstants.LEFT);
		lblSpeed.setPreferredSize(lblDim);
		lblSpeed.setFont(myFont);
		lblSpeed.setForeground(lblColor);
		east.add(lblSpeed, gbc);
		gbc.gridy++;

		JButton btnSubmit = new JButton("Enter");
		btnSubmit.addActionListener(btnListener);
		btnSubmit.setPreferredSize(btnDim);
		btnSubmit.setForeground(lblColor);
		east.add(btnSubmit, gbc);
		gbc.gridy ++;

		JButton btnHelp = new JButton("Help");
		btnHelp.addActionListener(btnListener);
		btnHelp.setPreferredSize(btnDim);
		btnHelp.setForeground(Color.gray);
		east.add(btnHelp, gbc);
		gbc.gridy ++;

		JLabel lblGenerations = new JLabel("Generations: ", SwingConstants.LEFT);
		lblGenerations.setPreferredSize(lblDim);
		lblGenerations.setFont(myFont);
		lblGenerations.setForeground(lblColor);
		east.add(lblGenerations, gbc);
		gbc.gridy += 1;

		JLabel lblBestDistance = new JLabel("Best Distance: ", SwingConstants.LEFT);
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
		gbc.gridy++;

		populationSizeText = new RoundJTextField("1000",8);
		populationSizeText.setPreferredSize(tfDim);
		east.add(populationSizeText, gbc);
		gbc.gridy++;

		numGensText = new RoundJTextField("2000", 8);
		numGensText.setPreferredSize(tfDim);
		east.add(numGensText, gbc);
		gbc.gridy++;

		numNodesText = new RoundJTextField("50", 8);
		numNodesText.setPreferredSize(tfDim);
		east.add(numNodesText, gbc);
		gbc.gridy++;

		numSurvivalText = new RoundJTextField("5",8);
		numSurvivalText.setPreferredSize(tfDim);
		east.add(numSurvivalText, gbc);
		gbc.gridy++;

		rCrossOverText = new RoundJTextField("0.9",8);
		rCrossOverText.setPreferredSize(tfDim);
		east.add(rCrossOverText, gbc);
		gbc.gridy++;

		rMutationText = new RoundJTextField("0.05",8);
		rMutationText.setPreferredSize(tfDim);
		east.add(rMutationText, gbc);
		gbc.gridy++;

		sTournamentText = new RoundJTextField("10",8);
		sTournamentText.setPreferredSize(tfDim);
		east.add(sTournamentText, gbc);
		gbc.gridy++;

		String[] speedType = new String[]{"Fast", "Medium", "Slow"};
		cbSpeed = new JComboBox(speedType);
		cbSpeed.addActionListener(btnListener);
		cbSpeed.setPreferredSize(tfDim);

		east.add(cbSpeed, gbc);
		gbc.gridy++;

		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(btnListener);
		btnStop.setPreferredSize(btnDim);
		btnStop.setForeground(new Color(166,75,42));
		east.add(btnStop, gbc);
		gbc.gridy++;

		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(btnListener);
		btnQuit.setPreferredSize(btnDim);
		btnQuit.setForeground(new Color(166,75,42));
		east.add(btnQuit, gbc);
		gbc.gridy++;

		lblgenerations = new JLabel("0", SwingConstants.CENTER);
		lblgenerations.setPreferredSize(new Dimension(100, 50));
		lblgenerations.setForeground(new Color(215,168 ,110));
		lblgenerations.setFont(new Font("Arial", Font.ITALIC, 20));
		east.add(lblgenerations, gbc);
		gbc.gridy++;

		bestDistance = new JLabel("Unknown", SwingConstants.CENTER);
		bestDistance.setPreferredSize(new Dimension(100, 50));
		bestDistance.setForeground(new Color(215,168 ,110));
		bestDistance.setFont(new Font("Arial", Font.BOLD, 18));
		east.add(bestDistance, gbc);
		gbc.gridy++;

		btnPrint = new JButton("Print route");
		btnPrint.addActionListener(btnListener);
		btnPrint.setPreferredSize(btnDim);
		btnPrint.setForeground(new Color(166,75,42));
		east.add(btnPrint, gbc);
		gbc.gridy++;
		btnPrint.setVisible(false);
		return east;
	}


	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt){
			String button =  evt.getActionCommand();
			Color lblColor = new Color(63, 78, 79);
			switch (button){
				case "Enter":
					if (status == 0) {
						btnPrint.setVisible(true);
						status = 1;
						lblgenerations.setText("");
						bestDistance.setText("");
						generation = 1;
						try {
							int populationSize = Integer.parseInt(populationSizeText.getText());
							int numGens = Integer.parseInt(numGensText.getText());
							int numNodes = Integer.parseInt(numNodesText.getText());
							int numSurvival = Integer.parseInt(numSurvivalText.getText());
							float rOfCrossOver = Float.parseFloat(rCrossOverText.getText());
							float rOfMutation = Float.parseFloat(rMutationText.getText());
							int sOfTournament = Integer.parseInt(sTournamentText.getText());
							if (numGens < 0) {
								throw new IllegalArgumentException("Number out of range, must be a positive number");
							}
							if (numNodes <= 0) {
								throw new IllegalArgumentException("Number out of range, must be a positive number");
							}
							if (numSurvival <= 0) {
								throw new IllegalArgumentException("Number out of range, must be a positive number");
							}
							if ((rOfCrossOver < 0) || (rOfCrossOver > 1)) {
								throw new IllegalArgumentException("Number out of range, must be within 0 and 1");
							}
							if ((rOfMutation < 0) || (rOfMutation > 1)) {
								throw new IllegalArgumentException("Number out of range, must be within 0 and 1");
							}
							if (sOfTournament <= 0) {
								throw new IllegalArgumentException("Number out of range, must be a positive number");
							}
							GA ga = new GA(populationSize, numNodes, rOfMutation, rOfCrossOver, numSurvival, sOfTournament);
							Node[] nodes = ga.generateNodes();
							population = ga.initPopulation();
							ga.updateFitness(population, nodes);
							sortedPopulation = population.sortByFitness();
							prevRoute = new Route(sortedPopulation.get(0), nodes);

							time = new Timer(speed, e -> {
								sortedPopulation = population.sortByFitness();
								route = new Route(sortedPopulation.get(0), nodes);
								System.out.println("G" + generation + " Best distance: " + route.totalDistance());
								lblgenerations.setText(String.valueOf(generation));
								bestDistance.setText(String.valueOf((double) Math.round(route.totalDistance() * 100) / 100));
								population = ga.execute(population);
								ga.updateFitness(population, nodes);
								if (!prevRoute.getRoute().equals(route.getRoute())) {
									draw.setRoute(prevRoute, route);
									draw.paint(getGraphics());
								}
								generation++;
								prevRoute = route;
								if ((generation == numGens + 1) || (status == 0)) {
									draw.setRoute(prevRoute, route);
									draw.paint(getGraphics());

									time.stop();
									status = 0;
									System.out.println(route.getIndividual());
								}
							});
							time.start();
						} catch (Exception e){
							new GUI();
							String message = "Invalid input \n" + e.getMessage();
							JOptionPane.showConfirmDialog(new JFrame(), message,"Error",JOptionPane.DEFAULT_OPTION);
							dispose();
						}
				}
					break;
				case "Help":
					JFrame f = new JFrame();
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
					close.addActionListener(e -> f.dispose());
					close.setPreferredSize(new Dimension(100, 30));
					south.add(close);
					f.add(south, BorderLayout.SOUTH);
					f.setTitle("Help");
					f.setSize(800, 800);
					f.setLocationRelativeTo(null);
					f.setVisible(true);
					break;
				case "Stop":
					status = 1 - status;
					break;
				case "Quit":
					int option = JOptionPane.showConfirmDialog(new JFrame(), "Do you want to quit the system?","Quit",JOptionPane.YES_NO_OPTION);
					if (option == JOptionPane.YES_OPTION) {
						System.exit(0);
					}
					break;
				case "comboBoxChanged":
					int index = cbSpeed.getSelectedIndex();
					if (index == 1){
						speed = 100;
					} else if (index == 2) {
						speed = 1000;
					} else {
						speed = 10;
					}
					break;
				case "Print route":
					JFrame routeFrame = new JFrame();
					routeFrame.setLayout(new BorderLayout());
					JLabel lblRoute = new JLabel("Route");
					lblRoute.setFont(new Font("Arial", Font.BOLD, 30));
					lblRoute.setForeground(new Color(142, 50, 10));
					lblRoute.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
					routeFrame.add(lblRoute, BorderLayout.NORTH);

					JTextArea tfRoute = new JTextArea(10,10);
					tfRoute.setLineWrap(true);
					StringBuilder info = new StringBuilder("City location:\n");
					int row = (route.getIndividual().getLength() / 5) + 1;
					for (int i = 0; i < row; i++){
						for (int j = 0; j < 5; j++) {
							info.append("City ").append(i * 5 + j).append(": ").append(route.getRoute().get(i).toString()).append("\t");
						}
						info.append("\n");
					}
					info.append("Best route: \n").append(route.getIndividual().toString());
					tfRoute.setText(info.toString());
					tfRoute.setEditable(false);
					routeFrame.add(tfRoute, BorderLayout.CENTER);
					JPanel closeRoutePanel = new JPanel();
					JButton closeRouteBtn = new JButton("Cancel");
					closeRouteBtn.addActionListener(e -> routeFrame.dispose());
					closeRoutePanel.add(closeRouteBtn);
					routeFrame.add(closeRoutePanel, BorderLayout.SOUTH);
					routeFrame.setSize(new Dimension(1080, 720));
					routeFrame.setLocationRelativeTo(null);
					routeFrame.setVisible(true);
					break;
			}
		}
	}
}
	

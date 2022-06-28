package tspGeneticAlgo.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import tspGeneticAlgo.node.Node;
import tspGeneticAlgo.route.Route;

public class Draw extends JPanel {
	private Route route;
	private int status;
	public void setStatus(int status) {
		this.status = status;
	}

	private ArrayList<Node> routeList;
	public void setRoute(Route route) {
		this.route = route;
		status = 1;
	}
	public Draw() {
		status = 0;
		this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
	}
	public void paint(Graphics g) {
		super.paint(g);
		if (status == 1) {
			routeList = route.getRoute();
			Graphics2D g2 = (Graphics2D)g;
			for (int i = 0; i < routeList.size(); i ++ ) {
				int scale = 3;
				if (i == routeList.size() - 1) {
					g2.setColor(Color.RED);
					g2.drawLine(routeList.get(i).getX() * scale, routeList.get(i).getY() * scale, routeList.get(0).getX() * scale ,routeList.get(0).getY() * scale);
					g2.setColor(Color.BLUE);
					g2.fillOval(routeList.get(i).getX() * scale - 15, routeList.get(i).getY() * scale - 15, 30, 30);
					g2.setColor(Color.WHITE);
//					g2.drawString( route.getIndividual().getChromosome().get(i)+"", routeList.get(i).getX() * scale, routeList.get(i).getY() * scale);
					g2.drawString(i+"", routeList.get(i).getX() * scale, routeList.get(i).getY() * scale);
				}
				else {
					g2.setColor(Color.RED);
					g2.drawLine(routeList.get(i).getX() * scale, routeList.get(i).getY() * scale, routeList.get(i + 1).getX() * scale,routeList.get(i + 1).getY() * scale);
					if (i == 0) {
						g2.setColor(Color.ORANGE);
						g2.fillOval(routeList.get(i).getX() * scale - 15, routeList.get(i).getY() * scale - 15, 35, 35);
						g2.setColor(Color.BLACK);
//						g2.drawString( route.getIndividual().getChromosome().get(i)+"", routeList.get(i).getX() * scale, routeList.get(i).getY() * scale);
						g2.drawString(i+"", routeList.get(i).getX() * scale, routeList.get(i).getY() * scale);
					}
					else {
						g2.setColor(Color.BLUE);
						g2.fillOval(routeList.get(i).getX() * scale - 15, routeList.get(i).getY() * scale - 15, 30, 30);
						g2.setColor(Color.WHITE);
						g2.drawString(i+"", routeList.get(i).getX() * scale, routeList.get(i).getY() * scale);
					}
				}
			}
		}
		
	}

	public void setPrefferredSize(Dimension d){
		super.setPreferredSize(d);
	}

}

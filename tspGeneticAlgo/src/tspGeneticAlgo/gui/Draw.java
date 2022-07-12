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

import tspGeneticAlgo.components.Node;
import tspGeneticAlgo.components.Route;

public class Draw extends JPanel {
	private Route oldRoute;
	private Route newRoute;

	private ArrayList<Node> oldRouteList;
	private ArrayList<Node> newRouteList;
	private int status;
	public void setStatus(int status) {
		this.status = status;
	}
	public void setRoute(Route oldRoute, Route newRoute) {
		this.oldRoute = oldRoute;
		this.newRoute = newRoute;
		status = 1;
	}
	public Draw() {
		status = 0;
//		this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
	}
	public void paint(Graphics g) {
		super.paint(g);
		if (status == 1) {
			oldRouteList = oldRoute.getRoute();
			newRouteList = newRoute.getRoute();

			Color cityColor = new Color(166,75,42);
			Color lineColor = new Color(215, 168, 110);
			Color initColor = new Color(63, 78, 79);
			Color newLineColor = new Color(64, 223, 239);
			Graphics2D g2 = (Graphics2D)g;
			for (int i = 0; i < oldRouteList.size(); i ++ ) {
				int scale = 6;
				if (i == oldRouteList.size() - 1) {
					g2.setColor(lineColor);
					g2.drawLine(oldRouteList.get(i).getX() * scale, oldRouteList.get(i).getY() * scale, oldRouteList.get(0).getX() * scale ,oldRouteList.get(0).getY() * scale);
					g2.setColor(cityColor);
					g2.fillOval(oldRouteList.get(i).getX() * scale - 5 , oldRouteList.get(i).getY() * scale - 5, 10, 10);
				}
				else {
					g2.setColor(newLineColor);
					g2.drawLine(newRouteList.get(i).getX() * scale, newRouteList.get(i).getY() * scale, newRouteList.get(i + 1).getX() * scale,newRouteList.get(i + 1).getY() * scale);
					g2.setColor(lineColor);
					g2.drawLine(oldRouteList.get(i).getX() * scale, oldRouteList.get(i).getY() * scale, oldRouteList.get(i + 1).getX() * scale,oldRouteList.get(i + 1).getY() * scale);

					if (i == 0) {
						g2.setColor(initColor);
						g2.fillOval(oldRouteList.get(i).getX() * scale - 6, oldRouteList.get(i).getY() * scale - 14, 20, 20);
						g2.setColor(Color.WHITE);
						g2.drawString("S", oldRouteList.get(i).getX() * scale , oldRouteList.get(i).getY() * scale);
					}
					else {
						g2.setColor(cityColor);
						g2.fillOval(oldRouteList.get(i).getX() * scale - 5, oldRouteList.get(i).getY() * scale - 5, 10, 10);

					}
				}
			}
		}
		
	}
	public void setPreferredSize(Dimension d){
		super.setPreferredSize(d);
	}

}

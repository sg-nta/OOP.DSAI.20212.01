package tspGeneticAlgo;

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
				int scale = 5;
				if (i == routeList.size() - 1) {
					g2.setColor(Color.RED);
					g2.drawLine(routeList.get(i).getX() * scale + 54, routeList.get(i).getY() * scale + 54, routeList.get(0).getX() * scale + 54,routeList.get(0).getY() * scale + 54);
					g2.setColor(Color.BLUE);
					g2.fillOval(routeList.get(i).getX() * scale + 50, routeList.get(i).getY() * scale + 50, 8, 8);
					
				}
				else {
					g2.setColor(Color.RED);
					g2.drawLine(routeList.get(i).getX() * scale + 54, routeList.get(i).getY() * scale + 54, routeList.get(i + 1).getX() * scale + 54,routeList.get(i + 1).getY() * scale + 54);
					if (i == 0) {
						g2.setColor(Color.ORANGE);
						g2.fillOval(routeList.get(i).getX() * scale + 50 , routeList.get(i).getY() * scale + 50, 8, 8);
					}
					else {
						g2.setColor(Color.BLUE);
						g2.fillOval(routeList.get(i).getX() * scale + 50 , routeList.get(i).getY() * scale + 50, 8, 8);
					}
				}
			}
		}
		
	}

	public void setPrefferredSize(Dimension d){
		super.setPreferredSize(d);
	}

}

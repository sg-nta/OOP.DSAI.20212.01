package tspGeneticAlgo.gui;

import javax.swing.*;
import java.awt.*;

public class RoundJTextField extends JTextField {
    public RoundJTextField(String text, int columns) {
        super(text, columns);
    }
    public void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        super.paintComponent(g);
    }
    public void paintBorder(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
    }
}
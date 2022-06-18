package hust.solict.dsai.swing;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class SwingAccumulator extends JFrame {
	private JTextField tfInput;
	private JTextField tfOutput;
	private int sum = 0;

	public SwingAccumulator() {
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(2, 2));
		
		cp.add(new JLabel("Enter an integer: "));
		
		tfInput = new JTextField(10);
		add(tfInput);
		tfInput.addActionListener(new TFInputListener());
		
		add(new JLabel("The Accumulated Sum is: "));
		
		tfOutput = new JTextField(10);
		tfOutput.setEditable(false);
		add(tfOutput);
		
		setTitle("AWT Accumulator");
		setSize(350,120);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new AWTAccumulator();
	}
	
	private class TFInputListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			int numberInt = Integer.parseInt(tfInput.getText());
			sum += numberInt;
			tfInput.setText("");
			tfOutput.setText(sum + "");
		}
	}
}

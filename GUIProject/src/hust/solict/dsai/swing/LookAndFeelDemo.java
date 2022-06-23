package hust.solict.dsai.swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
public class LookAndFeelDemo extends JFrame{
	final static String LOOKANDFEEL = "Metal";

	public LookAndFeelDemo() {
		addDemoComponents();
		addLookAndFeelComboBox();

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 100);
		setVisible(true);
	}
	
	void addDemoComponents() {
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(new JLabel("Label: "));
		cp.add(new JTextField("Text Field: "));
		cp.add(new JRadioButton("Radio button: "));
		cp.add(new JButton("Button: "));
	}
	
	void addLookAndFeelComboBox() {
		Container cp = getContentPane();
		cp.add(new JLabel("Change look and feel here:"));
		
		LookAndFeelInfo[] lafInfos = UIManager.getInstalledLookAndFeels();
		String[] lafNames = new String[lafInfos.length];
		for (int i=0; i<lafInfos.length; i++) {
			lafNames[i] = lafInfos[i].getName();
		}
		JComboBox cbLookAndFeel = new JComboBox(lafNames);
		cp.add(cbLookAndFeel);
		
		JFrame frame = this;
		cbLookAndFeel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent evt) {
				int index = cbLookAndFeel.getSelectedIndex();
				try {
					UIManager.setLookAndFeel(lafInfos[index].getClassName());
				} catch (Exception e) {
					e.printStackTrace();
				}
				SwingUtilities.updateComponentTreeUI(frame);
				setTitle(lafInfos[index].getName() + "Look and Feel");
			}
		});
		
	}

	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("Cross Platform Look and Feel not set");
		}
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("System Look and Feel not set");
		}
		
		new LookAndFeelDemo();

	}


}

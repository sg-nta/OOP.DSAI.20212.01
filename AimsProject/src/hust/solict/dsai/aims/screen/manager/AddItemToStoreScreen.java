package hust.solict.dsai.aims.screen.manager;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import hust.solict.dsai.aims.media.Media;
import hust.solict.dsai.aims.store.Store.Store;

public class AddItemToStoreScreen extends JFrame {
	private JTextField enterTitle, enterCategory, enterCost;
	private JButton btnAdd;
	private String title;
	private String category;
	private float cost;
	private Media media;

	public AddItemToStoreScreen(Store store) {
		enterTitle = new JTextField(10);
		enterCategory = new JTextField(10);
		enterCost = new JTextField(10);
		
		Container cp = getContentPane();
		cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));

		cp.add(new JLabel("Title: "));
		cp.add(enterTitle);
		cp.add(new JLabel("Category: "));
		cp.add(enterCategory);
		cp.add(new JLabel("Cost: "));
		cp.add(enterCost);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			    @Override
				public void actionPerformed(ActionEvent evt) {
					title = enterTitle.getText();
					title = media.getTitle();
					category = enterCategory.getText();
					category = media.getCategory();
					cost = Float.parseFloat(enterCost.getText());
					cost = media.getCost();
					store.addMedia(media);
				}
			
		});
		
		cp.add(btnAdd);

		
		setTitle("Add Items");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}


package hust.solict.dsai.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.solict.dsai.aims.media.DigitalVideoDisc;
import hust.solict.dsai.aims.media.Media;
import hust.solict.dsai.aims.media.Playable;
import hust.solict.dsai.aims.store.Store.Store;

public class StoreManagerScreen extends JFrame implements Playable {
	private Store store;
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		
		menu.add(new JMenuItem("View store"));
		
		JMenu smUpdateStore = new JMenu("Update store");
		smUpdateStore.add(new JMenuItem("Add book"));
		smUpdateStore.add(new JMenuItem("Add CD"));
		smUpdateStore.add(new JMenuItem("Add DVD"));
		menu.add(smUpdateStore);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("DBMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
	}
	
	JPanel createCenter() {
		
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for (int i=0; i < 9; i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i));
			center.add(cell);
		}
		
		return center;
	}
	
	public StoreManagerScreen(Store store) {
		this.store = store;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setTitle("Store");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
		
	public static void main(String[] args) {
		Store store = new Store();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Once Twice Melody", "Animation", "Roger Allers", 90, 30f);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Once Twice Melody", "Dream pop", "Beach House", 84, 25f);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Out 1", "Drama", "Jacques Rivette", 150, 100f);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Once Twice Melody", "Comedy", "Sion Sono", 75, 30f);
		
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Once Twice Melody", "Animation", "Roger Allers", 90, 30f);

		DigitalVideoDisc dvd6 = new DigitalVideoDisc("Once Twice Melody", "Dream pop", "Beach House", 84, 25f);

		DigitalVideoDisc dvd7 = new DigitalVideoDisc("Out 1", "Drama", "Jacques Rivette", 150, 100f);
		
		DigitalVideoDisc dvd8 = new DigitalVideoDisc("Once Twice Melody", "Comedy", "Sion Sono", 75, 30f);
		
		DigitalVideoDisc dvd9 = new DigitalVideoDisc("Fetch the bold cutters", "Art Pop", "Fiona Apple", 51, 10f);

		

		
		store.addMedia(dvd1, dvd2, dvd3, dvd4, dvd5, dvd6, dvd7, dvd8, dvd9);
		new AddItemToStoreScreen(store);
		new StoreManagerScreen(store);
		
	}
	
}


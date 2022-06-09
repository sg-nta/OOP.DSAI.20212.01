package hust.solict.dsai.aims.Aims;
import hust.solict.dsai.aims.cart.Cart.Cart;
import hust.solict.dsai.aims.media.DigitalVideoDisc;
import hust.solict.dsai.aims.store.Store.*;
import hust.solict.dsai.aims.utils.DVDUtils.DVDUtils;

import java.util.*;


public class Aims {
	public static void main(String[] args) {
		Cart cart = new Cart();
		Store store = new Store();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Once Twice Melody", "Animation", "Roger Allers", 90, 30f);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Once Twice Melody", "Dream pop", "Beach House", 84, 25f);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Out 1", "Drama", "Jacques Rivette", 150, 100f);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Once Twice Melody", "Comedy", "Sion Sono", 75, 30f);
		
		store.addMedia(dvd1, dvd2, dvd3, dvd4);
		
		Scanner sc = new Scanner(System.in);
		
		public static void showMenu() {
			System.out.println("AIMS: ");
			System.out.println("--------------------------------");
			System.out.println("1. View store");
			System.out.println("2. Update store");
			System.out.println("3. See current cart");
			System.out.println("0. Exit");
		}

	}
}


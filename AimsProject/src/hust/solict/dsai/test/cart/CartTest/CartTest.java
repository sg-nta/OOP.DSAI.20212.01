package hust.solict.dsai.test.cart.CartTest;
import hust.solict.dsai.aims.Disc.DigitalVideoDisc.DigitalVideoDisc;
import hust.solict.dsai.aims.cart.Cart.Cart;

public class CartTest {
	public static void main(String[] args) {
		
		Cart cart = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Once Twice Melody", "Animation", "Roger Allers", 90, 30f);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Once Twice Melody", "Dream pop", "Beach House", 84, 25f);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Out 1", "Drama", "Jacques Rivette", 150, 100f);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Once Twice Melody", "Comedy", "Sion Sono", 75, 30f);
		
		cart.addDigitalVideoDisc(dvd1, dvd2, dvd3, dvd4);
		
		
		System.out.println("Total cost:");
		System.out.println(cart.totalCost());
		
		cart.print();

	}
}

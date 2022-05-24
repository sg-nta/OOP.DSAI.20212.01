package hust.solict.dsai.test.store.StoreTest;



import hust.solict.dsai.aims.Disc.DigitalVideoDisc.DigitalVideoDisc;
import hust.solict.dsai.aims.store.Store.Store;

public class StoreTest {
	public static void main(String[] args) {
		
		Store store = new Store();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Once Twice Melody", "Animation", "Roger Allers", 90, 30f);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Once Twice Melody", "Dream pop", "Beach House", 84, 25f);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Out 1", "Drama", "Jacques Rivette", 150, 100f);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Once Twice Melody", "Comedy", "Sion Sono", 75, 30f);
		
		store.addDVD(dvd1, dvd2, dvd3, dvd4);
		
		
				
    }
	
}
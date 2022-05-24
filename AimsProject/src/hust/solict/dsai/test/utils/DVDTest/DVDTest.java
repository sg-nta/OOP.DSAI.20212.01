package hust.solict.dsai.test.utils.DVDTest;
import hust.solict.dsai.aims.Disc.DigitalVideoDisc.DigitalVideoDisc;
import hust.solict.dsai.aims.utils.DVDUtils.DVDUtils;

public class DVDTest {
    public static void main(String[] args) {
    	DigitalVideoDisc dvd1 = new DigitalVideoDisc("A", "a", "a", 1, 5.6f);
    	DigitalVideoDisc dvd2 = new DigitalVideoDisc("C", "b", "b", 2, 5.9f);
    	DigitalVideoDisc dvd3 = new DigitalVideoDisc("B", "c", "c", 3, 4.8f);
    	DigitalVideoDisc dvd4 = new DigitalVideoDisc("D", "d", 8.9f);
    	
    	System.out.println(DVDUtils.comparebyCost(dvd1, dvd2));
    	System.out.println(DVDUtils.comparebyTitle(dvd1, dvd2));
    	
    	DigitalVideoDisc[] sorted = DVDUtils.sortbyCost(new DigitalVideoDisc[] {dvd1, dvd2, dvd3, dvd4});
    	System.out.println("sort by cost: ");
    	for (int i=0; i<sorted.length; i++) {
        	System.out.println(sorted[i].toString());
    	}
    	
        sorted = DVDUtils.sortbyTitle(new DigitalVideoDisc[] {dvd1, dvd2, dvd3, dvd4});
    	System.out.println("sort by title: ");
        for (int i=0; i<sorted.length; i++) {
        	System.out.println(sorted[i].toString());
        }
    }
}

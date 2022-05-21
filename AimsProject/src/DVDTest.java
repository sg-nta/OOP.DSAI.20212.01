
public class DVDTest {
    public static void main(String[] args) {
    	DigitalVideoDisc dvd1 = new DigitalVideoDisc("A", "a", "a", 1, 5.6f);
    	DigitalVideoDisc dvd2 = new DigitalVideoDisc("B", "b", "b", 2, 5.6f);
    	
    	System.out.println(DVDUtils.comparebyCost(dvd1, dvd2));
    	System.out.println(DVDUtils.comparebyTitle(dvd1, dvd2));
    }
}

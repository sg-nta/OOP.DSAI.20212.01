package hust.solict.dsai.aims.cart.Cart;
import java.util.ArrayList;

import hust.solict.dsai.aims.media.DigitalVideoDisc;
import hust.solict.dsai.aims.media.Media;

import java.util.*;


public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	private static int numberCart = 0;
	private int rand = (int)(Math.random() * Media.numberMedia);
    private Media luckyitem = itemsOrdered.get(rand);
	
	public float totalCost() {
    	float sum = 0;
    	for (int i=0; i<numberCart; i++) {
    		sum += itemsOrdered.get(i).getCost();
    	}
    	sum -= luckyitem.getCost();
    	return sum;
    }
    
	public void addMedia(Media disc) {
		if (numberCart + 1 <= MAX_NUMBERS_ORDERED) {
			itemsOrdered.add(disc);
			numberCart++;
			System.out.println("The item has been added");
		}
		else
			System.out.println("The cart is almost full");
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
    	if (numberCart > 0) {
    		for (int i=0; i < numberCart; i++) {
    			if (disc.equals(itemsOrdered.get(i))) {
    				itemsOrdered.remove(i);
    				numberCart--;
    				System.out.println("The item has been removed from your cart");
    				break;
    			}
    		}
    	}
   
    	else
    		System.out.println("The item was not in the cart");
    	}
    	
		
    public void print() {
    	itemsOrdered.sort(Comparator.comparing(Media::getTitle));
    	System.out.println("***********************CART***********************");
    	System.out.println("Ordered Items:");
    	for (int i=0; i<numberCart; i++) {
    		System.out.println(i+1 + ". " + itemsOrdered.get(i).toString());
    	}
    }
    
    public void searchbytitle() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Search for titles: ");
    	String a = sc.nextLine();
        int found = 0;
    	for (int i=0; i<numberCart; i++) {
    		if (itemsOrdered.get(i).isMatch(a)) {
    			System.out.println(itemsOrdered.get(i).toString());
    			found++;
    		}
    	}
    	if (found == 0) {
    		System.out.println("Title not found, please try again");
    	}
    	if (sc != null) {
    		sc.close();
    	}
    }
    
    
    
    
}
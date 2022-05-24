package hust.solict.dsai.aims.cart.Cart;
import java.util.*;

import hust.solict.dsai.aims.Disc.DigitalVideoDisc.DigitalVideoDisc;


public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	public DigitalVideoDisc[] itemsOrdered = 
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	public int qtyOrdered = 0;
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered + 1 <= MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered += 1;
			System.out.println("The disc has been added");
		}
		else
			System.out.println("The cart is almost full");
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		if (qtyOrdered + dvdList.length <= MAX_NUMBERS_ORDERED) {
			for (int i=0; i<dvdList.length; i++) {
				itemsOrdered[qtyOrdered + i] = dvdList[i];
			}
			qtyOrdered += dvdList.length;
			System.out.println("The list of DVDs have been added");
		}
		else
			System.out.println("The cart is almost full");	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc1, DigitalVideoDisc...discs) {
		if (qtyOrdered + discs.length <= MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = disc1;
			qtyOrdered++;
			for (int i=0; i<discs.length; i++) {
				itemsOrdered[qtyOrdered + i] = discs[i];
			}
			qtyOrdered += discs.length;
			System.out.println("The list of DVDs have been added");
		}
		else
			System.out.println("The cart is almost full");
    }
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
		if (qtyOrdered + 2 <= MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = disc1;
			itemsOrdered[qtyOrdered + 1] = disc2;
			System.out.println("The list of DVDs have been added");
			qtyOrdered += 2;
		}
		else
			System.out.println("The cart is almost full");
	}
// I prefer the arbitrary number version because i believe it could deal with more types of input.

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
    	if (qtyOrdered > 0) {
    		for (int i=0; i < qtyOrdered; i++) {
    			if (disc.equals(itemsOrdered[i])) {
    				itemsOrdered[i] = null;
    				qtyOrdered -= 1;
    				System.out.println("The disc has been removed from your cart");
    				break;
    			}
    		}
    	}
   
    	else
    		System.out.println("The disc was not in the cart");
    	}
    	
    public float totalCost() {
    	float sum = 0;
    	for (int i=0; i<qtyOrdered; i++) {
    		sum += itemsOrdered[i].getCost();
    	}
    	return sum;
    }
    
    public void print() {
    	Comparator<DigitalVideoDisc> byTitle = 
    			Comparator.nullsLast(
    					Comparator.comparing(DigitalVideoDisc::getTitle));
    	Comparator<DigitalVideoDisc> byCost = 
    			Comparator.nullsLast(
    					Comparator.comparing(DigitalVideoDisc::getCost).reversed());
    	Comparator<DigitalVideoDisc> byLength = 
    			Comparator.nullsLast(
    					Comparator.comparing(DigitalVideoDisc::getLength).reversed());
    	
    	Arrays.sort(itemsOrdered, byTitle.thenComparing(byCost).thenComparing(byLength));
        DigitalVideoDisc[] newOrder = Arrays.stream(itemsOrdered).filter(object -> object != null).toArray(size -> new DigitalVideoDisc[size]);
    	System.out.println("***********************CART***********************");
    	System.out.println("Ordered Items:");
    	for (int i=0; i<newOrder.length; i++) {
    		System.out.println(i+1 + ". " + newOrder[i].toString());
    	}
    }
    
    public void searchbytitle() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Search for titles: ");
    	String a = sc.nextLine();
        DigitalVideoDisc[] newOrder = Arrays.stream(itemsOrdered).filter(object -> object != null).toArray(size -> new DigitalVideoDisc[size]);
        int found = 0;
    	for (int i=0; i<newOrder.length; i++) {
    		if (newOrder[i].isMatch(a)) {
    			System.out.println(newOrder[i].toString());
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
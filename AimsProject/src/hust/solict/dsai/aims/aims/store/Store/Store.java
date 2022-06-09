package hust.solict.dsai.aims.store.Store;
import java.util.*;

import java.util.Scanner;

import hust.solict.dsai.aims.media.DigitalVideoDisc;
import hust.solict.dsai.aims.media.Media;


public class Store {
    public static ArrayList<Media> itemsinStore = new ArrayList<Media>();
    public static int numofDVDs = 0;
    
    public void addMedia(Media...discs) {
			for (int i=0; i<discs.length; i++) {
			itemsinStore.add(discs[i]);
			numofDVDs++;
			System.out.println("The list of DVDs have been added");
			}
	}
		
    
    public void removeMedia(Media disc) {
    	if (Media.numberMedia > 0) {
    		for (int i=0; i < Media.numberMedia; i++) {
    			if (disc.equals(itemsinStore.get(i))) {
    				itemsinStore.remove(i);
    				Media.numberMedia--;
    				System.out.println("The item has been removed from your cart");
    				break;
    			}
    		}
    	}
   
    	else
    		System.out.println("The item was not in the cart");
    	}
    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
}

    public static void storeMenu() {
	    System.out.println("Options: ");
	    System.out.println("--------------------------------");
	    System.out.println("1. See a DVD’s details");
	    System.out.println("2. Add a DVD to cart");
	    System.out.println("3. See current cart");
	    System.out.println("0. Back");
	    System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
}

    public static void cartMenu() {
	    System.out.println("Options: ");
	    System.out.println("--------------------------------");
	    System.out.println("1. Filter DVDs in cart");
	    System.out.println("2. Sort DVDs in cart");
	    System.out.println("3. Remove DVD from cart");
	    System.out.println("4. Place order");
	    System.out.println("0. Back");
	    System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
}
    public static void viewstore() {
	    for (int i=0; i<numofDVDs; i++) {
		    System.out.println(i+1 + ". " + itemsinStore.get(i).toString());
	    }
    }
	 public static void searchbytitle() {
	    	Scanner sc = new Scanner(System.in);
	    	System.out.println("Search for titles: ");
	    	String a = sc.nextLine();
	        int found = 0;
	    	for (int i=0; i<numofDVDs; i++) {
	    		if (itemsinStore.get(i).getTitle().contains(a)) {
	    			System.out.println(itemsinStore.get(i).toString());
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
	    public static void main(String[] args) {
	    		
	    		Store store = new Store();
	    		
	    		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Once Twice Melody", "Animation", "Roger Allers", 90, 30f);

	    		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Once Twice Melody", "Dream pop", "Beach House", 84, 25f);

	    		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Out 1", "Drama", "Jacques Rivette", 150, 100f);
	    		
	    		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Once Twice Melody", "Comedy", "Sion Sono", 75, 30f);
	    		
	    		store.addMedia(dvd1, dvd2, dvd3, dvd4);
	    		
	    		
	  
}
}


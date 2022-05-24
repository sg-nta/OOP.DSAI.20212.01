package hust.solict.dsai.aims.Aims;
import hust.solict.dsai.aims.Disc.DigitalVideoDisc.DigitalVideoDisc;
import hust.solict.dsai.aims.cart.Cart.Cart;
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
		
		store.addDVD(dvd1, dvd2, dvd3, dvd4);
		
		Scanner sc = new Scanner(System.in);
		
		int a = 0;
		while (a < 4) {
		Store.showMenu();
		a = sc.nextInt();
		switch (a) {
		case 1:
			int b = 0;
			while (b < 4) {
			Store.viewstore();
			Store.storeMenu();
			b = sc.nextInt();
		    switch (b) {
		    case 1:
				Store.searchbytitle();
				break;
	
		    case 2:
				System.out.println("enter the disc to add:");
				int c = sc.nextInt();
				cart.addDigitalVideoDisc(Store.itemsinStore[c]);
				break;
		    case 3:
				cart.print();
				break;
		    case 0:
				Store.viewstore();
				Store.storeMenu();
				break;
			default:
				System.exit(0);
		    }
			}
			
		case 3:	
			cart.print();
			Store.cartMenu();
			int d = sc.nextInt();
			if (d == 1) {
				System.out.println("Enter 0 to sort by title. Enter 1 to sort by cost.");
				int e = sc.nextInt();
				if (e==0) {
					DigitalVideoDisc[] sortbytitle = DVDUtils.sortbyTitle(cart.itemsOrdered);
					for (int i=0; i<sortbytitle.length; i++) {
			        	System.out.println(sortbytitle[i].toString());
			    	}
				}
				if (e==1) {
					DigitalVideoDisc[] sortbycost = DVDUtils.sortbyTitle(cart.itemsOrdered);
					for (int i=0; i<sortbycost.length; i++) {
			        	System.out.println(sortbycost[i].toString());
			    	}
				}
			}
			if (d==2) {
				System.out.println("Enter 0 to sort by title. Enter 1 to sort by cost.");
				int e = sc.nextInt();
				if (e==0) {
					DigitalVideoDisc[] sortbytitle = DVDUtils.sortbyTitle(cart.itemsOrdered);
					for (int i=0; i<sortbytitle.length; i++) {
			        	System.out.println(sortbytitle[i].toString());
			    	}
				}
				if (e==1) {
					DigitalVideoDisc[] sortbycost = DVDUtils.sortbyTitle(cart.itemsOrdered);
					for (int i=0; i<sortbycost.length; i++) {
			        	System.out.println(sortbycost[i].toString());
	                }
		          }
			}
			if (d==3) {
				System.out.println("Enter id:");
				int f = sc.nextInt();
				cart.removeDigitalVideoDisc(Store.itemsinStore[f]);
			}
			
			if (d==4) {
				for (int i=0; i<cart.itemsOrdered.length; i++) {
					cart.itemsOrdered[i] = null;
					cart.qtyOrdered = 0;
				}
			}
			sc.close();
        }
	}
	}
}


package hust.solict.dsai.aims.Aims;
import hust.solict.dsai.aims.cart.Cart.Cart;
import hust.solict.dsai.aims.media.DigitalVideoDisc;
import hust.solict.dsai.aims.store.Store.*;
import hust.solict.dsai.aims.utils.DVDUtils.DVDUtils;

import java.util.*;
import hust.solict.dsai.aims.media.Media;
import hust.solict.dsai.aims.screen.manager.StoreManagerScreen;

public class Aims {
	public static void main(String[] args) {
		Cart cart = new Cart();
		Store store = new Store();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Once Twice Melody", "Animation", "Roger Allers", 90, 30f);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Once Twice Melody", "Dream pop", "Beach House", 84, 25f);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Out 1", "Drama", "Jacques Rivette", 150, 100f);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Once Twice Melody", "Comedy", "Sion Sono", 75, 30f);
		
		store.addMedia(dvd1, dvd2, dvd3, dvd4);
		
		LinkedList<APP> route = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		boolean running = true;
		route.add(APP.SHOW_MENU);
		while (!route.isEmpty() && running) {
			APP mode = route.getLast();
			if (mode == APP.SHOW_MENU) {
				Store.showMenu();
				int ent = sc.nextInt();
				
				if (ent == 0) {
					running = false;
					System.out.println("App closed");
				}
				else if (ent == 1) {
					route.add(APP.VIEW_STORE);
				}	
				else if (ent == 2)
					route.add(APP.UPDATE_STORE);
				else if (ent == 3)
					route.add(APP.CART_MENU);
				else
					System.out.println("Please choose a number: 0-1-2-3");
			}
			
			else if (mode == APP.VIEW_STORE) {
				Store.storeMenu();
				store.viewstore();
				int ent = sc.nextInt();
				if (ent == 0)
					route.removeLast();
				else if (ent == 1)
					route.add(APP.SEE_A_DVDS_DETAILS);
				else if (ent == 2)
					route.add(APP.ADD_DVD_TO_CART);
				else if (ent == 3)
					route.add(APP.CART_MENU);
				else
					System.out.println("Please choose a number: 0-1-2-3");
			}
			
			else if (mode == APP.UPDATE_STORE) {
				showUpdateCart();
				int ent = sc.nextInt();
				
				if (ent == 0) {
					route.removeLast();
				}
				else if (ent == 1) {
					DigitalVideoDisc disc = enterDVD(sc);
					store.addMedia(disc);
				}
				else if (ent == 2) {
					for (int i=0; i<Store.numofDVDs; i++) {
						String a = sc.nextLine();
			    		if (store.itemsinStore.get(i).isMatch(a)) {
			    			System.out.println(store.itemsinStore.get(i).toString());
			    			store.removeMedia(store.itemsinStore.get(i));
			    		}
					}
				}
				else 
					System.out.println("Please choose a number: 0-1-2");
			}
			
			else if (mode == APP.CART_MENU) {
				cart.print();
				Store.cartMenu();
				int ent = sc.nextInt();
				if (ent == 0) {
					route.removeLast();
				}
				else if (ent == 1) {
					filterOption();
					route.add(APP.FILTER_DVDS);
				}
				else if (ent == 2) {
					sortOption();
					route.add(APP.SORT_DVDS);
				}
				else if (ent == 3) {
					System.out.println("Enter the title: ");
				}
				else if (ent == 4) {
					cart.removeall();
				}
			}
			
			else if (mode == APP.FILTER_DVDS) {
				int ent = sc.nextInt(); 
				if (ent == 0) {
					route.removeLast();
				}
				if (ent == 1) {
					
				}
				if (ent == 2) {
					
				}
				else
					System.out.println("Please choose a number: 0-1-2");

			}
			
			else if (mode == APP.SORT_DVDS) {
				int ent = sc.nextInt();
				if (ent == 0) {
					route.removeLast();
				}
				if (ent == 1) {
					ArrayList<Media> sorted = DVDUtils.sortbyCost(cart.itemsOrdered);
					System.out.println(sorted.toString());
				}
				if (ent == 2) {
					ArrayList<Media> sorted = DVDUtils.sortbyTitle(cart.itemsOrdered);
					System.out.println(sorted.toString());
				}
				else
					System.out.println("Please choose a number: 0-1-2");

			}
			
			else if (mode == APP.SEE_A_DVDS_DETAILS) {
		    	System.out.println("Search for titles: ");
				for (int i=0; i<Store.numofDVDs; i++) {
					String a = sc.nextLine();
		    		if (store.itemsinStore.get(i).isMatch(a)) {
		    			System.out.println(store.itemsinStore.get(i).toString());
			        }
				}
			}
			
			else if (mode == APP.UPDATE_STORE) {
				DigitalVideoDisc newdvd = enterDVD(sc);
				store.addMedia(newdvd);
			}
		}
	        System.out.println("Close program");
	        sc.close();
	}
			
	public enum APP {
		SHOW_MENU,
		VIEW_STORE,
		UPDATE_STORE,
		CART_MENU,
		SEE_A_DVDS_DETAILS,
		ADD_DVD_TO_CART,
		FILTER_DVDS,
		SORT_DVDS,
		REMOVE_FROM_CART;
	}
	

	
    public static void showUpdateCart() {
        System.out.println("Options: ");
        System.out.println("--------------------------------------------------");
        System.out.println("1. Add a DVD");
        System.out.println("2. Remove a DVD");
        System.out.println("0. Back");
        System.out.println("--------------------------------------------------");
		System.out.println("Please choose a number: 0-1-2");
    }
    
    public static DigitalVideoDisc enterDVD(Scanner sc) {
        System.out.println("Enter DVD");

        System.out.print("Enter title: ");
        String title = sc.nextLine();

        System.out.print("Enter category: ");
        String category = sc.nextLine();

        System.out.print("Enter director: ");
        String director = sc.nextLine();

        System.out.print("Enter length: ");
        int length = sc.nextInt();

        System.out.print("Enter cost: ");
        float cost = sc.nextFloat();

        DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);

        System.out.println();
        return dvd;
    }
    
    public static void filterOption() {
        System.out.println("Options: ");
        System.out.println("--------------------------------------------------");
        System.out.println("1. Filter by ID");
        System.out.println("2. Filter by Title");
        System.out.println("0. Back");
        System.out.println("--------------------------------------------------");
		System.out.println("Please choose a number: 0-1-2");

    }
    public static void sortOption() {
        System.out.println("Options: ");
        System.out.println("--------------------------------------------------");
        System.out.println("1. Sort by Title");
        System.out.println("2. Sort by Cost");
        System.out.println("0. Back");
        System.out.println("--------------------------------------------------");
		System.out.println("Please choose a number: 0-1-2");
    
    }

}


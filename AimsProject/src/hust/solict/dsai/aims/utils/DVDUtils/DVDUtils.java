package hust.solict.dsai.aims.utils.DVDUtils;
import java.util.*;

import hust.solict.dsai.aims.media.DigitalVideoDisc;
import hust.solict.dsai.aims.media.Media;
public class DVDUtils {	  
	
    public static String comparebyCost(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
    	if (dvd1.getCost() > dvd2.getCost()) {
    	    return ("compare by cost: " + dvd1.getTitle() + " > " + dvd2.getTitle());
    	}
    	if (dvd2.getCost() > dvd1.getCost()) {
    	    return ("compare by cost: " + dvd2.getTitle() + " > " + dvd1.getTitle());
    	}
    	else
    		return ("compare by cost: " + dvd1.getTitle() + " = " + dvd2.getTitle());
    }  
    
    public static String comparebyTitle(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
    	int cprs = dvd1.getTitle().compareTo(dvd2.getTitle());
    	if (cprs == 1) {
    		return ("compare by title (ascending order): " + dvd2.getTitle() + "; " + dvd1.getTitle());
    	}
    	else
    		return ("compare by title (ascending order): " + dvd1.getTitle() + "; " + dvd2.getTitle());
    }
    
    public static ArrayList<Media> sortbyCost(ArrayList<Media> dvdList) {
        Collections.sort(dvdList, new Comparator<Media>() {
        	@Override
        	public int compare(Media o1, Media o2) {
        		return -Float.compare(o1.getCost(), o2.getCost());
        	}
        }
        		);
        return dvdList;
    }
    
    public static ArrayList<Media> sortbyTitle(ArrayList<Media> dvdList) {
    	Collections.sort(dvdList, new Comparator<Media>() {
    		public int compare(Media disc1, Media disc2) {
    			return disc1.getTitle().compareTo(disc2.getTitle());
    		}
    	});
    	return dvdList;
       }
}
    
    


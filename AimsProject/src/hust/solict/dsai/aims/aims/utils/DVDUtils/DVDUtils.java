package hust.solict.dsai.aims.utils.DVDUtils;
import java.util.*;

import hust.solict.dsai.aims.media.DigitalVideoDisc;
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
    
    public static DigitalVideoDisc[] sortbyCost(DigitalVideoDisc[] dvdList) {
    	DigitalVideoDisc[] discs = dvdList;
        Arrays.sort(discs, new Comparator<DigitalVideoDisc>() {
            public int compare(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
                return -Float.compare(disc1.getCost(), disc2.getCost());
            }
        });
        return discs;
    }
    
    public static DigitalVideoDisc[] sortbyTitle(DigitalVideoDisc[] dvdList) {
    	DigitalVideoDisc[] discs = dvdList;
    	Arrays.sort(discs, new Comparator<DigitalVideoDisc>() {
    		public int compare(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
    			return disc1.getTitle().compareTo(disc2.getTitle());
    		}
    	});
    	return discs;
       }
}
    
    



public class DVDUtils {	  
	
    public static String comparebyCost(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
    	if (dvd1.getCost() > dvd2.getCost()) {
    	    return ("compare by cost: " + dvd1.getTitle() + ">" + dvd2.getTitle());
    	}
    	if (dvd2.getCost() > dvd1.getCost()) {
    	    return ("compare by cost: " + dvd2.getTitle() + ">" + dvd1.getTitle());
    	}
    	else
    		return ("compare by cost: " + dvd1.getTitle() + "=" + dvd2.getTitle());
    }  
    
    public static String comparebyTitle(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
    	int cprs = dvd1.getTitle().compareTo(dvd2.getTitle());
    	if (cprs == 1) {
    		return ("compare by title (ascending order): " + dvd2.getTitle() + "; " + dvd1.getTitle());
    	}
    	else
    		return ("compare by title (ascending order): " + dvd1.getTitle() + "; " + dvd2.getTitle());
    }
}

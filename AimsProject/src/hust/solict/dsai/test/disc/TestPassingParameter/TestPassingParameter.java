package hust.solict.dsai.test.disc.TestPassingParameter;
import hust.solict.dsai.aims.Disc.DigitalVideoDisc.DigitalVideoDisc;

public class TestPassingParameter {
	public static void main(String[] args) {
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		newkindaObject jungledvd = new newkindaObject(jungleDVD);
		newkindaObject cinderelladvd = new newkindaObject(cinderellaDVD);
		
		swap(jungledvd, cinderelladvd);
		System.out.println("jungle title: " + jungledvd.diffObject.getTitle());
		System.out.println("cinderella title: " + cinderelladvd.diffObject.getTitle());
		
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle title: " + jungleDVD.getTitle());
		
				
	}
	
    public static void swap(newkindaObject o1, newkindaObject o2) {
    	DigitalVideoDisc tmp;
    	tmp = o1.diffObject;
    	o1.diffObject = o2.diffObject;
    	o2.diffObject = tmp;
    }
    
    static class newkindaObject {
    	DigitalVideoDisc diffObject;
    	public newkindaObject(DigitalVideoDisc newobj) {
    		this.diffObject = newobj;
    	}
    }
    
    public static void changeTitle(DigitalVideoDisc dvd, String title) {
    	String oldTitle = dvd.getTitle();
    	dvd.setTitle(title);
    	dvd = new DigitalVideoDisc(oldTitle);
    	
    }
}



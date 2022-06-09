package hust.solict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Comparable<DigitalVideoDisc>, Playable {

	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		numberMedia++;
		this.id = numberMedia;
		
	}
	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD Length: " + this.getLength());
	}
	
	public String toString() {
    	return "DVD - " + getTitle() + " - " + getCategory() + " - " + director + " - " + length + ": " + getCost() + " $";
	}
	@Override
	public int compareTo(DigitalVideoDisc o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}


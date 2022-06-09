package hust.solict.dsai.aims.media;

public class Disc extends Media {
	int length;
	String director;

	public int getLength() {
		return length;
	}


	public String getDirector() {
		return director;
	}
	
	public Disc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		numberMedia++;
		this.id = numberMedia;
	}


	

}

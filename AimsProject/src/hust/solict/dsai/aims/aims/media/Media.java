package hust.solict.dsai.aims.media;

import java.util.Date;

public class Media {
	int id;
	String title;
	String category;
	float cost;
	public static int numberMedia = 0;
	private Date dateadded;

	public Media() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}


	public Media(int id, String title, String category, float cost) {
		super();
		numberMedia++;
		dateadded = new Date();
		this.id = numberMedia;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}

	public Date getDateadded() {
		return dateadded;
	}
	
	public boolean isMatch(String Title) {
		final String casedisctitle = title.toLowerCase();
		return casedisctitle.contains(Title.toLowerCase());
	}
	

}


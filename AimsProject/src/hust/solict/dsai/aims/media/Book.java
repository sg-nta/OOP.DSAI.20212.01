package hust.solict.dsai.aims.media;

import java.util.*;
public class Book extends Media {
	private List<String> authors = new ArrayList<String>();
	public Book() {
		// TODO Auto-generated constructor stub
	}
	public static String content = new String();	
	Map<String, Integer> wordFrequency = new HashMap<>();
	List<String> contentTokens = new ArrayList<String>();
	
	public void processContent() {
		String[] tokens = content.split(" ");
		for (String token : tokens) {
			wordFrequency.compute(token,  (k, v) -> v == null ? 1 : v + 1);
		}
		contentTokens = Arrays.asList(tokens);
		Collections.sort(contentTokens);
		
	}
	
	public void addAuthor(String authorName) {
		if (!authors.contains(authorName)) {
			authors.add(authorName);
		}
	}
	
	public void removeAuthor(String authorName) {
		if (authors.contains(authorName)) {
			authors.remove(authorName);
		}
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	public String toString() {
    	return "DVD - " + id + " - " + title + " - " + category + " - " + contentTokens.toString() + "-" + wordFrequency.toString() + ": " + cost + " $";
	}
	
	
}


	


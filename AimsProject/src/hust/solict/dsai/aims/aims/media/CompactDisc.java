package hust.solict.dsai.aims.media;

import java.util.*;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();

	public String getArtist() {
		return artist;
	}

	public CompactDisc(String title, String category, String director, int length, float cost, String artist,
			ArrayList<Track> tracks) {
		super(title, category, director, length, cost);
		this.artist = artist;
		this.tracks = tracks;
	}
	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD Length: " + this.getLength());
	}

	
	public void addTrack(Track thetrack) {
		if (tracks.contains(thetrack)) {
			System.out.println("The track is already in the list.");
		}
		else
			tracks.add(thetrack);
		    System.out.println("The track added successfully.");
	}
	
	public void removeTrack(Track thetrack) {
		if (!tracks.contains(thetrack)) {
			System.out.println("The track is not in the list.");
		}
		else
			tracks.remove(thetrack);
		    System.out.println("The track removed.");
	}
	
	public int getLength() {
		int len = 0;
		for (int i=0; i < tracks.size(); i++) {
			len += tracks.get(i).getLength();
		}
		return len;
	}
	
	


}

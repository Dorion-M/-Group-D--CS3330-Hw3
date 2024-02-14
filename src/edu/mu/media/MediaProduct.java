package edu.mu.media;

public class MediaProduct {
	
	protected String title;
	protected Double price;
	protected int year;
	protected Genre genre;
	
	

	public MediaProduct(String title, Double price, int year, Genre genre) {
		super();
		this.title = title;
		this.price = price;
		this.year = year;
		this.genre = genre;
	}
	
	public MediaProduct(MediaProduct copy) {
	    this.title = copy.title;
	    this.price = copy.price;
	    this.year = copy.year;
	    this.genre = copy.genre;
	}

	
	

}

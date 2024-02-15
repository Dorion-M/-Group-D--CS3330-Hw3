package edu.mu.media;

public class MediaProduct {
	
	protected String type;
	protected String title;
	protected Double price;
	protected int year;
	protected Genre genre;
	
	

	public MediaProduct(String type, String title, Double price, int year, Genre genre) {
		super();
		this.type = type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Type: " + type + "Title: " + title + ", Price: " + price + ", Year: " + year + ", Genre: " + genre;
	}
	
	
	

	
	

}

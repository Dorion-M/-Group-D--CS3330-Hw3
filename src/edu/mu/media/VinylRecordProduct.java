package edu.mu.media;

public class VinylRecordProduct extends MediaProduct {

	public VinylRecordProduct(String type, String title, Double price, int year, Genre genre) {
		super(type, title, price, year, genre);
	}
	
	public VinylRecordProduct(VinylRecordProduct copy) {
		super(copy);
	}

}

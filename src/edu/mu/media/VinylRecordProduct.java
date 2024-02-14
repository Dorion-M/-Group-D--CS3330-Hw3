package edu.mu.media;

public class VinylRecordProduct extends MediaProduct {

	public VinylRecordProduct(String title, Double price, int year, Genre genre) {
		super(title, price, year, genre);
	}
	
	public VinylRecordProduct(VinylRecordProduct copy) {
		super(copy);
	}

}

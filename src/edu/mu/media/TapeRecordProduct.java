package edu.mu.media;

public class TapeRecordProduct extends MediaProduct {

	public TapeRecordProduct(String title, Double price, int year, Genre genre) {
		super(title, price, year, genre);
	}
	
	public TapeRecordProduct(TapeRecordProduct copy) {
		super(copy);
	}

}

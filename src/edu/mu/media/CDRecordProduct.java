package edu.mu.media;

public class CDRecordProduct extends MediaProduct {

	public CDRecordProduct(String title, Double price, int year, Genre genre) {
		super(title, price, year, genre);
	}
	
	public CDRecordProduct(CDRecordProduct copy) {
		super(copy);
	}

}

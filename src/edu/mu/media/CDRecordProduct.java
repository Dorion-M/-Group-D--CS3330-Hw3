package edu.mu.media;

public class CDRecordProduct extends MediaProduct {

	public CDRecordProduct(String type, String title, Double price, int year, Genre genre) {
		super(type, title, price, year, genre);
	}
	
	public CDRecordProduct(CDRecordProduct copy) {
		super(copy);
	}

}

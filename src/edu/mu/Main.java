package edu.mu;

import java.util.ArrayList;

import edu.mu.manager.*;
import edu.mu.media.*;

public class Main {

	public static void main(String[] args) {
		
		StockManagerSingleton stockManager = StockManagerSingleton.getInstance();
		
        boolean wasInitiated = stockManager.initializeStock();
        System.out.println("Stock was initiated: " + wasInitiated + "\n");
       
        
        // Tests the addItem function and prints result to the user
        VinylRecordProduct testVinyl = new VinylRecordProduct("Vinyl","Group D", 25.99, 2024, Genre.POP);
        if (stockManager.addItem(testVinyl)) {
            System.out.println("Vinyl record added successfully.\n");
        } else {
            System.out.println("Failed to add vinyl record.\n");
        }
        
        
        VinylRecordProduct testVinyl2 = new VinylRecordProduct("Vinyl","Group D", 25.99, 2024, Genre.POP);
        if (stockManager.addItem(testVinyl2)) {
            System.out.println("Vinyl record added successfully.\n");
        } else {
            System.out.println("Failed to add vinyl record.\n");
        }
        
        
     // Tests the updateItemPrice function and prints result to the user
        if (stockManager.updateItemPrice(testVinyl, 17.99)) {
            System.out.println("Price updated successfully.\n");
        } else {
            System.out.println("Failed to update price.\n");
        }
        
       
        // Tests the removeItem function and prints the result to the user
        if (stockManager.removeItem(testVinyl)) {
            System.out.println("Item removed successfully.\n");
        } else {
            System.out.println("Failed to remove item.\n");
        }
        
        
       // Tests the saveStock function and prints the result to the user.
        if (stockManager.saveStock()) {
            System.out.println("Stock saved successfully.\n");
        } else {
            System.out.println("Failed to save stock.\n");
        }
        
        
        ArrayList<MediaProduct> inventory = (ArrayList<MediaProduct>) StockManagerSingleton.inventory;

        // Display vinyl records
        ArrayList<MediaProduct> vinylRecords = stockManager.getVinylRecordList(inventory);
        System.out.println("\nVinyl Records: \n");
        stockManager.printListOfMediaProduct(vinylRecords);

        // Display CD records
        ArrayList<MediaProduct> cdRecords = stockManager.getCDRecordList(inventory);
        System.out.println("\nCD Records: \n");
        stockManager.printListOfMediaProduct(cdRecords);

        // Display tape records
        ArrayList<MediaProduct> tapeRecords = stockManager.getTapeRecordList(inventory);
        System.out.println("\nTape Records: \n");
        stockManager.printListOfMediaProduct(tapeRecords);
        
        // Tests the getMediaProductBelowPrice and printListofMediaProduct functions. The media
        //products that are under the given price will be retrieved and printed to the user.
        int theMaxPrice = 24;
        System.out.println("\nMedia products below price " + theMaxPrice + ":\n");
        stockManager.printListOfMediaProduct(stockManager.getMediaProductBelowPrice(theMaxPrice));       
        
        
     
        
        
        
        
		
	}

}

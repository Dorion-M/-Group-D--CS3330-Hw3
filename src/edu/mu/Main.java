package edu.mu;

import java.util.ArrayList;

import edu.mu.manager.*;
import edu.mu.media.*;

public class Main {

	public static void main(String[] args) {
		
		StockManagerSingleton stockManager = StockManagerSingleton.getInstance();
        boolean wasInitiated = stockManager.initializeStock();
        System.out.println("Stock was initiated: " + wasInitiated);
        

		
      
        System.out.println("CD's");
        for (MediaProduct product : StockManagerSingleton.inventory) {
            if (product instanceof CDRecordProduct) {
                System.out.println(product.toString());
            }
        }
        
        System.out.println("Vinyl's");
        for (MediaProduct product : StockManagerSingleton.inventory) {
            if (product instanceof VinylRecordProduct) {
                System.out.println(product.toString());
            }
        }
        
        System.out.println("Tapes's");
        for (MediaProduct product : StockManagerSingleton.inventory) {
            if (product instanceof TapeRecordProduct) {
                System.out.println(product.toString());
            }
        }
        
        // Tests the addItem function and prints result to the user
        VinylRecordProduct testVinyl = new VinylRecordProduct("Vinyl","Group D", 25.99, 2024, Genre.POP);
        if (stockManager.addItem(testVinyl)) {
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
        
        // Tests the getMediaProductBelowPrice and printListofMediaProduct functions. The media
        //products that are under the given price will be retrieved and printed to the user.
        int theMaxPrice = 24;
        System.out.println("Media products below price " + theMaxPrice + ":\n");
        stockManager.printListOfMediaProduct(stockManager.getMediaProductBelowPrice(theMaxPrice));
        
		
	}

}

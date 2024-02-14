package edu.mu;
import edu.mu.manager.*;
import edu.mu.media.*;

public class Main {

	public static void main(String[] args) {
		
		StockManagerSingleton stockManager = StockManagerSingleton.getInstance();
        stockManager.initializeStock();

		
      
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
		
		
	}

}

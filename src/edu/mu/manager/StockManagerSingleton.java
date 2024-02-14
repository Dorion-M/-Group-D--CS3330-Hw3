package edu.mu.manager;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import edu.mu.media.*;

public class StockManagerSingleton {
    private static StockManagerSingleton instance;
    private String inventoryFilePath;
    public static List<MediaProduct> inventory;

    
    private StockManagerSingleton() {
        inventoryFilePath = "src/datafile/inventory.csv"; 
        inventory = new ArrayList<>();
    }

    public static StockManagerSingleton getInstance() {
        if (instance == null) {
            instance = new StockManagerSingleton();
        }
        return instance;
    }
    

// Reads CSV 
    public boolean initializeStock() {
        try (BufferedReader reader = new BufferedReader(new FileReader(inventoryFilePath))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(","); 
                String type = tokens[0];
                String title = tokens[1];
                double price = Double.parseDouble(tokens[2]);
                int year = Integer.parseInt(tokens[3]);
                Genre genre = Genre.valueOf(tokens[4].toUpperCase()); 
                
// Creates MediaProduct object based on the type
                MediaProduct product;
                switch (type) {
                    case "Vinyl":
                        product = new VinylRecordProduct(title, price, year, genre);
                        break;
                    case "CD":
                        product = new CDRecordProduct(title, price, year, genre);
                        break;
                    case "Tape":
                        product = new TapeRecordProduct(title, price, year, genre);
                        break;
                    default:
                        continue;
                }
                
                inventory.add(product);
            }
            return !inventory.isEmpty();
        } catch (IOException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("An error occurred while reading the inventory file.");
            return false;
        }
    }



}

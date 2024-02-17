package edu.mu.manager;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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
                        product = new VinylRecordProduct(type, title, price, year, genre);
                        break;
                    case "CD":
                        product = new CDRecordProduct(type, title, price, year, genre);
                        break;
                    case "Tape":
                        product = new TapeRecordProduct(type, title, price, year, genre);
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
    
    public boolean updateItemPrice(MediaProduct product, double newPrice)
    {
		for(MediaProduct item : inventory)
		{
			if(item.equals(product))
			{
				item.setPrice(newPrice);
				return true;
			}
		}
		return false;
    }
    
    public boolean addItem(MediaProduct product)
    {
		if(inventory.add(product)) 
		{
			return true;
		}
    	
    	return false;
    	
    }
    
    public boolean removeItem(MediaProduct product)
    {
    	
    	for(MediaProduct item : inventory) 
		{
    		if(item.equals(product)) 
    		{
    			inventory.remove(item);
    			return true;
    		}
		}
    	
    	return false;
    	
    }
    
    public boolean saveStock() {
    	
    	try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(inventoryFilePath));
			
			writer.write("Type,Title,Price,Year,Genre\n");
			
			for(MediaProduct item : inventory) 
			{
				String line = String.format("%s,%s,%.2f,%d,%s\n", item.getType(), item.getTitle(), item.getPrice(), item.getYear(), item.getGenre().toString().toUpperCase());
				
				writer.write(line);
			}
		
			writer.close();
			return true;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
    	
    }
    
    public ArrayList<MediaProduct> getMediaProductBelowPrice(int maxprice)
    {
    	ArrayList<MediaProduct> listBelowPrice = new ArrayList<>();
    	
    	for(MediaProduct item: inventory) 
    	{
    		if(item.getPrice() < maxprice) 
    		{
    			listBelowPrice.add(item);
    		}
    	}
    	    	
    	return listBelowPrice;
    	
	}
    
    public void printListOfMediaProduct(ArrayList<MediaProduct> productList) 
    {
    	for(MediaProduct item: productList) 
    	{
    		System.out.println(item.toString());
    	}
    }

    public ArrayList<MediaProduct> getVinylRecordList(ArrayList<MediaProduct> productList) {
        ArrayList<MediaProduct> vinylList = new ArrayList<>();
        for (MediaProduct item : productList) {
            if ("Vinyl".equalsIgnoreCase(item.getType())) {
                vinylList.add(item);
            }
        }
        return vinylList;
    }
    
    
    
    
    public ArrayList<MediaProduct> getTapeRecordList(ArrayList<MediaProduct> productList) {
        ArrayList<MediaProduct> tapeList = new ArrayList<>();
        for (MediaProduct item : productList) {
            if ("Tape".equalsIgnoreCase(item.getType())) {
                tapeList.add(item);
            }
        }
        return tapeList;
    }
    
    public ArrayList<MediaProduct> getCDRecordList(ArrayList<MediaProduct> productList) {
        ArrayList<MediaProduct> cdList = new ArrayList<>();
        for (MediaProduct item : productList) {
            if ("CD".equalsIgnoreCase(item.getType())) {
                cdList.add(item);
            }
        }
        return cdList;
    }
    
}

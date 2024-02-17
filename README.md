# [Group-D]-CS3330-Hw3

# Inventory Management System

## Project Overview
This Java project aims to create an inventory management system for media products. The system allows users to perform various operations such as adding, updating, and removing products, as well as displaying the inventory and filtering products based on criteria such as price and type.

## Project Structure
The project consists of several Java files:

1. `Main.java`: This is the main file used to execute the program. It interacts with the `StockManagerSingleton` class to manage the inventory.
2. `StockManagerSingleton.java`: This file contains the `StockManagerSingleton` class, which is responsible for managing the inventory of media products. It includes methods for initializing the stock from a CSV file, adding, updating, and removing items, saving the stock to a file, and filtering products.
3. `MediaProduct.java`: This file defines the `MediaProduct` class, which represents a generic media product. It serves as a superclass for specific types of media products such as vinyl records, CD records, and tape records.
4. Specific media product classes (e.g., `VinylRecordProduct.java`, `CDRecordProduct.java`, `TapeRecordProduct.java`): These classes extend the `MediaProduct` class and provide specific implementations for different types of media products.

## Methods of the Project
The inventory management system allows users to perform the following operations:

- Initialize the stock from a CSV file.
- Add a new media product to the inventory.
- Update the price of an existing product.
- Remove a product from the inventory.
- Save the current state of the inventory to a file.
- Display all products in the inventory.
- Filter products based on criteria such as price and type.

## Dependencies
The project requires the following dependencies:

- Java Development Kit (JDK) to compile and run the program.
- An Integrated Development Environment (IDE) such as Eclipse to work with the Java project.

## How to Run the Project
To run the project:

1. Clone the GitHub repository containing the project files.
2. Open the project in your preferred IDE.
3. Make sure you have JDK installed on your machine.
4. Compile and run the `Main.java` file.

## Contributors
- Seth keenan
- Paul Maschhoff
- Dorion Massengill

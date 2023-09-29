/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinecoffeeordersystem;

/**
 *
 * @author caide
 */
// Order class containing multiple coffee items
public class Order {
    private Coffee[] coffeeItems;  // Using array to store coffee items
    private int itemCount;

    // Constructor
    public Order(int maxItems) {
        coffeeItems = new Coffee[maxItems];
        itemCount = 0;
    }

    // Method to add coffee to the order
    public void addCoffee(Coffee coffee) {
        if(itemCount < coffeeItems.length) {
            coffeeItems[itemCount++] = coffee;
        }
        else {
            System.out.println("Order is full! Can't add more items.");
        }
    }

    // Method to calculate total order price
    public double calculateTotal() {
        double total = 0;
        for(int i = 0; i < itemCount; i++) {
            total += coffeeItems[i].getPrice();
        }
        return total;
    }

    // Method to print order details
    public void printOrder() {
        System.out.println("Order Details:");
        for(int i = 0; i < itemCount; i++) {
            System.out.println(coffeeItems[i].getType() + " - " + coffeeItems[i].getSize() + " - $" + coffeeItems[i].getPrice());
        }
        System.out.println("Total: R" + calculateTotal());
    }
    
    public int getItemCount() {
    return itemCount;
}
    
}

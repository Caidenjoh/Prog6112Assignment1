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
// Coffee class inheriting from Product
public class Coffee extends Product {
    private String type;  // e.g. Latte, Espresso, Cappuccino
    private String size;  // e.g. Small, Medium, Large

    // Constructor
    public Coffee(String type, String size, double price) {
        super(price);
        this.type = type;
        this.size = size;
    }

    // Getters
    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }
}

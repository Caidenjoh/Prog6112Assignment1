


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import onlinecoffeeordersystem.Order;
import onlinecoffeeordersystem.Coffee;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author caide
 */
public class testOrder {
    
 @Test
    public void testAddCoffee() {
        Order testOrder = new Order(2);
        Coffee c1 = new Coffee("Latte", "Medium", 5.0);
        
        testOrder.addCoffee(c1);
        
        assertEquals(1, testOrder.getItemCount());
    }
    
    @Test
    public void testCalculateTotal() {
        Order testOrder = new Order(2);
        Coffee c1 = new Coffee("Latte", "Medium", 5.0);
        Coffee c2 = new Coffee("Espresso", "Small", 3.5);
        
        testOrder.addCoffee(c1);
        testOrder.addCoffee(c2);

        double expectedTotal = 8.5; // 5.0 + 3.5
        assertEquals(expectedTotal, testOrder.calculateTotal(), 0.0);
    }

    @Test
    public void testOrderFull() {
        Order testOrder = new Order(2);
        Coffee c1 = new Coffee("Latte", "Medium", 5.0);
        Coffee c2 = new Coffee("Espresso", "Small", 3.5);
        Coffee c3 = new Coffee("Mocha", "Large", 6.0);

        testOrder.addCoffee(c1);
        testOrder.addCoffee(c2);
        testOrder.addCoffee(c3);  // This should print "Order is full! Can't add more items."

        // Check if only the first two coffees were added
        assertEquals(2, testOrder.getItemCount());
    }
}

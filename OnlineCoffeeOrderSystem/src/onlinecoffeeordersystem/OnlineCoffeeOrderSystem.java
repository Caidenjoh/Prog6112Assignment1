/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinecoffeeordersystem;

import java.util.Scanner;

/**
 *
 * @author caide
 */
public class OnlineCoffeeOrderSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Create an order with a maximum of 5 items
        Order myOrder = new Order(5);

        while(true) {
            System.out.println("\nOnline Coffee Order System");
            System.out.println("1. Add a coffee to your order");
            System.out.println("2. View your order");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();  // Consume the newline

            switch(choice) {
                case 1:
                    // Take user input for coffee details
                    System.out.print("Enter coffee type (e.g. Latte, Espresso, Cappuccino): ");
                    String type = sc.nextLine();

                    System.out.print("Enter coffee size (e.g. Small, Medium, Large): ");
                    String size = sc.nextLine();

                    // For simplicity, setting a default price based on size. This can be enhanced.
                    double price;
                    switch(size.toLowerCase()) {
                        case "small":
                            price = 3.0;
                            break;
                        case "medium":
                            price = 4.5;
                            break;
                        case "large":
                            price = 6.0;
                            break;
                        default:
                            System.out.println("Invalid size! Using default price.");
                            price = 4.0; // Default price
                    }
                    
                    Coffee coffee = new Coffee(type, size, price);
                    myOrder.addCoffee(coffee);
                    System.out.println(type + " - " + size + " added to your order!");
                    break;

                case 2:
                    myOrder.printOrder();
                    break;

                case 3:
                    System.out.println("Thank you for using the Online Coffee Order System. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

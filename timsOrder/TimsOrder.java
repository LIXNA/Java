/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment7;

import java.util.Scanner;

/**
 * This has some TimsProduct
 * Contains TimsProducts in array
 * Declare TimsProducts based on user's choice
 * 
 * @author Sungwoong Pyeon, 000734962
 */
public class TimsOrder {
    
    /**
     * the number of products
     */
    private int size;
    
    /**
     * user name
     */
    private String name;
    /**
     * array to contain TimsProduct
     */
    private static TimsProduct[] product;
    
    /**
     * Constructor
     * @param name
     * @param size 
     */
    private TimsOrder(String name, int size) {
        this.name = name;
        this.size = size;
    }
    
    /**
     * This is to make an instance of TimsOrder because constructor is private
     * Other Class cannot make an instance of TimsOrder without using create method
     * ask user name and the number of products
     * create TimsProducts based on user's choice
     * 
     * @return order TimsOrder
     */
    public static TimsOrder create() {
        
        // asking user name and the number of products
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your name? ");
        String orderName = sc.nextLine();
        System.out.println("How many products do you want? ");
        int orderSize = sc.nextInt();
        
        TimsOrder order = new TimsOrder(orderName, orderSize);
        //make some instance based on orderSize
        //declare TimsProducts and store in array
        product = new TimsProduct[orderSize];
        
        for (int i = 0; i < orderSize; i++) {
            System.out.println("What would you like to order\n"
                    + "1. Donut\n2. Mug\n3. Tumbler\n4. Bagel");
            int option = sc.nextInt();
            switch (option) {
                case (1):
                    product[i] = Donut.create();
                    break;
                case (2):
                    product[i] = Mug.create();
                    break;
                case (3):
                    product[i] = Tumbler.create();
                    break;
                case (4):
                    product[i] = Bagel.create();
                    break;
                default:
                    System.out.println("Check your order number");
            }
        }
        return order;
    }
    
    /*
        The getAmountDue() method adds up all the retail prices of the products in the order and returns
    the sum
    */
    public double getAmountDue() {
        double sum = 0;
        for( TimsProduct t : product ){
            sum += t.getRetailPrice();
        }
        return sum;
    }

    @Override
    public String toString() {
        int productN = 1;
        String message = "Order for : " + name + "\n";
        for( TimsProduct t : product ){
            message += "\nProduct" + productN + "\n" + t + "\n";
            productN ++;
        }
        return message;
    }
}

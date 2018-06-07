/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment7;

/**
 * This assignment 7 is to understand the relationship of association,
 * inheritance and interface
 * This assignment is about polymorphism, abstract classes, and interfaces
 * 
 * @author Sungwoong Pyeon, 000734962
 */
public class TestClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //make an instance of TimsOrder
        //Once make an instace, user will type the name and the number of products
        TimsOrder timsOrder = TimsOrder.create();
        System.out.println(timsOrder.toString());
        System.out.printf("Total Price: $%.2f\n", timsOrder.getAmountDue());
        
    }
    
}

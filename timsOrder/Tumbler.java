/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment7;

import java.util.Scanner;
import javafx.scene.paint.Color;

/**
 * This is TimsProduct
 * 
 * @author Sungwoong Pyeon
 */
public class Tumbler extends TimsProduct{
    
    /**
     * color and size of tumbler
     */
    private Color color;
    private String size;
    
    /**
     * Constructor
     * @param name
     * @param color
     * @param size
     * @param cost
     * @param price 
     */
    private Tumbler(String name, Color color, String size, double cost, double price) {
        super(name, cost, price);
        this.color = color;
        this.size = size;
    }
    
    /**
     * This is to make an instance of Tumbler because constructor is private
     * Other Class cannot make an instance of Tumbler without using create method
     * @return tumbler
     */
    public static Tumbler create(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("What color do you want? ");
        Color newColor = Color.valueOf(sc.nextLine());
        
        System.out.println("What size? [ small, midium, large] ");
        String newSize = sc.nextLine();
        
        Tumbler tumbler = new Tumbler( "Special Tim's Tumbler", newColor, newSize, 2.5, 25.5 ); 
        return tumbler;
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }
    
    @Override
    public String toString(){
        return super.toString() + "\n" + "Type... Tumbler{ color = " 
                + color + " Size = " + size + " }";
    }
}

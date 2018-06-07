/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment7;

import java.util.Scanner;
import javafx.scene.paint.Color;

/**
 * This is a TimsProduct
 * @author Sungwoong Pyeon
 */
public class Mug extends TimsProduct{
    
    /**
     * Color of Mug
     */
    private Color color;
    
    /**
     * Constructor
     * 
     * @param name
     * @param color
     * @param cost
     * @param price 
     */
    private Mug(String name, Color color, double cost, double price) {
        super(name, cost, price);
        this.color = color;
    }
    
    /**
     * This is to make an instance of Mug because constructor is private
     * Other Class cannot make an instance of Mug without using create method
     * @return mug
     */
    public static Mug create(){
        
        //Asking user to get color value 
        Scanner sc = new Scanner(System.in);
        System.out.println("What color do you want? ");
        Color newColor = Color.valueOf(sc.nextLine());
        
        Mug mug = new Mug( "Official Tim's Mug", newColor, 1.99, 19.99 ); 
        return mug;
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }
    
    @Override
    public String toString(){
        return super.toString() + "\n" + "Type... Mug{ color = " 
                + color + " }";
    }
}

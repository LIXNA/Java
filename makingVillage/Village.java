/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 * This class has up to three House associated with it.
 * Draw a house and two random size of houses.
 * Make house2 and house3 located in random place. 
 * 
 *
 * @author Sungwoong Pyeon, 000734962
 */
public class Village {

    /**
     * X and Y location of top left of canvas
     */
    private double x, y;
    /**
     * Size of house
     */
    private double size;
    /**
     * Color of house
     */
    private Color color;
    /**
     * Name of village
     */
    private String name;
    /**
     * Variables to call house class
     */
    private House house1, house2, house3;

    /**
     * Constructor 
     *
     * Make three instances house1, house2 and house3 to draw three
     * houses and to set occupants of houses 
     * Get random houseSize and distance based on house's occupants 
     * The number of occupants set in the instance house 1
     * is used to obtain the random size and distance of the house 2.
     * The number of occupants set in the instance house2
     * is used to obtain the random size and distance of the house 3.
     * But they should be located in the same bottom line 
     * Print some village's information(village name, size, population).
     *
     * @param name village name
     * @param x house's location X
     * @param y house's location Y 
     * @param size house's size
     * @param color house's color
     */
    public Village(String name, double x, double y, double size, Color color) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
        
        //Make an instance of house1
        //Set house1's occupants
        house1 = new House(x, y, size, color);
        house1.setOccupants();

        //Make an instance of house2
        //house2's location and size are based on house1's the number of occupants
        //Set house2's occupants
        house2 = new House(x + size + (house1.getOccupants()*10),y + (size - size / house1.getOccupants() ), size / house1.getOccupants(), color);
        house2.setOccupants();
        
        //Make an instance of house3
        //house3's location and size are based on house2's the number of occupants
        //Set house3's occupants
        house3 = new House(x + size + (size / house1.getOccupants()) + (house1.getOccupants()*10) + (house2.getOccupants()*10), y + (size - size / house2.getOccupants() ), size / house2.getOccupants(), color);
        house3.setOccupants();
        
        //houses' random occupants
        System.out.println("\nhouse1's occupants: " + house1.getOccupants());
        System.out.println("house2's occupants: " + house2.getOccupants());
        System.out.println("house3's occupants: " + house3.getOccupants());
        
        //houses' random distance
        //between house1 and house2
        System.out.println("\ndistance1: " + house1.getOccupants()*10);
        
        //between house2 and house3
        System.out.println("distance2: " + house2.getOccupants()*10);
        
        //houses's random size
        System.out.println("\nhouse2's size: " + size/house1.getOccupants());
        System.out.println("house3's size: " + size/house2.getOccupants());
       
    }
    
    /**
     * In other to draw three houses and some text of village's information
     * @param gc 
     */
    public void draw(GraphicsContext gc) {
        
        gc.setFill(Color.BLACK);
        gc.setFont(Font.font("System", FontWeight.BOLD, FontPosture.ITALIC, 20));
        
        //draw the village name, size, population                                            
        gc.fillText(name + "( size: " + Math.round(( size + size / house1.getOccupants()//house2's random size 
                + size / house2.getOccupants()//house3's random size
                + house1.getOccupants()*10// house2's random distance 
                + house2.getOccupants()*10 ) * 20 ) / 100.0 // house3's random distance 
                + "m, " + "population: " 
                //the sum of population of house1,2,3
                + (house1.getOccupants() + house2.getOccupants() + house3.getOccupants()) + " )", x, ( y + size ) + 30 );    
        //draw house1,2,3
        house1.draw(gc);
        house2.draw(gc);
        house3.draw(gc);

    }
}

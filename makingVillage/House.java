/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * This class has Window, Door, Chimney, Smog1 and Smog2 associated with it.
 * Draw window, door, chimney and two smog.
 * Get and Set occupants of house 1,2,3.
 * 
 * @author Sungwoong Pyeon, 000734962
 */
public class House {

    /**
     * X and Y location of top left of house
     */
    private double x, y;
    /**
     * Size of house 
     * Set the size to 250 because the size of king is 250 by default
     */
    private double size = 250;
    /**
     * Occupants in a house
     * Set the occupants to 1 because the occupant of king house is 1 by default
     */
    private int occupants = 1;
    /**
     * Color of house
     */
    private Color color;

    /**
     *
     * Variables of window, door, chimney and two smog
     * 
     *
     */
    private final Window window;
    private final Door door;
    private final Chimney chimney;
    private final Smog1 smog1;
    private final Smog2 smog2;

    /**
     * Constructor.
     * Make some instances to draw a window, door,......
     * 
     * @param x Left of square
     * @param y Top of square
     * @param size Size of square
     * @param color Color of square
     */
    public House(double x, double y, double size, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
        
        //make some instances 
        window = new Window((x + size / 6), (y + size / 6), size / 5);
        door = new Door((x + size / 2), (y + size / 2), size / 2);
        chimney = new Chimney(x + size / 2, y - (size / 4), size / 4);
        smog1 = new Smog1(x + size / 1.5, y - (size / 2.8), size / 8);
        smog2 = new Smog2(x + size / 1.2, y - (size / 2.5), size / 10);
    }

    /**
     * Overloading for king house
     *
     * @param x Left of square
     * @param y Top of square
     * @param color Color of king house
     */
    public House(double x, double y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
        
        //make some instances 
        window = new Window((x + size / 6), (y + size / 6), size / 5);
        door = new Door((x + size / 2), (y + size / 2), size / 2);
        chimney = new Chimney(x + size / 2, y - (size / 4), size / 4);
        smog1 = new Smog1(x + size / 1.5, y - (size / 2.8), size / 8);
        smog2 = new Smog2(x + size / 1.2, y - (size / 2.5), size / 10);
    }

    /**
     * Draw a window, door,.....
     *
     * @param gc The GraphicsContext to draw on.
     */
    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillRect(x, y, size, size);

        //draw a window and a door
        window.draw(gc);
        door.draw(gc);
        chimney.draw(gc);
        smog1.draw(gc);
        smog2.draw(gc);
    }

    /**
     * Get the number of occupants randomly
     * This is used to set the random distance and size of houses
     * @return occupants
     */
    public int getOccupants() {
        return occupants;
    }

    /**
     * Set occupants randomly
     *
     */
    public void setOccupants() {
        occupants = (int) (Math.random() * 10) + 1;
    }
    
    /**
     * Get size
     *
     * @return size
     */
    public double getSize() {
        
        return size; 
    }

}

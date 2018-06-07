/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * This class is associated with House class
 * 
 * @author Sungwoong Pyeon, 000734962
 */
public class Door {
    
    /**
     * X and Y location of top left of door
     */
    private double x, y;
    /**
     * height of door
     */
    private double height;

    /**
     * Constructor.
     *
     * @param x Left of square
     * @param y Top of square
     * @param size Size of square
     * @param color Color of square
     */
    public Door(double x, double y,double height ) {
        this.x = x;
        this.y = y;
        this.height = height;
    }

    /**
     * Draw the square.
     *
     * @param gc The GraphicsContext to draw on.
     */
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.WHITE);
        gc.fillRect(x, y, height/2, height);
    }
}

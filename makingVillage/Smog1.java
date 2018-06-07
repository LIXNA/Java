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
public class Smog1 {
    /**
     * X and Y location of top left of smog1
     */
    private double x, y;
    /**
     * diameter of smog1
     */
    private double diameter;
    
    /**
     * Constructor
     * 
     * @param x
     * @param y
     * @param diameter 
     */
    public Smog1( double x, double y, double diameter ){
        this.x = x;
        this.y = y;
        this.diameter = diameter;
    }
    
    /**
     * Draw a smog
     * @param gc 
     */
    public void draw( GraphicsContext gc ){
        gc.setFill(Color.GREY);
        gc.fillOval(x, y, diameter, diameter);
    }
}

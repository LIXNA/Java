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
public class Window {
    /**
     * X and Y location of top left of window
     */
    private double x, y;
    /**
     * diameter of window
     */
    private double diameter;
    
    /**
     * Constructor
     * 
     * @param x Left of window
     * @param y Right of window 
     * @param diameter 
     */
    public Window( double x, double y, double diameter ){
        this.x = x;
        this.y = y;
        this.diameter = diameter;
    }
    
    /**
     * To draw window
     * @param gc 
     */
    public void draw( GraphicsContext gc ){
        gc.setFill(Color.WHITE);
        gc.fillOval(x, y, diameter, diameter);
    }
}

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
 * @author sungwoong pyeon, 000734962
 */
public class Chimney {
    /**
     * X and Y location of top left of chimney
     */
    private double x, y;
    /**
     * height of chimney
     */
    private double height;
    
    /**
     * Constructor
     * 
     * @param x
     * @param y
     * @param height 
     */
    public Chimney( double x, double y, double height){
        this.x = x;
        this.y = y;
        this.height = height;
    }
    
    /**
     * Draw a chimney
     * @param gc 
     */
    public void draw( GraphicsContext gc){
        gc.setFill(Color.CHOCOLATE);
        gc.fillRect(x, y, height/3, height);
    }
}

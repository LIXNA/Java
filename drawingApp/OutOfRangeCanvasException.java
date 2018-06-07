/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawingapp;

/**
 * get exception from CheckingException class
 * customize exception class
 * @author Sungwoong Pyeon, 000734962
 */
public class OutOfRangeCanvasException extends RuntimeException {
    
    /**
     * location values
     */
    private int x, y;
    
    /**
     * Constructor
     * @param x
     * @param y 
     */
    public OutOfRangeCanvasException( int x, int y ){
        //customize message
        super( "Width " + x + " or height " + y + " is out of range [Canvas size is 900 X 800 ]");
        this.x = x;
        this.y = y;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }
    
    
}

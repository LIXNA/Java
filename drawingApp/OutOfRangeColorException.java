/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawingapp;

/**
 *get exception from CheckingException class
 * customize exception class
 * @author Sungwoong Pyeon, 000734962
 */
public class OutOfRangeColorException extends RuntimeException {
    
    /**
     * rgb values
     */
    private int red, green, blue;
    
    /**
     * Constructor
     * @param red
     * @param green
     * @param blue 
     */
    public OutOfRangeColorException( int red, int green, int blue ){
        //customize message
        super( "Color variables are out of range [Color range is from 0 and 255]" );
    }

    /**
     * @return the colorT1
     */
    public int getColorT1() {
        return red;
    }

    /**
     * @return the colorT2
     */
    public int getColorT2() {
        return green;
    }

    /**
     * @return the colorT3
     */
    public int getColorT3() {
        return blue;
    }
    
    
}

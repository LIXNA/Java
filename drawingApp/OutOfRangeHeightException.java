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
public class OutOfRangeHeightException extends RuntimeException {
    
    /**
     * height value
     */
    private int heightT;
    
    public OutOfRangeHeightException( int heightT ){
        //customize message
        super( "Height must be greater than 0" );
        this.heightT = heightT;
    }

    /**
     * @return the heightT
     */
    public int getHeightT() {
        return heightT;
    }

    
}

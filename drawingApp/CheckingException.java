/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawingapp;

/**
 * checking exception 
 * when input is invalid then throw that exception class( OutOfRangeCanvasException, OutOfRangeHeightException, OutOfRangeColorException )
 * @author Sungwoong Pyeon, 000734962
 */
public class CheckingException {
    
    /**
     * variable from the setting bar location, height, format of RGB values
     */
    int x, y, heightT, red, green, blue;
    
    /**
     * Constructor
     * 
     * @param x location
     * @param y location
     * @param heightT 
     * @param red rgb
     * @param green rgb
     * @param blue rgb
     */
    public CheckingException( int x, int y, int heightT, int red, int green, int blue ){
        if( (x > 900 || x < 0) || (y > 800 || y < 0) ){
            throw new OutOfRangeCanvasException( x, y );
        }else if( heightT < 0 ){
            throw new OutOfRangeHeightException( heightT );
        } else if( (red < 0 || red > 255) || (green < 0 || green > 255) || (blue < 0 || blue > 255)){
            throw new OutOfRangeColorException( red, green, blue );
        }
    }
}

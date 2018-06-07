/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5;

/**
 * This class is to generate three random numbers
 * stores those three numbers in comNumArray
 * 
 * @author Sungwoong Pyeon, 000734962
 */
public class ComNumber {
    private int[] comNumArray = new int[3];
    
    /**
     * Constructor
     */
    public ComNumber(){
   
    }
    
    /**
     * array which is contained three random digits 
     * 
     * @return comNumArray
     */
    public int[] setComNumber(){
        
        // boolean valiable 
        // check if random three digits are different
        boolean randomBall = false;
        
        
        // Set the three numbers of computer
        while( !randomBall ){
            
            // The range of random digit is from 1 and 9
            for( int i = 0; i < comNumArray.length; i++ ){
                comNumArray[i] = (int) (Math.random() * 9) + 1; // the range of 1 to 9
            }
            
            // Three digits must be different
            // IF digits are different
            // Then, out of the loop
            if( comNumArray[0] != comNumArray[1] && comNumArray[0] != comNumArray[2] && comNumArray[1] != comNumArray[2] ){
                randomBall = true;
            }
        }// end while loop
        
        // print out random digits on the console
        System.out.println(comNumArray[0] + "" + comNumArray[1] + "" + comNumArray[2]);
        
        return comNumArray;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

/**
 * This class is to set current sides of dice and store those in an array
 * Print out the sides of dice and the current sides of dice
 * ex) "Dice Collection:  d4 = 4 d4 = 4 d4 = 4 d6 = 2"
 * 
 * @author Sungwoong Pyeon, 000734962
 */
public class Die {
    
    /**
     * the number of die
     */
    private final int dice;
    /**
     * contains the sides of dice and the sides of current dice
     */
    private String DiceCollection = "";
    /**
     * stores the sides of current dice
     */
    private int[] currentDie;
    /**
     * stores the default sides of dice
     */
    private final int[] setSide;
    
    /**
     * Constructor
     * 
     * @param dice the number of die
     * @param setSide the default sides of dice
     * @param currentDie the sides of current dice 
     */
    public Die( int dice, int[] setSide, int[] currentDie ){
        this.dice = dice;
        this.setSide = setSide;
        this.currentDie = currentDie;
    }
    
    /**
     * to set current die
     * it is set randomly based on the default side of die for each time
     */
    public void setCurrentDie(){
        for( int i = 0; i < dice; i++){
            currentDie[i] = (int)(Math.random() * setSide[i]) + 1;
        }
    }
    
    /**
     * to get an array of currentDie
     * @return currenDie
     */
    public int[] getCurrentDie(){
        return currentDie;
    }
    
    /**
     * to get an array of setSide
     * @return the default sides of dice
     */
    public int[] getSetSide(){
        return setSide;
    }
    
    /**
     * to get dice
     * @return the number of die
     */
    public int getDice(){
        return dice;
    }
    
    /**
     * print out message based on the number of die(dice)
     * @return dice collection message, which contains the sides of dice and the sides of current dice 
     */
    @Override
    public String toString(){
        DiceCollection = "";
        for( int i = 0; i < dice; i++ ){
            DiceCollection += " d" + setSide[i] + " = " + getCurrentDie()[i];
        }
        return "\nDice Collection: " + DiceCollection;
    }
}

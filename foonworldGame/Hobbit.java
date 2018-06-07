/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foonworld;

/**
 * This is a Attributes
 * This has steal method to take some money from the human.
 *  
 * @author SungwoongPyeon, 000734962
 */
public class Hobbit extends Attributes{

    /**
     * Constructor
     * set str, dex, arm, moxie
     * @param name 
     */
    public Hobbit( String name ){
        super(name);
    }
    
    /**
     * Constructor
     * Overloading
     * 
     * @param name
     * @param str
     * @param dex
     * @param arm
     * @param moxie 
     * @param coin 
     */
    public Hobbit(String name, int str, int dex, int arm, int moxie, int coin) {
        super(name, str, dex, arm, moxie, coin);
        super.setHealth(10);
    }
 
    public void setStealP(int stealP) {
        super.setCoin(super.getCoin() + stealP);
    }

    /**
     * hobbit can steal money( dex()/2 ) with a 50% chance.
     * 
     * @return steal money that hobbit took from the human 
     */
    public int steal(){
        int steal = 0;
        if( Math.random() <= 0.5 ){
            steal = super.getDex()/2;
            setStealP(steal);
        }
        
        return steal;
    }
    
    /**
     * 
     * @return hobbit attributes and name
     */
    @Override
    public String toString(){
        return "\nHobbit - " + checkAlive() + " -"
                + super.toString();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foonworld;

/**
 * This is a Elf
 * This has a method that returns allegiance
 * 
 * @author SungwoongPyeon, 000734962
 */
public class Forest extends Elf {
    
    /**
     * Constructor
     * set elf's attributes and name
     * 
     * @param name
     * @param str
     * @param dex
     * @param arm
     * @param moxie
     * @param coin 
     */
    public Forest(String name, int str, int dex, int arm, int moxie, int coin) {
        super(name);
        super.setStr(str);
        super.setDex(dex);
        super.setArm(arm);
        super.setMoxie(moxie);
        super.setCoin(coin);
        super.makeHobbit();
        super.setHealth(10);
        System.out.println("\nCome on Human " + allegiance());
    }
    
    /**
     * 
     * @return a message that what clan elf is belong to 
     */
    public String allegiance(){
        return "I'm " + super.getName() + ", I am loyal to the Forest Clan";
    }
    
    
    @Override
    public String toString(){
        return super.toString();
    }
}

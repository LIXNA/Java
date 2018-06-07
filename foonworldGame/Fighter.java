/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foonworld;

/**
 * This is a Human
 * This Override attack and toString method
 * 
 * @author Sungwoong Pyeon, 000734962
 */
public class Fighter extends Human {
    
    /**
     * Constructor
     * 
     * call makeElf() method from super class to create Elf instance automatically
     * @param name
     * @param str
     * @param dex
     * @param arm
     * @param moxie
     * @param coin 
     */
    public Fighter(String name, int str, int dex, int arm, int moxie, int coin) {
        super(name);
        super.setStr(str);
        super.setDex(dex);
        super.setArm(arm);
        super.setMoxie(moxie);
        super.setCoin(coin);
        super.makeElf();
        super.setHealth(15);
        System.out.println("Fighter");
    }
    
    /**
     * 
     * @return attack * 2
     */
    @Override
    public int attack() {
        return super.attack() * 2;
    }
    
    /**
     * 
     * @return Fighter's attributes and name
     */
    @Override
    public String toString() {
        return "*** Fighter ***" + super.toString();
    }

}

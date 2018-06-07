/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foonworld;

/**
 * This is a Attributes
 * This class randomly has a Forest instance or City instance.
 * This has checking method of 4 attributes's maximum sum and range(str, dex, arm and moxie).
 * This has method that returns elfClans Array( Forest or City).
 * 
 * @author SungwoongPyeon, 000734962
 */
public class Human extends Attributes{
    
    /**
    * It will check where Elf instance is belong to the array
    */
    private int elfClanN;
 
    /**
     * Array of elfClans
     * It will contain Forest or City instance
     * elfClans = { null, Forest, null} or
     * elfClans = { null, null, City }
     */
    private Elf[] elfClans = new Elf[3];
    
    /**
     * Constructor
     * 
     * @param name of the Human instance 
     */
    public Human( String name ){
        super(name);
    }
    
    /**
     * Overloading
     * Human's attributes and coin
     * 
     * @param name
     * @param str
     * @param dex
     * @param arm
     * @param moxie
     * @param coin 
     */
    public Human( String name, int str, int dex, int arm, int moxie, int coin){
        super( name, str, dex, arm, moxie, coin);
    }
    
    /**
     * Checking the maximum of the sum of human's 4 attributes
     * If the sum is bigger than 60, set attributes to the default value
     * 
     * @return valid boolean value
     */
    public boolean checkAttributes(){
        boolean valid = true;
        if( super.getStr() + super.getDex() + super.getArm() + super.getMoxie() > 60 ){
            System.out.println("\nThe sum of your attributes is more than 60\n"
                    + "Your attributes will be distributed to equally 10 for each");
            setAttributes();
            valid = false;
        }
        return valid;
    }
    
    /**
     * Generate Forest instance or City instance randomly
     * store forest in elfClans[1]
     * store city in elfClans[2]
     */
    public void makeElf(){
        elfClanN = (int)(Math.random()*2+1);
        switch(elfClanN){
            case(1):
                elfClans[1] = new Forest("Elf Enermy", 12, 12, 13, 13, 20);
                break;
            case(2):
                elfClans[2] = new City("Elf Enermy", 12, 12, 13, 13, 20);
                break;
        }
        System.out.println("\nHero Human Please Defeat the Elf and the Hobbit!!.");
    }
    
    /**
     * Checking each attributes's range from 0 and 20
     * If it is out of range, set attributes to the default 
     * @return valid boolean value
     */
    public boolean checkEachStat(){
        boolean valid = false;
        if( (super.getStr() >= 0 && super.getStr() <= 20) && (super.getDex() >= 0 && super.getDex() <= 20) 
                && (super.getArm() >= 0 && super.getArm() <= 20) && (super.getMoxie() >= 0 && super.getMoxie() <= 20 )){
            valid = true;
        }else{
            setAttributes();
            System.out.println("Range is from 0 and 20");
        }
        
        return valid;
    }
    
    /**
     * set default attributes
     */    
    public void setAttributes() {
        super.setStr(15);
        super.setDex(15);
        super.setArm(15);
        super.setMoxie(15);
    }
    
    /**
     * 
     * @return Human's attributes and name 
     */
    @Override
    public String toString(){
        return "\nHuman - " + checkAlive() + " -"
                + super.toString();
    }

    /**
     *  Checker where instance is stored in elfClans array
     * @return the elfClan
     */
    public int getElfClanN() {
        return elfClanN;
    }
    /**
     * 
     * @return elfClans 
     */
    public Elf[] getElfClans(){
        return elfClans;
    }
}

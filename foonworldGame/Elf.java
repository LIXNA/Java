/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foonworld;

/**
 * This is a Attributes
 * This class has a Hobbit instance. 
 * This has checking method of 4 attributes maximum sum and each attributes's range(str, dex, arm and moxie).
 * This has method that returns Hobbit instance.
 *
 * @author SungwoongPyeon, 000734962
 */
public class Elf extends Attributes {

    /**
     * Hobbit instance
     */
    private Hobbit hobbit;

    /**
     * Constructor
     *
     * @param name
     */
    public Elf(String name) {
        super(name);
    }

    /**
     * Overloading Constructor
     *
     * @param name
     * @param str
     * @param dex
     * @param arm
     * @param moxie
     * @param coin
     */
    public Elf(String name, int str, int dex, int arm, int moxie, int coin) {
        super(name, str, dex, arm, moxie, coin);
        super.setHealth(10);
    }

    /**
     * Checking the maximum of the sum of elf's 4 attributes If the sum is
     * bigger than 60, set attributes to the default value
     *
     * @return valid boolean value
     */
    public boolean checkAttributes() {
        boolean valid = true;
        if (super.getStr() + super.getDex() + super.getArm() + super.getMoxie() > 50) {
            System.out.println("\nThe sum of your attributes is more than 50\n"
                    + "Your attributes will be distributed to equally 12 and 13 for each");
            setAttributes();
            valid = false;
        }
        return valid;
    }

    /**
     * Checking each attributes's range from 0 and 20 If it is out of range, set
     * attributes to the default
     *
     * @return valid boolean value
     */
    public boolean checkEachStat() {
        boolean valid = false;
        if ((super.getStr() >= 0 && super.getStr() <= 20) && (super.getDex() >= 0 && super.getDex() <= 20)
                && (super.getArm() >= 0 && super.getArm() <= 20) && (super.getMoxie() >= 0 && super.getMoxie() <= 20)) {
            valid = true;
        } else {
            setAttributes();
            System.out.println("Range is from 0 and 20");
        }

        return valid;
    }

    /**
     * set default attributes
     */    
    public void setAttributes() {
        super.setStr(12);
        super.setDex(12);
        super.setArm(13);
        super.setMoxie(13);
    }

    /**
     * create hobbit instance
     */
    public void makeHobbit() {
        System.out.println("Your enermy Elf was created F I G H T ");
        hobbit = new Hobbit("Hobbit", 10, 10, 5, 10, 0);
    }

    /**
     *
     * @return hobbit instance
     */
    public Hobbit getHobbit() {
        return hobbit;
    }

    /**
     * 
     * @return elf attributes and name
     */
    @Override
    public String toString() {
        return "\nElf - " + checkAlive() + " -"
                + super.toString();
    }
}

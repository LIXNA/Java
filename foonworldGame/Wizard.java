/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foonworld;

/**
 * This is a Human
 * This has some function that is using magic and healing
 * Overriding checkingAttributes and checkEachStat method
 * because this class is added magic attribute
 * 
 * 
 * @author Sungwoong Pyeon, 000734962
 */
public class Wizard extends Human {
    
    /**
     * magic attribute
     */
    private int magic;
    
    /**
     * the maximum sum of the attributes
     * when use healing method, this will be subtracted by 3
     * because each healing method will lose 3 point of magic
     */
    private int maxAttribute = 60;
    
    /**
     * Constructor
     * call makeElf() method from super class to create Elf instance automatically
     * 
     * @param name
     * @param str
     * @param dex
     * @param arm
     * @param moxie
     * @param magic only for wizard
     * @param coin 
     */
    public Wizard(String name, int str, int dex, int arm, int moxie, int magic, int coin) {
        super(name);
        super.setStr(str);
        super.setDex(dex);
        super.setArm(arm);
        super.setMoxie(moxie);
        super.setCoin(coin);
        this.magic = magic;
        super.makeElf();
        super.setHealth(15);
        System.out.println("Wizard");
        
    }
   
    /**
     * Checking the maximum of the sum of wizard's 5 attributes
     * If the sum is bigger than maxAttributes, set attributes to the default value
     * 
     * @return valid boolean value 
     */
    @Override
    public boolean checkAttributes(){
        boolean valid = true;
        if( (super.getStr() + super.getDex() + super.getArm() + super.getMoxie() + magic ) > maxAttribute ){
            System.out.println("\nThe sum of your attributes is more than 60\n"
                    + "Your attributes will be distributed to equally 12 for each");
            super.setStr(12);
            super.setDex(12);
            super.setArm(12);
            super.setMoxie(12);
            this.magic = maxAttribute - (super.getStr() + super.getDex() + super.getArm() + super.getMoxie());
            valid = false;
            
        }
        return valid;
    }
    
    /**
     * Checking each attributes's range from 0 and 20
     * If it is out of range, set attributes to the default 
     * 
     * @return valid boolean
     */
    @Override
    public boolean checkEachStat(){
        boolean valid = false;
        if( (super.getStr() >= 0 && super.getStr() <= 20) && (super.getDex() >= 0 && super.getDex() <= 20) && (super.getArm() >= 0 && super.getArm() <= 20)
                && (super.getMoxie() >= 0 && super.getMoxie() <= 20 ) && ( getMagic() >= 0 && getMagic() <= 20) ){
            valid = true;
        }else{
            super.setStr(12);
            super.setDex(12);
            super.setArm(12);
            super.setMoxie(12);
            setMagic(maxAttribute - (super.getStr() + super.getDex() + super.getArm() + super.getMoxie()));
            System.out.println("Range is from 0 and 20");
        }
        
        return valid;
    }
    
    /**
     * heal will be used to add to health point
     * set magic - 3
     * set health that is added by heal
     * 
     * @return heal 
     */
    public int healing(){
        int heal = 0;
        
        if( getMagic() >= 3){
            heal = getMagic()/2;
            setMagic(magic - 3);
            super.setHealth(super.getHealth() + heal);
            maxAttribute -= 3;
        }else{
            System.out.println("Your magic point is less than 0, check your point");
        }
        return heal;
        
    }
    
    /**
     * set magic
     * @param magic 
     */
    public void setMagic(int magic){
        this.magic = magic;
    }
    
    /**
     * raise magic
     */
    public void raiseMagic(){
        magic ++;
    }
    
    /**
     * lower magic
     */
    public void lowerMagic(){
        magic --;
    }
    
    @Override
    public String toString(){
        return "*** Wizard ***" + super.toString() + "\n"
                + "Magic:  " + getMagic();
    }

    /**
     * @return the magic
     */
    public int getMagic() {
        return this.magic;
    }

}

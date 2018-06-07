/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foonworld;

/**
 * This is a super class.
 * This contains 4 attributes(str, dex, arm, moxie), health and coin.
 * This contains getter and setter plus raise and lower that can set 4 attributes
 * This contains attack, defend and it can check if humanoid is dead or not.
 * 
 * @author Sungwoong Pyeon, 000734962
 */
public class Attributes {
    /**
     * attributes of humanoid
     */
    private int str, dex, arm, moxie;
    /**
     * health rate of humanoid
     */
    private int health;
    /**
     * money that humanoid has
     */
    private int coin;
    /**
     * the name of humanoid
     */
    private String name;
   
    /**
     * Constructor
     * @param name 
     */
    public Attributes( String name){
        this.name = name;
    }
    
    /**
     * Overloading
     * Constructor
     * 
     * @param name
     * @param str
     * @param dex
     * @param arm
     * @param moxie
     * @param coin 
     */
    public Attributes(String name, int str, int dex, int arm, int moxie, int coin){
        this.name = name;
        this.str = str;
        this.dex = dex;
        this.arm = arm;
        this.moxie = moxie;
        this.coin = coin;
    }
    
    /**
     * Checking if humanoid is alive or not
     * 
     * @return msg 
     */
    public String checkAlive(){
        String msg;
        if( getHealth() > 0 ){
            msg = "[ Alive ]";
        }else{
            msg = "[ Dead ]";
        }
        return msg;
    }
    
    /**
     * 
     * @return ( str + dex + health ) / 3
     */
    public int attack(){
        return (getStr() + getDex() + getHealth())/3;
    }
    
    /**
     * If damage / armor is bigger than 1, health - damage / armor
     * If damage / armor is smaller than 1, health - 1
     * 
     * @param damage that humanoid gets from other humanoid 
     */
    public void defend( int damage ){
        if( damage /getArm() > 1 ){
            setHealth( getHealth() - (damage / getArm()));
        }else{
            setHealth(getHealth()-1);
        }
    }
    
    /**
     * 
     * @param damage that humanoid gets from other humanoid
     * @return realDamage which is damage / getArm();
     */
    public int defendP( int damage ){
        int realDamage;
        if( damage /getArm() > 1 ){
            realDamage = damage /getArm();
        }else{
            realDamage = 1;
        }
        
        return realDamage;
    }
    
    /**
     * @return the str
     */
    public int getStr() {
        return str;
    }

    /**
     * @param str the str to set
     */
    public void setStr(int str) {
        this.str = str;
    }

    /**
     * @return the dex
     */
    public int getDex() {
        return dex;
    }

    /**
     * @param dex the dex to set
     */
    public void setDex(int dex) {
        this.dex = dex;
    }

    /**
     * @return the arm
     */
    public int getArm() {
        return arm;
    }

    /**
     * @param arm the arm to set
     */
    public void setArm(int arm) {
        this.arm = arm;
    }

    /**
     * @return the moxie
     */
    public int getMoxie() {
        return moxie;
    }

    /**
     * @param moxie the moxie to set
     */
    public void setMoxie(int moxie) {
        this.moxie = moxie;
    }

    /**
     * @return the health
     */
    public int getHealth() {
        return health;
    }

    /**
     * @param health the health to set
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * @return the coin
     */
    public int getCoin() {
        return coin;
    }

    /**
     * @param coin the coin to set
     */
    public void setCoin(int coin) {
        this.coin = coin;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * raise str + 1
     */
    public void raiseStr(){
        setStr(getStr() + 1);
    }
    /**
     * lower str - 1
     */
    public void lowerStr(){
        setStr(getStr() - 1);
    }
    /**
     * raise dex + 1
     */
    public void raiseDex(){
        setDex(getDex() + 1);
    }
    /**
     * lower dex - 1
     */
    public void lowerDex(){
        setDex(getDex() - 1);
    }
    /**
     * raise arm + 1
     */
    public void raiseArm(){
        setArm(getArm() + 1);
    }
    /**
     * lower arm - 1
     */
    public void lowerArm(){
        setArm(getArm() - 1);
    }
    /**
     * raise moxie + 1
     */
    public void raiseMoxie(){
        setMoxie(getMoxie() + 1);
    }
    /**
     * lower moxie - 1
     */
    public void lowerMoxie(){
        setMoxie(getMoxie() - 1);
    }
    
    /**
     * 
     * @return humanoid attributes and name 
     */
    @Override
    public String toString(){
        return  "\nName:   " + getName() + "\n"
                + "Str :   " + getStr() + "\n"
                + "Dex :   " + getDex() + "\n"
                + "Arm :   " + getArm() + "\n"
                + "Moxie:  " + getMoxie() + "\n"
                + "Health: " + getHealth() + "\n"
                + "coin:   " + getCoin();
    }
    
}

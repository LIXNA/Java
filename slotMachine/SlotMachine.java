/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * This class is a casino slot machine
 * when user load money in the machine, it automatically calculate balance and 
 * once three random fruits are set, winning prize show up on the screen as a output
 * 
 * @author Sungwoong Pyeon, 000734962
 */
public class SlotMachine {
    // ** set balance of machine to 0 ** //
    private double balance = 0;
    
    // ** set the money when user load in the machine ** //
    private final double load = 1.00;
    
    // ** set a quater $0.25 ** //
    private final double aQuater = 0.25;
    
    // ** set item1(fruit1) ** //
    private int item1, item2, item3;
    
    /**
     * to get current balance of machine
     *
     * @return balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * to load $1.00 in the slot machine
     */
    public void loadMoney() {
        this.balance = (this.balance + this.load);
        System.out.println("Now you load $1.00" + ", $" + this.balance);
        System.out.println("------------------------");
    }
    
    /**
     *  to get item1 and this is encapsulated
     * @return item1 
     */
    public int getItem1() {
        return item1;
    }
    
    /**
     *  to get item2 and this is encapsulated
     * @return item2 
     */
    public int getItem2() {
        return item2;
    }
    
    /**
     *  to get item3 and this is encapsulated
     * @return item3 
     */
    public int getItem3() {
        return item3;
    }
    
    /**
     * 
     * @param item which is set randomly from spinwheel()
     * @return fruit which is converted from random item number to fruit real name    
     */
    public String getFruit(int item) {
        String fruit = new String[]{"orange", "watermelon", "pear", "cherry", "grapes"}[item];
        
        return fruit;
    }
    
    /**
     * 
     * to print out fruit picture on the canvas
     * @param fruit name of fruit which is set from getFruit()
     * @return image file 1
     */
    public Image display( String fruit) {
        Image img1;

        img1 = new Image("file:C:\\Users\\tjddn\\Documents\\NetBeansProjects\\assignment2\\src\\images\\" + fruit + ".png");
        
        return img1;
    }
    /**
     * Once user play the game, no matter how much money user win, machine automatically subtract $0.25 from the balance
     */
    public void spendQuater() {
        if (balance != 0) {
            balance -= aQuater;
        }
    }
    
    /**
     * to set each of items to the random number from 0 to 4
     */
    public void spinwheel() {
        item1 = (int) (Math.random() * 4);
        item2 = (int) (Math.random() * 4);
        item3 = (int) (Math.random() * 4);
    }
    
    /**
     * to check if user win or not 
     * @return number of fruits of the same shape
     */
    public int win() {
        if (item1 == item2 && item2 == item3 && item1 == item3) {

            return 3;
        } else if (item1 == item2 || item2 == item3 || item1 == item3) {

            return 2;
        } else {

            return 0;
        }
    }
    
    /**
     * to show the message and add prize and balance
     * @param checkWin number of fruits of the same shape
     */
    public void showPrize(int checkWin) {
        if (checkWin == 2) {
            System.out.println("You Win!! Prize is $1.00 ");
            System.out.println("------------------------");
            balance += 1.00;
        } else if (checkWin == 3) {
            System.out.println("You Win!! Prize is $3.00 ");
            System.out.println("------------------------");
            balance += 3.00;
        } else {
            System.out.println("You did not get any prize, Sorry");
            System.out.println("------------------------");
            balance += 0;
        }
    }
    
    /**
     * to make sure that program will be never working when machine does not have balance
     * @return boolean (balance > 0 or balance <= 0)
     */
    public boolean balanceLess0() {
        if (balance <= 0) {
            return true;
        } else {
            return false;
        }
    }
    

}

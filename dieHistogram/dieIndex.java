/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

import java.util.Scanner;

/**
 * This is the main class that has Die and DieCollection class
 * they are associated one another
 * set the number of die
 * set the sides of dice
 * this program can roll dice once and print out dice collection message
 * this program can roll dice 100,000 times and print out the sum of dice
 * so we can see the histogram on each roll from minimum sum of dice to maximum sum of dice.
 * 
 * @author Sungwoong Pyeon, 000734962
 */
public class Assignment4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // declare variables
        // the number of die, user will choose
        int dice;
        
        // user choice number to roll the die
        int choice;
        
        // an array of side of each die, user will choose
        int[] setSide;
        
        // an array of current each die 
        int[] currentDie;
        
        // boolean variable to quit this program
        boolean quit = false;
        
        // get the number of die from the user
        Scanner sc = new Scanner(System.in);
        System.out.print("How many dice? ");
        dice = sc.nextInt();
        
        // based on dice, user will choose the sides of each die
        // and stores in an setside array 
        setSide = new int[dice];
        System.out.print("Enter the number of sides of each die: ");
        for (int i = 0; i < setSide.length; i++) {
            setSide[i] = sc.nextInt();
        }
        
        // create an die instance
        // use the method to set the current each die
        // print out message about the side of die and the numner of current die for each
        currentDie = new int[dice];
        Die die = new Die(dice, setSide, currentDie );
        die.setCurrentDie();
        System.out.println(die.toString());
        
        // make an dieCollection instance
        // use the method of setCollection to set min, max, currentSum of dice
        // print out message about the min, max, current sum of dice
        DieCollection dieCollection = new DieCollection(die);
        dieCollection.setCollection();
        System.out.println(dieCollection.toString());
        
        // there are three options which are roll once, roll 100,000 times, quit
        // user can choose an option on the three of them
        while (!quit) {
            System.out.print("\n1 = roll once, 2 = roll 100,000 times, 3 = quit:");
            choice = sc.nextInt();

            switch (choice) {

                case (1):
                    // set the current die for each time
                    // print out some messages for each time
                    die.setCurrentDie();
                    System.out.println(die.toString());
                    dieCollection.setCurrentDie();
                    dieCollection.setCollection();
                    System.out.println(dieCollection.toString());
                    break;
                case (2):
                    // roll 100,000 times by using a method of roll for each time
                    System.out.println();
                    dieCollection.roll();
                    break;
                case (3):
                    // quit the program
                    System.out.println("\nBYE BYE BYE");
                    quit = true;
                    break;
                default:
                    System.out.println("\nYour choice is out of range please try again!");
                    break;
            }
        }
    }//Main method

}//END


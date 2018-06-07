/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

/**
 * This class has up to an die associated with it
 * Set minimum sum of dice and maximum sum of dice
 * Set current sum of dice
 * Roll 100,000 times and print out histogram, which is counted by the sum of each roll from min sum to max sum 
 * 
 * @author Sungwoong Pyeon, 000734962
 */
public class DieCollection {
    
    /**
     * die instance
     */
    private final Die die;
    /**
     * an array of current dice
     */
    private int[] currentDie;
    /**
     * an array of the sum of dice for each time
     */
    private int[] dieCount;
    /**
     * minimum sum, maximum sum and current sum of dice
     */
    private int min, max, currentSum;
    /**
     * this is used to get the sum of dice for each time in the roll method
     */
    private int sum;
    
    /**
     * Constructor
     * @param die contains the number of die, the default sides of dice and the current sides of dice
     */
    public DieCollection(Die die) {
        this.die = new Die(die.getDice(), die.getSetSide(), die.getCurrentDie());
    }
    
    /**
     * to set an array of currentDie
     */
    public void setCurrentDie() {
        this.currentDie = die.getCurrentDie();
    }
    
    /**
     * to set min sum of dice
     */
    public void setMin() {
        this.min = die.getDice();
    }
    
    /**
     * to get min sum of dice
     * @return min
     */
    public int getMin() {
        return min;
    }
    
    /**
     * to set max sum of dice
     */
    public void setMax() {
        max = 0;
        for (int i = 0; i < die.getDice(); i++) {
            this.max += die.getSetSide()[i];
        }
    }
    
    /**
     * to get max sum of dice
     * @return max
     */
    public int getMax() {
        return max;
    }
    
    /**
     * to set current sum of dice
     * currentSum is set to 0 by default, so it can be reset for each time
     */
    public void setCurrentSum() {
        currentSum = 0;
        for (int i = 0; i < die.getDice(); i++) {
            currentSum += die.getCurrentDie()[i];
        }
    }
    
    /**
     * to get current sum of dice
     * @return current sum
     */
    public int getCurrentSum() {
        return currentSum;
    }
    
    /**
     * to set methods which are setMin(), setMax() and setCurrentSum()
     */
    public void setCollection() {
        setCurrentSum();
        setMin();
        setMax();
    }
    
    /**
     * to roll 100,000 times 
     * to print out the sum of dice for each time and count them from min sum to max sum
     * to print out "*" as a graph
     */
    public void roll() {
        // set the array size to max + 1
        dieCount = new int[getMax() + 1];
        // index is used to print out "*" 
        int index = 0;
        //simulate rolls of the die for 100,000 times
        //sum is set to 0 by default
        //set current die by suing die instance method
        //assign current die to dieCollection class
        //set current sum of dice
        //count the sum
        for (int i = 1; i <= 100000; i++) {
            sum = 0;
            die.setCurrentDie();
            setCurrentDie();
            setCurrentSum();
            sum = getCurrentSum();
            dieCount[sum]++; // this is the most important 
        }
        
        //print out histogram and graph "*"
        for (int i = die.getDice(); i <= max; i++) {
            String graph = "";
            String spaces = " ";
            
            //until half of the dieCount, index increases
            //after that index decreases
            if (i <= (max - getMin()) / 2 + die.getDice()) {
                index++;
            } else if (i > (max - getMin()) / 2 + die.getDice()) {
                index--;
            }
            //the number of "*" is added based on the index
            for (int x = 0; x < index; x++) {
                graph += "*";
            }
            
            // this code is for positioning of dieCount and graph
            if (i < 10) {
                if( dieCount[i] < 10){
                    spaces = "     ";
                }else if( dieCount[i] < 100 ){
                    spaces = "    ";
                }else if( dieCount[i] < 1000 ){
                    spaces = "   ";
                }else if( dieCount[i] < 10000 ){
                    spaces = "  ";
                }
                System.out.println(" " + i + ": " + dieCount[i] + spaces + graph);
            } else {
                if( dieCount[i] < 10){
                    spaces = "     ";
                }else if( dieCount[i] < 100 ){
                    spaces = "    ";
                }else if( dieCount[i] < 1000 ){
                    spaces = "   ";
                }else if( dieCount[i] < 10000 ){
                    spaces = "  ";
                }
                System.out.println(i + ": " + dieCount[i] + spaces + graph);
            }
        }
    }
    
    /**
     * to print out message
     * @return message of min,max and currentSum of dice  
     */
    @Override
    public String toString() {
        return "Min = " + min + " Max = " + max + " Current = " + currentSum;
    }
}

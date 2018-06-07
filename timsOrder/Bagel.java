/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment7;


/**
 * This is TimsProduct and Consumable
 * 
 * @author Sungwoong Pyeon, 000734962
 */
public abstract class Bagel extends TimsProduct implements Consumable{
    
    /**
     * explanation of description and bread of bagel
     */
    private String description, bread;
    /*
     * the number of calorie
     */
    private int calorieCount;
    
    /**
     * Constructor
     * 
     * @param name 
     * @param description
     * @param bread
     * @param cost
     * @param price
     * @param calories 
     */
    private Bagel(String name, String description, String bread, double cost, double price, int calories ) {
        super(name, cost, price);
        this.description = description;
        this.calorieCount = calories;
        this.bread = bread;
    }
    
    /**
     * This is to make an instance of Bagel because constructor is private
     * Other Class cannot make an instance of Bagel without using create method
     * @return bagel instance of Bagel 
     */
    public static Bagel create(){
        Bagel bagel = new Bagel( "Cheese bagel", "Cheddar", "Regular bread", 2.3, 6.25, 400 ){};
        return bagel;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the calorieCount
     */
    @Override
    public int getCalorieCount() {
        return calorieCount;
    }
    
    @Override
    public String getConcumptionMethod(){
        return "eat it";
    }
    
    @Override
    public String toString(){
        return super.toString() + "\n" + "Type... Bagel{ " 
                + "description = " + description + ", calorieCount = " + calorieCount + ", Bread = " + bread + " }";  
    }

    /**
     * @return the bread
     */
    public String getBread() {
        return bread;
    }
}

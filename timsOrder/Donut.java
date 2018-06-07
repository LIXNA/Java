/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment7;


/**
 * This is a TimsProduct and Consumable
 * 
 * @author Sungwoong Pyeon
 */
public abstract class Donut extends TimsProduct implements Consumable{
    
    /**
     * explanation of description of Donut
     */
    private String description;
    
    /**
     * the number of calories
     */
    private int calorieCount;
    
    /**
     * Constructor
     * @param name
     * @param description
     * @param cost
     * @param price
     * @param calories 
     */
    private Donut(String name, String description, double cost, double price, int calories ) {
        super(name, cost, price);
        this.description = description;
        this.calorieCount = calories;
    }
    
    /**
     * This is to make an instance of Donut because constructor is private
     * Other Class cannot make an instance of Donut without using create method
     * @return donut
     */
    public static Donut create(){
        Donut donut = new Donut( "Sticky, gooey, good", "Kruller", 0.25, 0.99, 320 ){};
        return donut;
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
    /**
     * 
     * @return message "eat it"
     */
    @Override
    public String getConcumptionMethod(){
        return "eat it";
    }
    
    @Override
    public String toString(){
        return super.toString() + "\n" + "Type... Donut{ " 
                + "description = " + description + ", " + "calorieCount = " + calorieCount + " }";  
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment7;

/**
 * This is Commodity
 * 
 * @author Sungwoong Pyeon
 */
public abstract class TimsProduct implements Commodity{
    
    /**
     * user name cost and price of product
     */
    private String name;
    private double cost;
    private double price;
    
    /**
     * Constructor
     * @param name
     * @param cost
     * @param price 
     */
    public TimsProduct( String name, double cost, double price ){
        this.name = name;
        this.cost = cost;
        this.price = price;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the cost
     */
    @Override
    public double getProductionCost() {
        return cost;
    }

    /**
     * @return the price
     */
    @Override
    public double getRetailPrice() {
        return price;
    }
    
    @Override
    public String toString(){
        return "TimsProduct { " + "name = " + name + ", " +
                "cost = " + cost + ", " + "price = " + price + " }";
    }
    
    
}

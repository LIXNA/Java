/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5;

/**
 * This class will check if user guessing digits are the same as program's three digits
 * IF three digits and location are the same
 * Then strike
 * IF three digits are the same, but location are different 
 * Then ball
 * Three strike is win
 * 
 * @author Sungwoong Pyeon, 000734962
 */
public class BaseballGame {
    
    /**
     * user's three guessing digits
     */
    private int[] guessNum;
    
    /**
     * program's three random digits
     */
    private int[] comNum = new int[3];
    
    /**
     * the number of strike and ball
     */
    private int strike, ball;
    
    /**
     * Constructor
     * 
     * @param guessNum user's three guessing digits
     * @param comNum program's three random digits
     */
    public BaseballGame( int[] guessNum, int[] comNum){
        this.guessNum = guessNum;
        this.comNum = comNum;
    }
    
    /**
     * check user digits and program's digits
     * 
     * @return 1 or 2 
     */
    public int compareNum(){
        
        // set strike and ball to 0
        strike = 0;
        ball = 0;
        for( int i = 0; i < comNum.length; i ++ ){
                for( int j = 0; j < guessNum.length; j ++){
                    // location and number are equal, then strike 
                    if( comNum[i] == guessNum[j] && i == j ){
                        strike ++;
                        
                    // only number is equal, then ball    
                    }else if( comNum[i] == guessNum[j] && i != j ){
                        ball ++;
                    }
                }
            }
        
        //IF strike is three, user win
        if( strike == 3){
            return 1;
        }else{
            return 2;
        }
    }
    
    /**
     * print out win message
     * print out strike and ball
     * 
     * @return win message or the number of strike and ball 
     */
    public String compareMessage(){
        
        // message valiable
        String msg = "";
        switch( compareNum() ){
            
            //the value of 1 is the same meaning of three striked
            case(1):
                msg = "You win, your numbers are correct!!";
                break;
            case(2):
                msg = strike + " Strike, " + ball + " Ball";
                break;
        }
        return msg;
    }
}

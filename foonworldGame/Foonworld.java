package foonworld;

import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * There are three Humanoids : Elf, Hobbit, and Human in the foon world. User
 * can choose fighter or wizard as a career of the human. Once user select a
 * character, game will be started Human vs Elf and Hobbit. By click a attack
 * button, human, elf and hobbit will attack one another. Unless human defeat
 * the elf, human won't be able to attack hobbit. Healing for human and stealing
 * for hobbit can use only one time for each turn. Elf can set hobbit to
 * attacker or defender, it could be changeable anytime elf wants. Hobbit can
 * get some coin by stealing and 10 coin can be changed to health point 5. User
 * can change attributes of human and elf any time they want. Attack and defense
 * are based on attributes
 *
 * This main class has a human class.
 *
 * @author Sungwoong Pyeon, 000734962
 */
public class Foonworld extends Application {

    // TODO: Instance Variables for View Components and Model
    //human's instance variables
    Fighter fighter;
    Wizard wizard;

    //to store humans'instance variables in an array.
    Human[] h = new Human[3];

    //career will be used to select human instance
    //Human[] h = {  null, fighter, null } or
    //Human[] h = {  null, null, wizard }
    int career;

    //to print out the number of turn
    int turns = 0;

    // In other to make sure steal and heal skill must execute only one time in each turn
    int stealValidation, healValidation;

    //some ability and skill button
    Button attack, healing, steal, clear, coin;

    //Human Raise Button and Human Lower Button
    Button strHR, dexHR, armHR, moxieHR, magicHR, strHL, dexHL, armHL, magicHL, moxieHL;
    //Elf Raise Button and Elf Lower Button
    Button strER, dexER, armER, moxieER, strEL, dexEL, armEL, moxieEL;

    //the name of Hobbit
    //User can choose between attacker hobbit and defender hobbit by changing this text of hobbit
    TextField hobbitN;

    //in this label section, image will be inserted
    Label humanLabel, elfLabel, foonWorld, border;

    //to print out turn
    Label turn;

    //For attributes
    Label strH, dexH, armH, moxieH, magicH;
    Label strE, dexE, armE, moxieE;
    Label strHo, dexHo, armHo, moxieHo;

    Label strHN, dexHN, armHN, moxieHN, magicHN;
    Label strEN, dexEN, armEN, moxieEN;
    Label strHoN, dexHoN, armHoN, moxieHoN, coinHoN;

    // these vriables will be used to print out history of attack or some function
    Label human, elf, hobbit, humanHistory, elfHistory, hobbitHistory;
    Label humanHealth, elfHealth, hobbitHealth;

    //to keep track of game history        
    String historyH = "History of H U M A N\n";
    String historyE = "History of E L F\n";
    String historyHo = "History of H O B B I T\n";

    // TODO: Private Event Handlers and Helper Methods
    //Clear game board
    private void clearHandler(ActionEvent e) {
        historyH = "History of H U M A N\n";
        historyE = "History of E L F\n";
        historyHo = "History of H O B B I T\n";

        //set history board to the default 
        humanHistory.setText(historyH);
        elfHistory.setText(historyE);
        hobbitHistory.setText(historyHo);
    }

    //User can choose attacker hobbit or defender hobbit
    //it can be changed anytime
    private void hobbitNHandler(ActionEvent e) {
        switch (hobbitN.getText()) {
            //attacker hobbit
            //set hobbit's attributes to the default str 10, dex10, arm5, moxie10
            case "H O B B I T - 1":
                hobbitN.setStyle("-fx-background-color: LightGray");
                h[career].getElfClans()[h[career].getElfClanN()].getHobbit().setStr(10);
                h[career].getElfClans()[h[career].getElfClanN()].getHobbit().setDex(10);
                h[career].getElfClans()[h[career].getElfClanN()].getHobbit().setArm(5);
                h[career].getElfClans()[h[career].getElfClanN()].getHobbit().setMoxie(10);
                break;
            //defender hobbit
            //set hobbit's attributes to the default str 5, dex5, arm15, moxie10
            //armor is high but the number of coin from stealing is decreasing    
            case "H O B B I T - 2":
                hobbitN.setStyle("-fx-background-color: LightGray");
                h[career].getElfClans()[h[career].getElfClanN()].getHobbit().setStr(5);
                h[career].getElfClans()[h[career].getElfClanN()].getHobbit().setDex(5);
                h[career].getElfClans()[h[career].getElfClanN()].getHobbit().setArm(15);
                h[career].getElfClans()[h[career].getElfClanN()].getHobbit().setMoxie(10);
                break;
            default:
                //if user type wrong it won't work and change the color of textfield to red
                hobbitN.setText("H O B B I T - 1");
                hobbitN.setStyle("-fx-background-color:red");
                break;
        }
        //print out hobbit's attributes, which are changed 
        strHoN.setText(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getHobbit().getStr()));
        dexHoN.setText(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getHobbit().getDex()));
        armHoN.setText(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getHobbit().getArm()));
        moxieHoN.setText(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getHobbit().getMoxie()));
    }

    //Attack handler
    private void attackHandler(ActionEvent e) {
        //set validation of steal and heal
        stealValidation = 0;
        healValidation = 0;

        //check if human is alive, and elf or hobbit are alive then attack
        if (h[career].getHealth() > 0) {
            if ((h[career].getElfClans()[h[career].getElfClanN()].getHealth() > 0
                    || h[career].getElfClans()[h[career].getElfClanN()].getHobbit().getHealth() > 0)) {
                turns++;
                //check if elf is alive then human attack elf
                System.out.println("\nhuman attack");
                if (h[career].getElfClans()[h[career].getElfClanN()].getHealth() > 0) {
                    h[career].attack();
                    System.out.println(h[career].attack());

                    System.out.println("elf health point decreasing");
                    h[career].getElfClans()[h[career].getElfClanN()].defend(h[career].attack());
                    System.out.println(h[career].getElfClans()[h[career].getElfClanN()].getHealth());

                    //Print out how much damage elf get from the human attack
                    historyE += " - " + Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].defendP(h[career].attack())) + "\n";
                    elfHistory.setText(historyE);

                    //print out elf's decreased health point
                    elfHealth.setText("Health : " + Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getHealth()) + "     "
                            + h[career].getElfClans()[h[career].getElfClanN()].checkAlive());

                    //Elf is alive so attack human
                    if (h[career].getElfClans()[h[career].getElfClanN()].getHealth() > 0) {
                        h[career].getElfClans()[h[career].getElfClanN()].attack();
                        System.out.println("Elf attack");
                        System.out.println(h[career].getElfClans()[h[career].getElfClanN()].attack());

                        System.out.println("human health point decreasing");
                        h[career].defend(h[career].getElfClans()[h[career].getElfClanN()].attack());
                        System.out.println(h[career].getHealth());

                        //Print out how much damage human get from the elf attack
                        historyH += " - " + Integer.toString(h[career].defendP(h[career].getElfClans()[h[career].getElfClanN()].attack())) + "\n";
                        humanHistory.setText(historyH);

                        //print out human's decreased health point
                        humanHealth.setText("Health : " + Integer.toString(h[career].getHealth()));

                        //hobbit attack human
                        System.out.println("hobbit attack");
                        h[career].getElfClans()[h[career].getElfClanN()].getHobbit().attack();
                        System.out.println(h[career].getElfClans()[h[career].getElfClanN()].getHobbit().attack());

                        System.out.println("human health point decreasing");
                        h[career].defend(h[career].getElfClans()[h[career].getElfClanN()].getHobbit().attack());
                        System.out.println(h[career].getHealth());

                        //Print out how much damage human get from the hobbit attack
                        historyH += " - " + Integer.toString(h[career].defendP(h[career].getElfClans()[h[career].getElfClanN()].getHobbit().attack())) + "\n";
                        humanHistory.setText(historyH);

                        //print out human's decreased health point
                        humanHealth.setText("Health : " + Integer.toString(h[career].getHealth()) + "     " + h[career].checkAlive());

                        //Elf was dead so hobbit will attack human     
                    } else {
                        System.out.println("-------- Elf is dead ---------");
                        //hobbit attack human
                        System.out.println("hobbit attack");
                        h[career].getElfClans()[h[career].getElfClanN()].getHobbit().attack();
                        System.out.println(h[career].getElfClans()[h[career].getElfClanN()].getHobbit().attack());

                        System.out.println("human health point decreasing");
                        h[career].defend(h[career].getElfClans()[h[career].getElfClanN()].getHobbit().attack());
                        System.out.println(h[career].getHealth());

                        //Print out how much damage human get from the hobbit attack
                        historyH += " - " + Integer.toString(h[career].defendP(h[career].getElfClans()[h[career].getElfClanN()].getHobbit().attack())) + "\n";
                        humanHistory.setText(historyH);

                        //print out human's decreased health point
                        humanHealth.setText("Health : " + Integer.toString(h[career].getHealth()) + "     " + h[career].checkAlive());
                    }

                    //if elf is dead then human attack hobbit    
                } else {
                    h[career].attack();
                    System.out.println(h[career].attack());

                    System.out.println("hobbit health point decreasing");
                    h[career].getElfClans()[h[career].getElfClanN()].getHobbit().defend(h[career].attack());
                    System.out.println(h[career].getElfClans()[h[career].getElfClanN()].getHobbit().getHealth());

                    //Print out how much damage hobbit get from the human attack
                    historyHo += " - " + Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getHobbit().defendP(h[career].attack())) + "\n";
                    hobbitHistory.setText(historyHo);

                    //print out human's decreased health point
                    hobbitHealth.setText("Health : " + Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getHobbit().getHealth()) + "     "
                            + h[career].getElfClans()[h[career].getElfClanN()].getHobbit().checkAlive());

                    //hobbit attack human
                    System.out.println("hobbit attack");
                    h[career].getElfClans()[h[career].getElfClanN()].getHobbit().attack();
                    System.out.println(h[career].getElfClans()[h[career].getElfClanN()].getHobbit().attack());

                    System.out.println("human health point decreasing");
                    h[career].defend(h[career].getElfClans()[h[career].getElfClanN()].getHobbit().attack());
                    System.out.println(h[career].getHealth());

                    //Print out how much damage human get from the hobbit attack
                    historyH += " - " + Integer.toString(h[career].defendP(h[career].getElfClans()[h[career].getElfClanN()].getHobbit().attack())) + "\n";
                    humanHistory.setText(historyH);

                    //print out human's decreased health point
                    humanHealth.setText("Health : " + Integer.toString(h[career].getHealth()) + "     " + h[career].checkAlive());
                }
                //If elf and hobbit are both dead then print out win message    
            } else {
                System.out.println("------- Hobbit is dead ------");
                System.out.println("---------  You Win --------");
                historyH += "------ YOU WIN ------\n";
                humanHistory.setText(historyH);
            }
            //if human died then print out game over message    
        } else {
            System.out.println("Game Over you died");
            historyH += "Game Over you died\n";
            humanHistory.setText(historyH);
        }//checking if human is dead

        //after humanoids attack then steal and healing skill are available. 
        stealValidation++;
        healValidation++;

        //print out turns
        turn.setText(Integer.toString(turns) + " Turns");
    }

    //Only if user select wizard as the human career, healing handler will work
    private void healingHandler(ActionEvent e) {
        //valiable to keep track of healing message
        String healingHistory;
        //after wizard attack then user can get healValidation point
        // to validate heal skill only one time in each turn
        if (healValidation == 1) {

            //print out healing point in the human history
            healingHistory = " + " + Integer.toString(wizard.healing()) + "\n";
            historyH += healingHistory;
            humanHistory.setText(historyH);
            humanHealth.setText("Health : " + Integer.toString(wizard.getHealth()) + "     " + wizard.checkAlive());

            //magic point will lose 3 point
            //healValidation will lose 1 point
            //print out new magic attribute
            magicHN.setText(Integer.toString(wizard.getMagic()));
            healValidation = 0;
            //Otherwise healing will never work
            //print out some message
        } else {
            System.out.println("You can use healing skill only one time in your turn. You must attack");
            historyH += "------ Must Attack ------\n";
            humanHistory.setText(historyH);

        }

    }

    private void stealHandler(ActionEvent e) {
        //valiable to keep track of steal message
        String stealHistory;
        //after humanoids attack then user can get stealValidation point
        // to validate steal skill only one time in each turn
        if (stealValidation == 1) {
            //print out steal history on the game board
            //print out the number of coin
            stealHistory = "[ STEALT ] " + Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getHobbit().steal()) + "\n";
            historyHo += stealHistory;
            hobbitHistory.setText(historyHo);
            coinHoN.setText(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getHobbit().getCoin()));
            //lose stealValidation point -1
            stealValidation = 0;

            //otherwise steal function will not work
            //print out error message
        } else {
            System.out.println("You can use steal skill only one time in your turn. You must attack");
            historyHo += "------ Must Attack ------\n";
            hobbitHistory.setText(historyHo);
        }
    }

    //to change 10 coin to hobbit's health point 5
    private void coinHandler(ActionEvent e) {
        //if hobbit has over 10 coin then 
        //set and print out coin and health point 
        if (h[career].getElfClans()[h[career].getElfClanN()].getHobbit().getCoin() >= 10) {
            coin.setStyle("-fx-background-color:green;");
            h[career].getElfClans()[h[career].getElfClanN()].getHobbit().setCoin(h[career].getElfClans()[h[career].getElfClanN()].getHobbit().getCoin() - 10);
            coinHoN.setText(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getHobbit().getCoin()));
            h[career].getElfClans()[h[career].getElfClanN()].getHobbit().setHealth(h[career].getElfClans()[h[career].getElfClanN()].getHobbit().getHealth() + 5);
            hobbitHealth.setText("Health : " + Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getHobbit().getHealth()) + "     "
                    + h[career].getElfClans()[h[career].getElfClanN()].getHobbit().checkAlive());
            //otherwise change the button color to red    
        } else {
            coin.setStyle("-fx-background-color:red;");
        }
    }

    // user can raise and lower str, dex, arm and moxie anytime
    // each attribute cannot be raised up to 21 and be lowered minus
    // maximum of attributes of human is 60
    // maximum of attributes of elf is 50
    // HR is Human Raise, HL is Human Lower
    // ER is Elf Raise, EL is Elf Lower
    private void strHRHandler(ActionEvent e) {
        h[career].raiseStr();
        if (h[career].checkAttributes() && h[career].checkEachStat()) {
            strHN.setText(Integer.toString(h[career].getStr()));
        } else {
            strHN.setText(Integer.toString(h[career].getStr()));
            dexHN.setText(Integer.toString(h[career].getDex()));
            armHN.setText(Integer.toString(h[career].getArm()));
            moxieHN.setText(Integer.toString(h[career].getMoxie()));
        }
    }

    private void strHLHandler(ActionEvent e) {
        h[career].lowerStr();
        if (h[career].checkAttributes() && h[career].checkEachStat()) {
            strHN.setText(Integer.toString(h[career].getStr()));
        } else {
            strHN.setText(Integer.toString(h[career].getStr()));
            dexHN.setText(Integer.toString(h[career].getDex()));
            armHN.setText(Integer.toString(h[career].getArm()));
            moxieHN.setText(Integer.toString(h[career].getMoxie()));
        }
    }

    private void dexHRHandler(ActionEvent e) {
        h[career].raiseDex();
        if (h[career].checkAttributes() && h[career].checkEachStat()) {
            dexHN.setText(Integer.toString(h[career].getDex()));
        } else {
            strHN.setText(Integer.toString(h[career].getStr()));
            dexHN.setText(Integer.toString(h[career].getDex()));
            armHN.setText(Integer.toString(h[career].getArm()));
            moxieHN.setText(Integer.toString(h[career].getMoxie()));
        }
    }

    private void dexHLHandler(ActionEvent e) {
        h[career].lowerDex();
        if (h[career].checkAttributes() && h[career].checkEachStat()) {
            dexHN.setText(Integer.toString(h[career].getDex()));
        } else {
            strHN.setText(Integer.toString(h[career].getStr()));
            dexHN.setText(Integer.toString(h[career].getDex()));
            armHN.setText(Integer.toString(h[career].getArm()));
            moxieHN.setText(Integer.toString(h[career].getMoxie()));
        }
    }

    private void armHRHandler(ActionEvent e) {
        h[career].raiseArm();
        if (h[career].checkAttributes() && h[career].checkEachStat()) {
            armHN.setText(Integer.toString(h[career].getArm()));
        } else {
            strHN.setText(Integer.toString(h[career].getStr()));
            dexHN.setText(Integer.toString(h[career].getDex()));
            armHN.setText(Integer.toString(h[career].getArm()));
            moxieHN.setText(Integer.toString(h[career].getMoxie()));
        }
    }

    private void armHLHandler(ActionEvent e) {
        h[career].lowerArm();
        if (fighter.checkAttributes() && h[career].checkEachStat()) {
            armHN.setText(Integer.toString(h[career].getArm()));
        } else {
            strHN.setText(Integer.toString(h[career].getStr()));
            dexHN.setText(Integer.toString(h[career].getDex()));
            armHN.setText(Integer.toString(h[career].getArm()));
            moxieHN.setText(Integer.toString(h[career].getMoxie()));
        }
    }

    private void moxieHRHandler(ActionEvent e) {
        h[career].raiseMoxie();
        if (h[career].checkAttributes() && h[career].checkEachStat()) {
            moxieHN.setText(Integer.toString(h[career].getMoxie()));
        } else {
            strHN.setText(Integer.toString(h[career].getStr()));
            dexHN.setText(Integer.toString(h[career].getDex()));
            armHN.setText(Integer.toString(h[career].getArm()));
            moxieHN.setText(Integer.toString(h[career].getMoxie()));
        }
    }

    private void moxieHLHandler(ActionEvent e) {
        h[career].lowerMoxie();
        if (h[career].checkAttributes() && h[career].checkEachStat()) {
            moxieHN.setText(Integer.toString(h[career].getMoxie()));
        } else {
            strHN.setText(Integer.toString(h[career].getStr()));
            dexHN.setText(Integer.toString(h[career].getDex()));
            armHN.setText(Integer.toString(h[career].getArm()));
            moxieHN.setText(Integer.toString(h[career].getMoxie()));
        }
    }

    private void magicHRHandler(ActionEvent e) {
        wizard.raiseMagic();
        if (wizard.checkAttributes() && wizard.checkEachStat()) {
            magicHN.setText(Integer.toString(wizard.getMagic()));
        } else {
            strHN.setText(Integer.toString(wizard.getStr()));
            dexHN.setText(Integer.toString(wizard.getDex()));
            armHN.setText(Integer.toString(wizard.getArm()));
            moxieHN.setText(Integer.toString(wizard.getMoxie()));
            magicHN.setText(Integer.toString(wizard.getMagic()));
        }
    }

    private void magicHLHandler(ActionEvent e) {
        wizard.lowerMagic();
        if (wizard.checkAttributes() && wizard.checkEachStat()) {
            magicHN.setText(Integer.toString(wizard.getMagic()));
        } else {
            strHN.setText(Integer.toString(wizard.getStr()));
            dexHN.setText(Integer.toString(wizard.getDex()));
            armHN.setText(Integer.toString(wizard.getArm()));
            moxieHN.setText(Integer.toString(wizard.getMoxie()));
            magicHN.setText(Integer.toString(wizard.getMagic()));
        }
    }

    private void strERHandler(ActionEvent e) {
        h[career].getElfClans()[h[career].getElfClanN()].raiseStr();
        if (h[career].getElfClans()[h[career].getElfClanN()].checkAttributes()
                && h[career].getElfClans()[h[career].getElfClanN()].checkEachStat()) {
            strEN.setText(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getStr()));
        } else {
            strEN.setText(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getStr()));
            dexEN.setText(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getDex()));
            armEN.setText(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getArm()));
            moxieEN.setText(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getMoxie()));
        }
    }

    private void strELHandler(ActionEvent e) {

        h[career].getElfClans()[h[career].getElfClanN()].lowerStr();
        if (h[career].getElfClans()[h[career].getElfClanN()].checkAttributes()
                && h[career].getElfClans()[h[career].getElfClanN()].checkEachStat()) {
            strEN.setText(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getStr()));
        } else {
            strEN.setText(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getStr()));
            dexEN.setText(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getDex()));
            armEN.setText(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getArm()));
            moxieEN.setText(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getMoxie()));
        }

    }

    private void dexERHandler(ActionEvent e) {

        h[career].getElfClans()[h[career].getElfClanN()].raiseDex();
        if (h[career].getElfClans()[h[career].getElfClanN()].checkAttributes()
                && h[career].getElfClans()[h[career].getElfClanN()].checkEachStat()) {
            dexEN.setText(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getDex()));
        } else {
            strEN.setText(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getStr()));
            dexEN.setText(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getDex()));
            armEN.setText(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getArm()));
            moxieEN.setText(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getMoxie()));
        }

    }

    private void dexELHandler(ActionEvent e) {

        h[career].getElfClans()[h[career].getElfClanN()].lowerDex();
        if (h[career].getElfClans()[h[career].getElfClanN()].checkAttributes()
                && h[career].getElfClans()[h[career].getElfClanN()].checkEachStat()) {
            dexEN.setText(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getDex()));
        } else {
            strEN.setText(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getStr()));
            dexEN.setText(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getDex()));
            armEN.setText(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getArm()));
            moxieEN.setText(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getMoxie()));
        }

    }

    private void armERHandler(ActionEvent e) {

        h[career].getElfClans()[h[career].getElfClanN()].raiseArm();
        if (h[career].getElfClans()[h[career].getElfClanN()].checkAttributes()
                && h[career].getElfClans()[h[career].getElfClanN()].checkEachStat()) {
            armEN.setText(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getArm()));
        } else {
            strEN.setText(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getStr()));
            dexEN.setText(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getDex()));
            armEN.setText(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getArm()));
            moxieEN.setText(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getMoxie()));
        }

    }

    private void armELHandler(ActionEvent e) {
        h[career].getElfClans()[h[career].getElfClanN()].lowerArm();
        if (h[career].getElfClans()[h[career].getElfClanN()].checkAttributes()
                && h[career].getElfClans()[h[career].getElfClanN()].checkEachStat()) {
            armEN.setText(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getArm()));
        } else {
            strEN.setText(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getStr()));
            dexEN.setText(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getDex()));
            armEN.setText(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getArm()));
            moxieEN.setText(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getMoxie()));
        }
    }

    private void moxieERHandler(ActionEvent e) {

        h[career].getElfClans()[h[career].getElfClanN()].raiseMoxie();
        if (h[career].getElfClans()[h[career].getElfClanN()].checkAttributes()
                && h[career].getElfClans()[h[career].getElfClanN()].checkEachStat()) {
            moxieEN.setText(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getMoxie()));
        } else {
            strEN.setText(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getStr()));
            dexEN.setText(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getDex()));
            armEN.setText(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getArm()));
            moxieEN.setText(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getMoxie()));
        }

    }

    private void moxieELHandler(ActionEvent e) {
        h[career].getElfClans()[h[career].getElfClanN()].lowerMoxie();
        if (h[career].getElfClans()[h[career].getElfClanN()].checkAttributes()
                && h[career].getElfClans()[h[career].getElfClanN()].checkEachStat()) {
            moxieEN.setText(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getMoxie()));
        } else {
            strEN.setText(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getStr()));
            dexEN.setText(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getDex()));
            armEN.setText(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getArm()));
            moxieEN.setText(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getMoxie()));
        }
    }

    /**
     * This is where you create your components and the model and add event
     * handlers.
     *
     * @param stage The main stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root, 1700, 800); // set the size here
        stage.setTitle("Foon World"); // set the window title here
        stage.setScene(scene);

        // TODO: Add your GUI-building code here
        // 1. Create the model

        // ask the user Fighter : 1 or Wizard : 2
        career = Integer.parseInt(JOptionPane.showInputDialog("Fighter : 1 or Wizard : 2 "));

        //IF user select fighter
        //Then make an fighter instance and put in the h array
        if (career == 1) {
            fighter = new Fighter("Fighter", 15, 15, 15, 15, 15);
            h[1] = fighter;

            //declare some Label which are used to print out fighter's attributes
            humanLabel = new Label("F I G H T E R");
            strHN = new Label(Integer.toString(fighter.getStr()));
            dexHN = new Label(Integer.toString(fighter.getDex()));
            armHN = new Label(Integer.toString(fighter.getArm()));
            moxieHN = new Label(Integer.toString(fighter.getStr()));
            human = new Label("");
            human.setStyle("-fx-background-image: url(\"/images/fighter.png\");");
            System.out.println(fighter.toString());
            System.out.println(fighter.getElfClans()[fighter.getElfClanN()].toString());
            System.out.println(fighter.getElfClans()[fighter.getElfClanN()].getHobbit().toString());

            //IF user select swizard
            //Then make an wizard instance and put in the h array
        } else if (career == 2) {
            wizard = new Wizard("Ceagan", 12, 12, 12, 12, 12, 12);
            h[2] = wizard;

            //declare some Label which are used to print out wizard's attributes
            //these Label only show up when user select the wizard( magic and heal )
            humanLabel = new Label("W I Z A R D");
            healing = new Button("Healing");
            magicH = new Label("Magic");
            magicHR = new Button("+");
            magicHL = new Button("-");
            strHN = new Label(Integer.toString(wizard.getStr()));
            dexHN = new Label(Integer.toString(wizard.getDex()));
            armHN = new Label(Integer.toString(wizard.getArm()));
            moxieHN = new Label(Integer.toString(wizard.getMoxie()));
            magicHN = new Label(Integer.toString(wizard.getMagic()));
            human = new Label("");

            //set the background image
            //add Label variables
            human.setStyle("-fx-background-image: url(\"/images/wizard.jpg\");");
            root.getChildren().addAll(healing, magicH, magicHN, magicHR, magicHL);

            //set the position
            healing.setLayoutX(1200);
            healing.setLayoutY(400);
            magicH.setLayoutX(1100);
            magicH.setLayoutY(350);
            magicHN.setLayoutX(1200);
            magicHN.setLayoutY(350);
            magicHR.setLayoutX(1250);
            magicHR.setLayoutY(350);
            magicHL.setLayoutX(1300);
            magicHL.setLayoutY(350);

            //magic and heal handler
            magicHR.setOnAction(this::magicHRHandler);
            magicHL.setOnAction(this::magicHLHandler);
            healing.setOnAction(this::healingHandler);
            System.out.println(wizard.toString());
            System.out.println(wizard.getElfClans()[wizard.getElfClanN()].toString());
            System.out.println(wizard.getElfClans()[wizard.getElfClanN()].getHobbit().toString());

        }

        // 2. Create the GUI components
        border = new Label();
        turn = new Label("0 Turns");
        elf = new Label();
        hobbit = new Label();
        foonWorld = new Label();
        attack = new Button("Attack");
        clear = new Button("Clear Board");
        elfLabel = new Label("E L F");
        hobbitN = new TextField("H O B B I T - 1");
        coin = new Button("COIN");

        strH = new Label("Strength");
        strE = new Label("Strength");
        strHo = new Label("Strength");
        dexH = new Label("Dex");
        dexE = new Label("Dex");
        dexHo = new Label("Dex");
        armH = new Label("Armor");
        armE = new Label("Armor");
        armHo = new Label("Armor");
        moxieH = new Label("Moxie");
        moxieE = new Label("Moxie");
        moxieHo = new Label("Moxie");

        strEN = new Label("12");
        dexEN = new Label("12");
        armEN = new Label("13");
        moxieEN = new Label("13");

        strHoN = new Label("10");
        dexHoN = new Label("10");
        armHoN = new Label("5");
        moxieHoN = new Label("10");
        coinHoN = new Label(Integer.toString(h[career].getElfClans()[h[career].getElfClanN()].getHobbit().getCoin()));

        strHR = new Button("+");
        dexHR = new Button("+");
        armHR = new Button("+");
        moxieHR = new Button("+");
        strHL = new Button("-");
        dexHL = new Button("-");
        armHL = new Button("-");
        moxieHL = new Button("-");

        strER = new Button("+");
        dexER = new Button("+");
        armER = new Button("+");
        moxieER = new Button("+");
        strEL = new Button("-");
        dexEL = new Button("-");
        armEL = new Button("-");
        moxieEL = new Button("-");

        steal = new Button("Steal");

        humanHistory = new Label(historyH);
        elfHistory = new Label(historyE);
        hobbitHistory = new Label(historyHo);

        humanHealth = new Label("Health : 15" + "      [ Alive ]");
        elfHealth = new Label("Health : 10" + "      [ Alive ]");
        hobbitHealth = new Label("Health : 10" + "      [ Alive ]");

        // 3. Add components to the root
        root.getChildren().addAll(attack, steal, clear, coin);
        root.getChildren().addAll(humanLabel, elfLabel, hobbitN);

        root.getChildren().addAll(strH, dexH, armH, moxieH, strHN, dexHN, armHN, moxieHN);
        root.getChildren().addAll(strE, dexE, armE, moxieE, strEN, dexEN, armEN, moxieEN);
        root.getChildren().addAll(strHo, dexHo, armHo, moxieHo, strHoN, dexHoN, armHoN, moxieHoN, coinHoN);

        root.getChildren().addAll(strHR, dexHR, armHR, moxieHR, strHL, dexHL, armHL, moxieHL);
        root.getChildren().addAll(strER, dexER, armER, moxieER, strEL, dexEL, armEL, moxieEL);

        root.getChildren().addAll(foonWorld, border, turn, human, elf, hobbit, humanHistory, elfHistory, hobbitHistory);
        root.getChildren().addAll(humanHealth, elfHealth, hobbitHealth);

        // 4. Configure the components (colors, fonts, size, location)
        root.setStyle("-fx-background-color:#8c7373");

        border.setLayoutX(1050);
        border.setPrefSize(4, 800);
        border.setStyle("-fx-background-color: black;");

        turn.setLayoutX(550);
        turn.setLayoutY(100);
        turn.setStyle("-fx-text-fill:darkblue;");
        turn.setFont(new Font("Georgia", 30));

        foonWorld.setLayoutX(1370);
        foonWorld.setLayoutY(80);
        foonWorld.setPrefSize(300, 250);
        foonWorld.setStyle("-fx-background-image: url(\"/images/foonWorld.png\");");

        attack.setLayoutX(1100);
        attack.setLayoutY(400);
        clear.setLayoutX(500);
        clear.setLayoutY(750);

        humanLabel.setLayoutX(1100);
        humanLabel.setLayoutY(80);
        humanLabel.setStyle("-fx-text-fill:rgb(0, 0, 0);");
        humanLabel.setFont(new Font("System", 30));
        elfLabel.setLayoutX(1100);
        elfLabel.setLayoutY(480);
        elfLabel.setStyle("-fx-text-fill:rgb(0, 0, 0);");
        elfLabel.setFont(new Font("System", 30));

        hobbitN.setLayoutX(1400);
        hobbitN.setLayoutY(480);
        hobbitN.setStyle("-fx-text-fill:rgb(0, 0, 0);");
        hobbitN.setFont(new Font("System", 20));
        coin.setLayoutX(1390);
        coin.setLayoutY(750);

        strH.setLayoutX(1100);
        strH.setLayoutY(150);
        dexH.setLayoutX(1100);
        dexH.setLayoutY(200);
        armH.setLayoutX(1100);
        armH.setLayoutY(250);
        moxieH.setLayoutX(1100);
        moxieH.setLayoutY(300);

        strHN.setLayoutX(1200);
        strHN.setLayoutY(150);
        dexHN.setLayoutX(1200);
        dexHN.setLayoutY(200);
        armHN.setLayoutX(1200);
        armHN.setLayoutY(250);
        moxieHN.setLayoutX(1200);
        moxieHN.setLayoutY(300);

        strHR.setLayoutX(1250);
        strHR.setLayoutY(150);
        dexHR.setLayoutX(1250);
        dexHR.setLayoutY(200);
        armHR.setLayoutX(1250);
        armHR.setLayoutY(250);
        moxieHR.setLayoutX(1250);
        moxieHR.setLayoutY(300);

        strHL.setLayoutX(1300);
        strHL.setLayoutY(150);
        dexHL.setLayoutX(1300);
        dexHL.setLayoutY(200);
        armHL.setLayoutX(1300);
        armHL.setLayoutY(250);
        moxieHL.setLayoutX(1300);
        moxieHL.setLayoutY(300);

        strE.setLayoutX(1100);
        strE.setLayoutY(550);
        dexE.setLayoutX(1100);
        dexE.setLayoutY(600);
        armE.setLayoutX(1100);
        armE.setLayoutY(650);
        moxieE.setLayoutX(1100);
        moxieE.setLayoutY(700);

        strEN.setLayoutX(1200);
        strEN.setLayoutY(550);
        dexEN.setLayoutX(1200);
        dexEN.setLayoutY(600);
        armEN.setLayoutX(1200);
        armEN.setLayoutY(650);
        moxieEN.setLayoutX(1200);
        moxieEN.setLayoutY(700);

        strER.setLayoutX(1250);
        strER.setLayoutY(550);
        dexER.setLayoutX(1250);
        dexER.setLayoutY(600);
        armER.setLayoutX(1250);
        armER.setLayoutY(650);
        moxieER.setLayoutX(1250);
        moxieER.setLayoutY(700);

        strEL.setLayoutX(1300);
        strEL.setLayoutY(550);
        dexEL.setLayoutX(1300);
        dexEL.setLayoutY(600);
        armEL.setLayoutX(1300);
        armEL.setLayoutY(650);
        moxieEL.setLayoutX(1300);
        moxieEL.setLayoutY(700);

        strHo.setLayoutX(1400);
        strHo.setLayoutY(550);
        dexHo.setLayoutX(1400);
        dexHo.setLayoutY(600);
        armHo.setLayoutX(1400);
        armHo.setLayoutY(650);
        moxieHo.setLayoutX(1400);
        moxieHo.setLayoutY(700);

        strHoN.setLayoutX(1500);
        strHoN.setLayoutY(550);
        dexHoN.setLayoutX(1500);
        dexHoN.setLayoutY(600);
        armHoN.setLayoutX(1500);
        armHoN.setLayoutY(650);
        moxieHoN.setLayoutX(1500);
        moxieHoN.setLayoutY(700);
        coinHoN.setLayoutX(1500);
        coinHoN.setLayoutY(750);

        steal.setLayoutX(1550);
        steal.setLayoutY(550);

        human.setLayoutX(700);
        human.setLayoutY(10);
        human.setPrefSize(300, 200);

        elf.setLayoutX(20);
        elf.setLayoutY(10);
        elf.setPrefSize(250, 200);
        elf.setStyle("-fx-background-image: url(\"/images/elf.jpg\");");

        hobbit.setLayoutX(300);
        hobbit.setLayoutY(10);
        hobbit.setPrefSize(200, 200);
        hobbit.setStyle("-fx-background-image: url(\"/images/hobbit.jpg\");");

        humanHistory.setLayoutX(710);
        humanHistory.setLayoutY(300);
        humanHistory.setFont(new Font("System", 20));
        humanHistory.setStyle("-fx-text-fill:#b30000;");

        elfHistory.setLayoutX(30);
        elfHistory.setLayoutY(300);
        elfHistory.setFont(new Font("System", 20));
        elfHistory.setStyle("-fx-text-fill:#b30000;");

        hobbitHistory.setLayoutX(310);
        hobbitHistory.setLayoutY(300);
        hobbitHistory.setFont(new Font("System", 20));
        hobbitHistory.setStyle("-fx-text-fill:#b30000;");

        humanHealth.setLayoutX(710);
        humanHealth.setLayoutY(250);
        humanHealth.setFont(new Font("System", 22));
        humanHealth.setStyle("-fx-text-fill:darkblue;");

        elfHealth.setLayoutX(30);
        elfHealth.setLayoutY(250);
        elfHealth.setFont(new Font("System", 22));
        elfHealth.setStyle("-fx-text-fill:darkblue;");

        hobbitHealth.setLayoutX(310);
        hobbitHealth.setLayoutY(250);
        hobbitHealth.setFont(new Font("System", 22));
        hobbitHealth.setStyle("-fx-text-fill:darkblue;");

        // 5. Add Event Handlers and do final setup
        strHR.setOnAction(this::strHRHandler);
        strHL.setOnAction(this::strHLHandler);
        dexHR.setOnAction(this::dexHRHandler);
        dexHL.setOnAction(this::dexHLHandler);
        armHR.setOnAction(this::armHRHandler);
        armHL.setOnAction(this::armHLHandler);
        moxieHR.setOnAction(this::moxieHRHandler);
        moxieHL.setOnAction(this::moxieHLHandler);

        strER.setOnAction(this::strERHandler);
        strEL.setOnAction(this::strELHandler);
        dexER.setOnAction(this::dexERHandler);
        dexEL.setOnAction(this::dexELHandler);
        armER.setOnAction(this::armERHandler);
        armEL.setOnAction(this::armELHandler);
        moxieER.setOnAction(this::moxieERHandler);
        moxieEL.setOnAction(this::moxieELHandler);

        attack.setOnAction(this::attackHandler);
        steal.setOnAction(this::stealHandler);
        clear.setOnAction(this::clearHandler);
        coin.setOnAction(this::coinHandler);
        hobbitN.setOnAction(this::hobbitNHandler);

        // 6. Show the stage
        stage.show();

    }

    /**
     * Make no changes here.
     *
     * @param args unused
     */
    public static void main(String[] args) {

        launch(args);
    }
}

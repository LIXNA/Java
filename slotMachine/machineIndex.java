/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.Scanner;
import javafx.scene.image.Image;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * I used the template of FXAnimationTemplate.java from week2 This is for
 * getting input from user and operating two casino slot machines based on user
 * input. creating 2 instances called s1, s2
 *
 *
 * @author Sungwoong Pyeon, 000734962
 */
public class Assignment2 extends Application {

    /**
     * Sets up the stage and starts the main thread. Your drawing code should
     * NOT go here.
     *
     * @param stage The first stage
     */
    @Override
    public void start(Stage stage) {
        stage.setTitle("Sungwoong Pyeon assignment2"); // window title here
        Canvas canvas = new Canvas(800, 800); // canvas size here
        Group root = new Group();
        Scene scene = new Scene(root);
        root.getChildren().add(canvas);
        stage.setScene(scene);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // This code starts a "thread" which will run your animation
        Thread t = new Thread(() -> animate(gc));
        t.start();
        stage.show();

    }

    /**
     * set the default menu screen and display menu screen on the canvas
     *
     * @param gc
     */
    public void menu(GraphicsContext gc) {
        //set the canvase 
        gc.setFill(Color.GRAY);
        gc.fillRect(0, 0, 800, 800);

        //show Machine1
        gc.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 40));
        gc.strokeText("Machine1: ", 50, 100);

        //show Machine2
        gc.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 40));
        gc.strokeText("Machine2: ", 50, 400);

        //show balance machine1
        gc.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 20));
        gc.strokeText("Machine1 balance: ", 450, 700);

        //show balance machine2
        gc.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 20));
        gc.strokeText("Machine2 balance: ", 450, 780);
    }

    /**
     * Animation thread. This is where you put your animation code.
     *
     * @param gc The drawing surface
     */
    public void animate(GraphicsContext gc) {
        // YOUR CODE HERE!
        //default menu screen
        menu(gc);

        //variable
        boolean over = false;

        //make two instances s1, s2
        SlotMachine s1 = new SlotMachine();
        SlotMachine s2 = new SlotMachine();

        //loop for getting user input
        //there are 6 options that user can pick
        while (over == false) {

            Scanner sc = new Scanner(System.in);
            System.out.println("1. put a quater in machine1"
                    + "\n2.put a quater in machine2"
                    + "\n3.show balance"
                    + "\n4.Reload machine #1 with 1.00 dollar"
                    + "\n5.Reload machine #2 with 1.00 dollar"
                    + "\n6.Exit program"
                    + "\n------------------------------------------");

            int userChoice = sc.nextInt();

            //6 conditions, each of cases call some methods from the class(SlotMachine)to operate machine 
            switch (userChoice) {
                //play slot machine1
                case 1:
                    if (!s1.balanceLess0()) {
                        s1.spendQuater();
                        s1.spinwheel();
                        System.out.println(s1.getFruit(s1.getItem1()) + " || "
                                + s1.getFruit(s1.getItem2()) + " || "
                                + s1.getFruit(s1.getItem3()));
                        s1.showPrize(s1.win());
                        // to set the default menu screen
                        menu(gc);

                        // print out fruits image on the canvas
                        gc.drawImage(s1.display(s1.getFruit(s1.getItem1())), 250, 180);
                        gc.drawImage(s1.display(s1.getFruit(s1.getItem2())), 400, 180);
                        gc.drawImage(s1.display(s1.getFruit(s1.getItem3())), 550, 180);

                        //print out prize on the canvas
                        switch (s1.win()) {

                            case 0:

                                gc.setFont(Font.font("system", FontWeight.BOLD, FontPosture.ITALIC, 20));
                                gc.strokeText("You did not get any prize, Sorry", 50, 150);
                                break;
                            case 2:

                                gc.setFont(Font.font("system", FontWeight.BOLD, FontPosture.ITALIC, 20));
                                gc.strokeText("You Win!! Prize is $1.00", 50, 150);
                                break;
                            case 3:

                                gc.setFont(Font.font("system", FontWeight.BOLD, FontPosture.ITALIC, 20));
                                gc.strokeText("You Win!! Prize is $3.00", 50, 150);
                                break;
                        }

                        //print out balance machine1 
                        gc.strokeText("$" + String.valueOf(s1.getBalance()), 700, 700);
                        gc.strokeText("$" + String.valueOf(s2.getBalance()), 700, 780);
                        //if balance is less than 0, it wont be working
                    } else {
                        s1.spendQuater();
                        System.out.println("Sorry, your balance is less than 0");
                        System.out.println("Reload quaters");
                        System.out.println("------------------------");
                    }
                    break;
                //play slot machine2. it is exactly same as case 1    
                case 2:
                    if (!s2.balanceLess0()) {
                        s2.spendQuater();
                        s2.spinwheel();
                        System.out.println(s2.getFruit(s2.getItem1()) + " || "
                                + s2.getFruit(s2.getItem2()) + " || "
                                + s2.getFruit(s2.getItem3()));
                        s1.showPrize(s2.win());

                        // to set the default menu screen
                        menu(gc);

                        // print out fruits image on the canvas
                        gc.drawImage(s2.display(s2.getFruit(s2.getItem1())), 250, 520);
                        gc.drawImage(s2.display(s2.getFruit(s2.getItem2())), 400, 520);
                        gc.drawImage(s2.display(s2.getFruit(s2.getItem3())), 550, 520);

                        //print out prize on the canvas
                        switch (s2.win()) {
                            case 0:
                                gc.setFont(Font.font("system", FontWeight.BOLD, FontPosture.ITALIC, 20));
                                gc.strokeText("You did not get any prize, Sorry", 50, 450);
                                break;
                            case 2:
                                gc.setFont(Font.font("system", FontWeight.BOLD, FontPosture.ITALIC, 20));
                                gc.strokeText("You Win!! Prize is $1.00", 50, 450);
                                break;
                            case 3:
                                gc.setFont(Font.font("system", FontWeight.BOLD, FontPosture.ITALIC, 20));
                                gc.strokeText("You Win!! Prize is $3.00", 50, 450);
                                break;
                        }
                        //print out balance machine1 
                        gc.strokeText("$" + String.valueOf(s1.getBalance()), 700, 700);
                        gc.strokeText("$" + String.valueOf(s2.getBalance()), 700, 780);
                        //if balance is less than 0, it wont be working
                    } else {
                        s2.spendQuater();
                        System.out.println("Sorry, your balance is less than 0");
                        System.out.println("Reload quaters");
                        System.out.println("------------------------");
                    }
                    break;

                //show balance    
                case 3:

                    System.out.println("Your current balance is slot machine1 $" + s1.getBalance());
                    System.out.println("Your current balance is slot machine2 $" + s2.getBalance());
                    System.out.println("------------------------");
                    break;
                //load maney $1.00 in slot machine1
                case 4:
                    System.out.println("**Slot machine 1**");
                    s1.loadMoney();
                    System.out.println("------------------------");
                    
                    //default menu screen
                    menu(gc);
                    
                    //print out balance machine1 
                    gc.strokeText("$" + String.valueOf(s1.getBalance()), 700, 700);
                    gc.strokeText("$" + String.valueOf(s2.getBalance()), 700, 780);
                    break;
                //load maney $1.00 in slot machine2    
                case 5:
                    System.out.println("**Slot machine 2**");
                    s2.loadMoney();
                    System.out.println("------------------------");
                    //default menu screen
                    menu(gc);
                    
                    //print out balance machine1 
                    gc.strokeText("$" + String.valueOf(s1.getBalance()), 700, 700);
                    gc.strokeText("$" + String.valueOf(s2.getBalance()), 700, 780);
                    break;
                //quit slot machine     
                case 6:
                    over = true;
                    break;
                //set the default if user put the wrong number(input)    
                default:
                    System.out.println("Sorry, check your option number");
            }

        }

        //print out game is over
        System.out.println("Game is over, Thanks");

        gc.getCanvas().getScene();

    }

    /**
     * Use this method instead of Thread.sleep(). It handles the possible
     * exception by catching it, because re-throwing it is not an option in this
     * case.
     *
     * @param duration Pause time in milliseconds.
     */
    public static void pause(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException ex) {
        }
    }

    /**
     * Exits the app completely when the window is closed. This is necessary to
     * kill the animation thread.
     */
    @Override
    public void stop() {
        System.exit(0);
    }

    /**
     * Launches the app
     *
     * @param args unused
     */
    public static void main(String[] args) {

        launch(args);

    }
}

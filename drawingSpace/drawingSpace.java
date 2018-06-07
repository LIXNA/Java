/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1.sungwoongpyeon;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * in other to get used to using javaFX show a number of stars randomly on the
 * screen get user input location of X,Y get user's name of constellation
 * connect each of stars by line
 *
 * @author Sungwoong Pyeon, 000734962
 */
public class Assignment1Sungwoongpyeon extends Application {

    /**
     * Sets up the stage and starts the main thread. Your drawing code should
     * NOT go here.
     *
     * @param stage The first stage
     */
    @Override
    public void start(Stage stage) {
        stage.setTitle("Sungwoong Pyeon Assignment1"); // window title here
        Canvas canvas = new Canvas(800, 800); // canvas size here
        Group root = new Group();
        Scene scene = new Scene(root);
        root.getChildren().add(canvas);
        stage.setScene(scene);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        // This code starts a "thread" which will run your animation
        Thread t = new Thread(() -> animate(gc));
        t.start();
        //my code starts here
        //declare variables
        String stars;
        String userConstellation;
        String[] userX, userY;
        Image img1;
        Image img2;

        img1 = new Image("file:C:\\Users\\tjddn\\Documents\\NetBeansProjects\\assignment1-sungwoongpyeon\\src\\assignment1\\sungwoongpyeon\\moon.jpg");
        img2 = new Image("file:C:\\Users\\tjddn\\Documents\\NetBeansProjects\\assignment1-sungwoongpyeon\\src\\assignment1\\sungwoongpyeon\\planet.jpg");

        //set the backgroud color
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 800, 800);

        // *** input get a number of stars from the user
        stars = JOptionPane.showInputDialog("How many stars do you want to draw");

        // *** input get a title of constellation from user
        userConstellation = JOptionPane.showInputDialog("Enter your name of constellation?");

        // ***processing create 500 stars randomly        
        for (int randomStarCounter = 0; randomStarCounter < 500; randomStarCounter++) {
            int randomX = (int) (Math.random() * 800);
            int randomY = (int) (Math.random() * 800);

            gc.setFill(Color.WHITE);
            gc.fillOval(randomX, randomY, 3, 3);
        }

        // *** input get location X, Y from user and display on the screen
        userX = new String[Integer.parseInt(stars)];
        userY = new String[Integer.parseInt(stars)];
        final JPanel panel = new JPanel();

        for (int i = 0; i < Integer.parseInt(stars); i++) {
            //validate data range(0,799)
            // *** input X
            userX[i] = JOptionPane.showInputDialog("Choose your X" + (i + 1) + " position(0 to 799)");
            while (Integer.parseInt(userX[i]) >= 800) {
                JOptionPane.showMessageDialog(panel, "Your position X is out of range", "Error", JOptionPane.ERROR_MESSAGE);
                userX[i] = JOptionPane.showInputDialog("Choose your X" + (i + 1) + " position(0 to 799)");
            }
            //validate data range(0,799)
            // *** input Y
            userY[i] = JOptionPane.showInputDialog("Choose your Y" + (i + 1) + " position(0 to 799)");
            while (Integer.parseInt(userY[i]) >= 800) {
                JOptionPane.showMessageDialog(panel, "Your position Y is out of range", "Error", JOptionPane.ERROR_MESSAGE);
                userY[i] = JOptionPane.showInputDialog("Choose your Y" + (i + 1) + " position(0 to 799)");
            }

            gc.setFill(Color.DARKBLUE);
            gc.fillOval(Integer.parseInt(userX[i]), Integer.parseInt(userY[i]), 10, 10);
        }

        // *** processing connect each of stars 
        gc.setStroke(Color.WHITE);
        for (int j = 0; j < Integer.parseInt(stars) - 1; j++) {

            gc.strokeLine(Integer.parseInt(userX[j]), Integer.parseInt(userY[j]),
                    Integer.parseInt(userX[j + 1]), Integer.parseInt(userY[j + 1]));
        }

        // *** processing connect from the first star to the last star
        gc.setStroke(Color.WHITE);
        gc.strokeLine(Integer.parseInt(userX[0]), Integer.parseInt(userY[0]),
                Integer.parseInt(userX[Integer.parseInt(stars) - 1]), Integer.parseInt(userY[Integer.parseInt(stars) - 1]));

        //show userTitle on the screen
        gc.setFont(Font.font("System", 40));
        gc.strokeText(userConstellation, 100, 750);

        //show my own programming credit
        gc.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 30));
        gc.strokeText("Program by Sungwoong Pyeon", 50, 50);

        //show image
        gc.drawImage(img1, 500, 100);
        gc.drawImage(img2, 20, 550);
        stage.show();
        // YOUR CODE STOPS HERE
        
    }

    /**
     * Animation thread. This is where you put your animation code.
     *
     * @param gc The drawing surface
     */
    public void animate(GraphicsContext gc) {
        // YOUR CODE HERE!
        
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

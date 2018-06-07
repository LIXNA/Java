/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import static javafx.application.Application.launch;
import javafx.scene.paint.Color;

/**
 * I used the FXGraphicsTemplate. This program is to create two villages, which
 * consists of three houses, and a king house. The classes, which are
 * TwoVillages, Village, House, Door, window, Chimney, Smog1 and Smog2, are
 * associated one another.
 *
 * @author Sungwoong Pyeon, 000734962
 */
public class TwoVillages extends Application {

    /**
     * Start method (use this instead of main).
     *
     * @param stage The FX stage to draw on
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root);
        Canvas canvas = new Canvas(1200, 800); // Set canvas Size in Pixels
        stage.setTitle("Sungwoong Pyeon - Assignment3"); // Set window title
        root.getChildren().add(canvas);
        stage.setScene(scene);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // YOUR CODE STARTS HERE 
        //Set the basic background color
        gc.setFill(Color.DARKMAGENTA);
        gc.fillRect(0, 0, 1200, 800);

        //Make an instance to create a king house
        House king = new House(930, 280, Color.ORANGE);
        king.draw(gc);

        //Make an instance to create first village, called SUNGWOONG Village
        Village v1 = new Village("SUNGWOONG Village", 100, 100, 200, Color.BLUE);
        v1.draw(gc);
        
        //Make an instance to create second village, called MOHAWK Village
        Village v2 = new Village("MOHAWK Village", 200, 500, 150, Color.RED);
        v2.draw(gc);

        // YOUR CODE STOPS HERE
        stage.show();
    }

    /**
     * The actual main method that launches the app.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }

}

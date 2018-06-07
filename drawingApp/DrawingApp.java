/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawingapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Drawing app
 * The focus is on proper exception handling and the use of mouse listener
 * User can draw square based on the setting bar( location, height, Format of RGB )
 * drawing by pressing a button, by clicking the mouse on the canvas, and by dragging the mouse across the canvas
 * Checking user's input and throw exception to the other class
 * Print out exception message
 * 
 * @author Sungwoong Pyeon, 000734962   
 */
public class DrawingApp extends Application {

    // TODO: Instance Variables for View Components and Model
    
    GraphicsContext gc, transgc;
    
    //TextField variable of location, height and rgb 
    TextField x, y, heightT, red, green, blue;
    
    //Label area to print out exception error message
    Label error;
    
    //to convert text values to integer
    int newX, newY, newHeightT, newRed, newGreen, newBlue;

    // TODO: Private Event Handlers and Helper Methods
    // Check exception 
    // valid input then draw square
    private void pressHandler(MouseEvent me) {
        
        //print out pressed location value on the console
        System.out.println("Pressed " + me.getButton() + " at (" + me.getX() + "," + me.getY() + ").");
        
        //Checking exception of number format
        try {
            newX = Integer.parseInt(x.getText());
            newY = Integer.parseInt(y.getText());
            newHeightT = Integer.parseInt(heightT.getText());
            newRed = Integer.parseInt(red.getText());
            newGreen = Integer.parseInt(green.getText());
            newBlue = Integer.parseInt(blue.getText());
            
            //checking range exception
            try {
                CheckingException thrower = new CheckingException(newX, newY, newHeightT, newRed, newGreen, newBlue);
                
                // valid input then draw and print out no error message
                gc.setFill(Color.rgb(newRed, newGreen, newBlue));
                gc.fillRect(me.getX(), me.getY(), newHeightT, newHeightT);
                error.setText("No Error");
                error.setLayoutX(390);
                error.setLayoutY(750);
                error.setFont(new Font("Georgia", 30));
                error.setStyle("-fx-text-fill: green;");
            //invalid input
            //print out error message
            } catch (OutOfRangeCanvasException | OutOfRangeHeightException | OutOfRangeColorException e) {
                error.setLayoutX(100);
                error.setFont(new Font("Georgia", 20));
                error.setStyle("-fx-text-fill: red;");
                error.setText(e.getMessage());
                
            }
        //invalid format of input
        //print out error message
        } catch (NumberFormatException e) {
            error.setLayoutX(100);
            error.setFont(new Font("Georgia", 20));
            error.setStyle("-fx-text-fill: red;");
            error.setText("Bad value. All variable must be number");
        }
    }
    //print out released location value 
    private void releaseHandler(MouseEvent me) {
        System.out.println("Released " + me.getButton() + " at (" + me.getX() + "," + me.getY() + ").");
    }
    
    // Check exception 
    // valid input then draw small squre on the mouse
    private void moveHandler(MouseEvent me) {
        
        //Checking exception of number format
        try {
            newX = Integer.parseInt(x.getText());
            newY = Integer.parseInt(y.getText());
            newHeightT = Integer.parseInt(heightT.getText());
            newRed = Integer.parseInt(red.getText());
            newGreen = Integer.parseInt(green.getText());
            newBlue = Integer.parseInt(blue.getText());
            
            //checking range exception
            try {
                CheckingException thrower = new CheckingException(newX, newY, newHeightT, newRed, newGreen, newBlue);
                transgc.clearRect(0, 0, 900, 800);
                transgc.setFill(Color.rgb(newRed, newGreen, newBlue));
                transgc.fillRect(me.getX(), me.getY(), 20, 20);
            
            //invalid input
            //print out error message    
            } catch (OutOfRangeCanvasException | OutOfRangeHeightException | OutOfRangeColorException e) {
                error.setLayoutX(100);
                error.setFont(new Font("Georgia", 20));
                error.setStyle("-fx-text-fill: red;");
                error.setText(e.getMessage());
                transgc.clearRect(0, 0, 900, 800);
                transgc.setFill(Color.RED);
                transgc.fillText("ERROR", me.getX(), me.getY());
            }
        //invalid format of input
        //print out error message    
        } catch (NumberFormatException e) {
            error.setLayoutX(100);
            error.setFont(new Font("Georgia", 20));
            error.setStyle("-fx-text-fill: red;");
            error.setText("Bad value. All variable must be number");
            transgc.clearRect(0, 0, 900, 800);
            transgc.setFill(Color.RED);
            transgc.fillText("ERROR", me.getX(), me.getY());
        }

    }
    // Check exception 
    // valid input then draw square when user drag mouse while clicking a mouse
    // basically same as pressHandler
    private void dragHandler(MouseEvent me) {
        try {
            newX = Integer.parseInt(x.getText());
            newY = Integer.parseInt(y.getText());
            newHeightT = Integer.parseInt(heightT.getText());
            newRed = Integer.parseInt(red.getText());
            newGreen = Integer.parseInt(green.getText());
            newBlue = Integer.parseInt(blue.getText());
            try {
                CheckingException thrower = new CheckingException(newX, newY, newHeightT, newRed, newGreen, newBlue);

                gc.setFill(Color.rgb(newRed, newGreen, newBlue));
                gc.fillRect(me.getX(), me.getY(), newHeightT, newHeightT);
                error.setText("No Error");
                error.setLayoutX(390);
                error.setLayoutY(750);
                error.setFont(new Font("Georgia", 30));
                error.setStyle("-fx-text-fill: green;");
            } catch (OutOfRangeCanvasException | OutOfRangeHeightException | OutOfRangeColorException e) {
                error.setLayoutX(100);
                error.setFont(new Font("Georgia", 20));
                error.setStyle("-fx-text-fill: red;");
                error.setText(e.getMessage());
            }
        } catch (NumberFormatException e) {
            error.setLayoutX(100);
            error.setFont(new Font("Georgia", 20));
            error.setStyle("-fx-text-fill: red;");
            error.setText("Bad value. All variable must be number");
        }
    }
    
    //clear handler
    //user click the clear button then clear canvas 
    private void clearHandler(ActionEvent me) {
        gc.setFill(Color.MEDIUMAQUAMARINE);
        gc.fillRect(0, 0, 900, 700);
        x.setText("0");
        y.setText("0");
        heightT.setText("0");
        red.setText("0");
        green.setText("0");
        blue.setText("0");
    }
    
    // Check exception 
    // valid input then draw square when user clicks the draw button
    // basically same as pressHandler
    private void drawHandler(ActionEvent me) {

        try {
            newX = Integer.parseInt(x.getText());
            newY = Integer.parseInt(y.getText());
            newHeightT = Integer.parseInt(heightT.getText());
            newRed = Integer.parseInt(red.getText());
            newGreen = Integer.parseInt(green.getText());
            newBlue = Integer.parseInt(blue.getText());
            try {
                CheckingException thrower = new CheckingException(newX, newY, newHeightT, newRed, newGreen, newBlue);

                gc.setFill(Color.rgb(newRed, newGreen, newBlue));
                gc.fillRect(newX, newY, newHeightT, newHeightT);
                error.setText("No Error");
                error.setLayoutX(390);
                error.setLayoutY(750);
                error.setFont(new Font("Georgia", 30));
                error.setStyle("-fx-text-fill: green;");
            } catch (OutOfRangeCanvasException | OutOfRangeHeightException | OutOfRangeColorException e) {
                error.setLayoutX(100);
                error.setFont(new Font("Georgia", 20));
                error.setStyle("-fx-text-fill: red;");
                error.setText(e.getMessage());
            }
        } catch (NumberFormatException e) {
            error.setLayoutX(100);
            error.setFont(new Font("Georgia", 20));
            error.setStyle("-fx-text-fill: red;");
            error.setText("Bad value. All variable must be number");
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
        Scene scene = new Scene(root, 900, 800); // set the size here
        stage.setTitle("Assignment 8 - Drawing App"); // set the window title here
        stage.setScene(scene);
        // TODO: Add your GUI-building code here

        // 1. Create the model
        // 2. Create the GUI components
        Canvas c = new Canvas(900, 800);
        Canvas trans = new Canvas(900, 800);
        
        Label top = new Label();
        Label bottom = new Label();
        error = new Label();

        Label topText = new Label("Press the Button or Click on the canvas");
        Label location = new Label("Location:");
        x = new TextField("0");
        y = new TextField("0");
        Label height = new Label("Height:");
        heightT = new TextField("0");
        Label color = new Label("Color:");
        red = new TextField("0");
        green = new TextField("0");
        blue = new TextField("0");
        Button draw = new Button("Draw It!");
        Button clear = new Button("Clear!");

        // 3. Add components to the root
        root.getChildren().add(c);
        root.getChildren().add(trans);
        root.getChildren().addAll(top, bottom, error);
        root.getChildren().add(topText);
        root.getChildren().addAll(location, x, y, height, heightT, color, red, green, blue, draw, clear);

        // 4. Configure the components (colors, fonts, size, location)
        gc = c.getGraphicsContext2D();
        transgc = trans.getGraphicsContext2D();
        gc.setFill(Color.MEDIUMAQUAMARINE);
        gc.fillRect(0, 0, 900, 800);

        top.setStyle("-fx-background-color: #00b359;");
        top.setPrefSize(900, 40);
        bottom.setStyle("-fx-background-color: #b3ffd9;");
        bottom.setPrefSize(900, 100);
        bottom.setLayoutY(700);

        topText.setLayoutX(200);
        topText.setFont(new Font("Georgia", 30));

        error.setLayoutX(390);
        error.setLayoutY(750);
        error.setStyle("-fx-text-fill: green;");
        error.setFont(new Font("Georgia", 30));

        location.setLayoutY(700);
        x.setPrefSize(50, 10);
        x.setLayoutX(70);
        x.setLayoutY(700);
        y.setPrefSize(50, 10);
        y.setLayoutX(130);
        y.setLayoutY(700);
        height.setLayoutX(190);
        height.setLayoutY(700);
        heightT.setPrefSize(50, 10);
        heightT.setLayoutX(250);
        heightT.setLayoutY(700);
        color.setLayoutX(310);
        color.setLayoutY(700);
        red.setPrefSize(50, 10);
        red.setLayoutX(370);
        red.setLayoutY(700);
        green.setPrefSize(50, 10);
        green.setLayoutX(430);
        green.setLayoutY(700);
        blue.setPrefSize(50, 10);
        blue.setLayoutX(490);
        blue.setLayoutY(700);
        draw.setLayoutX(600);
        draw.setLayoutY(700);

        clear.setLayoutX(680);
        clear.setLayoutY(700);

        // 5. Add Event Handlers and do final setup
        trans.addEventHandler(MouseEvent.MOUSE_PRESSED, this::pressHandler);
        trans.addEventHandler(MouseEvent.MOUSE_RELEASED, this::releaseHandler);
        trans.addEventHandler(MouseEvent.MOUSE_DRAGGED, this::dragHandler);
        trans.addEventHandler(MouseEvent.MOUSE_MOVED, this::moveHandler);
        clear.setOnAction(this::clearHandler);
        draw.setOnAction(this::drawHandler);
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

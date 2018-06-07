package assignment5;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * This is a baseball game and this is based on GUI.
 * This program has two games. Each game generates three different random digits
 * Once user click game1 or game2 button, it will check three digits.
 * User can guess 3 different digits. The range of numbers is from 1 and 9
 * Each game will generate three digits in ComNumber class.
 * Each game will check three digits which user guessed in BaseballGame class.
 * IF the location of user numbers and the location of program's numbers are the same
 * Then print out the number of Strike.
 * IF the location is different, but the digit is the same 
 * Then print out the number of Ball.
 * Three strike means that user digits and program's digits are exactly the same
 * Then, game will be over
 * 
 * @author Sungwoong Pyeon, 000734962
 */
public class Assignment5 extends Application {

    // TODO: Instance Variables for View Components and Model
    // to store user's guess number in array
    int[] guessArray = new int[3];
    
    // to store program's random three digits in array
    int[] comNumArray_1 = new int[3];
    int[] comNumArray_2 = new int[3];
    
    // to count user's attempts 
    int counter1 = 0;
    int counter2 = 0;
    
    // to use in handler method
    TextField guessNum;
    Label message, count1, count2, instruct;
    Label answer1, answer2, answer3;

    // TODO: Private Event Handlers and Helper Methods
    // Once user click the game1 button will work game1Handler
    private void game1Handler(ActionEvent e) {
        // print out instro 
        instruct.setText("[Game1]\nGuess three digits\n( each number is from 1 and 9 )");
        
        // valid user's input
        // If user digits are not three, print out Error message
        if (guessNum.getText().length() != 3 || guessNum.getText().contains("0")) {
            message.setText("Error - Invalid input");
            message.setFont(new Font("System", 17));
            message.setStyle("-fx-text-fill:red;");
        // Else If user digits are three, store user's digits in guessArray    
        } else if (guessNum.getText().length() == 3) {
            guessArray[0] = Integer.parseInt(guessNum.getText().substring(0, 1));
            guessArray[1] = Integer.parseInt(guessNum.getText().substring(1, 2));
            guessArray[2] = Integer.parseInt(guessNum.getText().substring(2));
            
            // Make an instance to check user's digits and program's random digits
            // Pass user's guess digits and program's random digits to baseball instance
            BaseballGame baseball = new BaseballGame(guessArray, comNumArray_1);
            
            // IF user's three digits are not the same as program's three digits
            // Then, print out the number of strike and ball  on the message label
            // Then, print out the three digits on the answer label
            // Count user's attemps
            if (baseball.compareNum() == 2) {
                message.setText(baseball.compareMessage());
                message.setFont(new Font("System", 17));
                message.setStyle("-fx-text-fill:red;");

                answer1.setText(guessNum.getText().substring(0, 1));
                answer2.setText(guessNum.getText().substring(1, 2));
                answer3.setText(guessNum.getText().substring(2));

                counter1++;
                
            //IF user's three digits are the same as program's three digits
            //Then, Print out win message on the message label
            //Then, Print out correct digits on the answer label
            } else if (baseball.compareNum() == 1) {
                message.setText(baseball.compareMessage());
                message.setFont(new Font("System", 17));
                message.setStyle("-fx-text-fill:green;");

                answer1.setFont(new Font("System", 50));
                answer1.setStyle("-fx-text-fill:green;");

                answer2.setFont(new Font("System", 50));
                answer2.setStyle("-fx-text-fill:green;");

                answer3.setFont(new Font("System", 50));
                answer3.setStyle("-fx-text-fill:green;");

                answer1.setText(guessNum.getText().substring(0, 1));
                answer2.setText(guessNum.getText().substring(1, 2));
                answer3.setText(guessNum.getText().substring(2));

            }
        }
        // Print out user's attemps on the counter label
        count1.setText(Integer.toString(counter1));

    }
    
    // Exactly same as game1Handler
    private void game2Handler(ActionEvent e) {

        instruct.setText("[Game2]\nGuess three digits\n( each number is from 1 and 9 )");

        if (guessNum.getText().length() != 3 || guessNum.getText().contains("0")) {
            message.setText("Error - Invalid input");
            message.setFont(new Font("System", 17));
            message.setStyle("-fx-text-fill:red;");
        } else if (guessNum.getText().length() == 3) {
            guessArray[0] = Integer.parseInt(guessNum.getText().substring(0, 1));
            guessArray[1] = Integer.parseInt(guessNum.getText().substring(1, 2));
            guessArray[2] = Integer.parseInt(guessNum.getText().substring(2));
            BaseballGame baseball_2 = new BaseballGame(guessArray, comNumArray_2);

            if (baseball_2.compareNum() == 2) {
                message.setText(baseball_2.compareMessage());
                message.setFont(new Font("System", 17));
                message.setStyle("-fx-text-fill:red;");

                answer1.setFont(new Font("System", 50));
                answer1.setStyle("-fx-text-fill:red;");

                answer2.setFont(new Font("System", 50));
                answer2.setStyle("-fx-text-fill:red;");

                answer3.setFont(new Font("System", 50));
                answer3.setStyle("-fx-text-fill:red;");

                answer1.setText(guessNum.getText().substring(0, 1));
                answer2.setText(guessNum.getText().substring(1, 2));
                answer3.setText(guessNum.getText().substring(2));
                
                counter2++;
            } else if (baseball_2.compareNum() == 1) {
                message.setText(baseball_2.compareMessage());
                message.setFont(new Font("System", 17));
                message.setStyle("-fx-text-fill:green;");

                answer1.setFont(new Font("System", 50));
                answer1.setStyle("-fx-text-fill:green;");

                answer2.setFont(new Font("System", 50));
                answer2.setStyle("-fx-text-fill:green;");

                answer3.setFont(new Font("System", 50));
                answer3.setStyle("-fx-text-fill:green;");

                answer1.setText(guessNum.getText().substring(0, 1));
                answer2.setText(guessNum.getText().substring(1, 2));
                answer3.setText(guessNum.getText().substring(2));
            }
        }

        count2.setText(Integer.toString(counter2));
    }
    
    // Once user click the quit button, program will be exited
    private void quitHandler(ActionEvent e) {
        System.exit(0);
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
        Scene scene = new Scene(root, 550, 225); // set the size here
        stage.setTitle("Welcome to Baseball Game"); // set the window title here
        stage.setScene(scene);
        // TODO: Add your GUI-building code here

        // 1. Create the model
        // Random computer three digits for the game 1
        ComNumber comNumber_1 = new ComNumber();
        comNumArray_1 = comNumber_1.setComNumber();
        
        // random computer three digits for the game 2
        ComNumber comNumber_2 = new ComNumber();
        comNumArray_2 = comNumber_2.setComNumber();

        // 2. Create the GUI components
        instruct = new Label("[Game1]\nPlease guess three digits\n( each number is from 1 and 9 )");
        Label attempt1 = new Label("Game 1: ");
        Label attempt2 = new Label("Game 2: ");
        Label answerLo1 = new Label("------");
        Label answerLo2 = new Label("------");
        Label answerLo3 = new Label("------");
        answer1 = new Label("?");
        answer2 = new Label("?");
        answer3 = new Label("?");
        count1 = new Label("0");
        count2 = new Label("0");
        guessNum = new TextField("");
        message = new Label("HINT");
        Button game1 = new Button("Game1");
        Button game2 = new Button("Game2");
        Button quit = new Button("Quit");

        // 3. Add components to the root
        root.getChildren().add(instruct);
        root.getChildren().add(attempt1);
        root.getChildren().add(attempt2);
        root.getChildren().add(count1);
        root.getChildren().add(count2);
        root.getChildren().add(guessNum);
        root.getChildren().add(message);
        root.getChildren().add(game1);
        root.getChildren().add(game2);
        root.getChildren().add(answerLo1);
        root.getChildren().add(answerLo2);
        root.getChildren().add(answerLo3);
        root.getChildren().add(answer1);
        root.getChildren().add(answer2);
        root.getChildren().add(answer3);
        root.getChildren().add(quit);

        // 4. Configure the components (colors, fonts, size, location)
        instruct.setLayoutY(10);
        instruct.setLayoutX(10);

        attempt1.setLayoutY(10);
        attempt1.setLayoutX(330);
        attempt2.setLayoutY(10);
        attempt2.setLayoutX(430);

        answerLo1.setLayoutY(130);
        answerLo1.setLayoutX(300);
        answerLo2.setLayoutY(130);
        answerLo2.setLayoutX(350);
        answerLo3.setLayoutY(130);
        answerLo3.setLayoutX(400);

        answer1.setFont(new Font("System", 50));
        answer1.setStyle("-fx-text-fill:red;");
        answer1.setLayoutY(80);
        answer1.setLayoutX(305);
        answer2.setFont(new Font("System", 50));
        answer2.setStyle("-fx-text-fill:red;");
        answer2.setLayoutY(80);
        answer2.setLayoutX(355);
        answer3.setFont(new Font("System", 50));
        answer3.setStyle("-fx-text-fill:red;");
        answer3.setLayoutY(80);
        answer3.setLayoutX(405);

        count1.setFont(new Font("System", 20));
        count1.setStyle("-fx-text-fill:blue;");

        count2.setFont(new Font("System", 20));
        count2.setStyle("-fx-text-fill:blue;");

        count1.setLayoutY(6);
        count1.setLayoutX(400);
        count2.setLayoutY(6);
        count2.setLayoutX(500);

        guessNum.setLayoutY(80);
        guessNum.setLayoutX(10);

        message.setLayoutY(130);
        message.setLayoutX(10);

        game1.setLayoutY(180);
        game1.setLayoutX(10);

        game2.setLayoutY(180);
        game2.setLayoutX(100);

        quit.setLayoutY(180);
        quit.setLayoutX(190);

        // 5. Add Event Handlers and do final setup
        game1.setOnAction(this::game1Handler);
        game2.setOnAction(this::game2Handler);
        quit.setOnAction(this::quitHandler);
        
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

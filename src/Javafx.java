import java.awt.Color;
import java.util.concurrent.FutureTask;

import javax.swing.text.html.HTMLDocument.RunElement;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;  
import javafx.scene.text.*;

public class Javafx extends Application {
 // class scope (not inside a method)
    // turn is true for X
    public static boolean turn = true, won = false;
    
    public static int row1, row2, row3, col1, col2, col3, dia1, dia2;
    public static int tries = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        row1 = row2 = row3 = col1 = col2 = col3 = dia1 = dia2 = 0;
        primaryStage.show();
        Pane layout = new Pane();
        Scene gameScene = new Scene(layout, 800, 800);
        primaryStage.setScene(gameScene);


        
        // make the endGame button 
        Button endGame = new Button("");

        // add the button to the layout 
        layout.getChildren().add(endGame);

        // set the size of the button to 800 by 800 to fill the screen
        endGame.setPrefSize(800, 800);

        //set the location of the button to 0,0
        endGame.relocate(0, 0);

        // set the endgame text font to 90 
        endGame.setStyle("fx-font-size=90");

        // disable the button 
        endGame.setDisable(true);



        // create new button 
        Button topLeft = new Button("");

        // add button to layout 
        layout.getChildren().add(topLeft);

        //set size to 100 100 
        topLeft.setPrefSize(100, 100);
        
        //locate to proper position
        topLeft.relocate(800/4, 800/4);
        //set the font 
        topLeft.setStyle("fx-font-size=18");

        
        topLeft.setOnAction(event -> {
            //if the game is won, nothing should happen when the buttonsa re pressed 
            if(won)return;
            //increment tries counter 
            tries++;
            
            
            if(turn == true) {
                topLeft.setText("X");
                row1++;
                col1++;
                dia1++;

                //  
            }
            if(turn == false) {
                topLeft.setText("O");
                row1--;
                col1--;
                dia1--;
            }
            turn = !turn;


            if( row1 == 3 || row2 == 3 || row3 == 3 || col1 == 3 || col2 == 3 || col3 == 3 || dia1 == 3 || dia2 == 3){
                endGame.setText("X wins, press to play again ");
                endGame.toFront();
                won = true;
                endGame.setDisable(false);

            }
            
            if( row1 == -3 || row2 == -3 || row3 == -3 ||  col1 == -3 || col2 == -3 || col3 == -3 || dia1 == -3 || dia2 == -3){
                endGame.setText("O wins, press to play again ");
                endGame.toFront();
                won = true;
                endGame.setDisable(false);


            }

            if(tries == 9){
                endGame.setText("Tie, press to play again ");
                endGame.toFront();
                won = true;
                endGame.setDisable(false);
            }
            topLeft.setDisable(true);
        });

        //======================================

        Button topMid = new Button("");
        layout.getChildren().add(topMid);
        topMid.setPrefSize(100, 100);
        topMid.relocate(800/4*2, 800/4);
        topMid.setStyle("fx-font-size=18");
        topMid.setOnAction(event -> {
              if(won)return;
              tries++;
            if(turn == true) {
                topMid.setText("X");
                row1++;
                col2++;

            }
            if(turn == false) {
                topMid.setText("O");
                row1--;
                col2--;
                
            }
            turn = !turn;

            if( row1 == 3 || row2 == 3 || row3 == 3 || col1 == 3 || col2 == 3 || col3 == 3 || dia1 == 3 || dia2 == 3){
                endGame.setText("X wins, press to play again ");
                endGame.toFront();
                won = true;
                                endGame.toFront();
                endGame.setDisable(false);

            }
            
            if( row1 == -3 || row2 == -3 || row3 == -3 ||  col1 == -3 || col2 == -3 || col3 == -3 || dia1 == -3 || dia2 == -3){
                endGame.setText("O wins, press to play again ");
                endGame.toFront();
                won = true;
                endGame.setDisable(false);


            }
            if(tries == 9){
                endGame.setText("Tie, press to play again ");
                endGame.toFront();
                won = true;
                endGame.setDisable(false);
            }

            topMid.setDisable(true);
        });


        Button topRight = new Button("");
        layout.getChildren().add(topRight);
        topRight.setPrefSize(100, 100);
        topRight.relocate(800/4*3, 800/4);
        topRight.setStyle("fx-font-size=18");
        topRight.setOnAction(event -> {
            if(won)return;
            tries++;
            if(turn == true) {
                topRight.setText("X");
                row1++;
                col3++;
                dia2++;
            }
            if(turn == false) {
                topRight.setText("O");
                row1--;
                col3--;
                dia2--;
            }
            turn = !turn;


            if( row1 == 3 || row2 == 3 || row3 == 3 || col1 == 3 || col2 == 3 || col3 == 3 || dia1 == 3 || dia2 == 3){
                endGame.setText("X wins, press to play again ");
                endGame.toFront();
                won = true;
                endGame.setDisable(false);

            }
            
            if( row1 == -3 || row2 == -3 || row3 == -3 ||  col1 == -3 || col2 == -3 || col3 == -3 || dia1 == -3 || dia2 == -3){
                endGame.setText("O wins, press to play again ");
                endGame.toFront();
                won = true;
                endGame.setDisable(false);


            }
            if(tries == 9){
                endGame.setText("Tie, press to play again ");
                endGame.toFront();
                won = true;
                endGame.setDisable(false);
            }

            topRight.setDisable(true);
        });





        

        
        Button middleLeft = new Button("");
        layout.getChildren().add(middleLeft);
        middleLeft.setPrefSize(100, 100);
        middleLeft.relocate(800/4, 800/4*2);
        middleLeft.setStyle("fx-font-size=18");
        middleLeft.setOnAction(event -> {
            if(won)return;
            tries++;
            if(turn == true) {
                middleLeft.setText("X");
                row2++;
                col1++;
     
            }
            if(turn == false) {
                middleLeft.setText("O");
                row2--;
                col1--;
               
            }
            turn = !turn;


            if( row1 == 3 || row2 == 3 || row3 == 3 || col1 == 3 || col2 == 3 || col3 == 3 || dia1 == 3 || dia2 == 3){
                endGame.setText("X wins, press to play again ");
                endGame.toFront();
                won = true;
                endGame.setDisable(false);

            }
            
            if( row1 == -3 || row2 == -3 || row3 == -3 ||  col1 == -3 || col2 == -3 || col3 == -3 || dia1 == -3 || dia2 == -3){
                endGame.setText("O wins, press to play again ");
                endGame.toFront();
                won = true;
                endGame.setDisable(false);


            }
            if(tries == 9){
                endGame.setText("Tie, press to play again ");
                endGame.toFront();
                won = true;
                endGame.setDisable(false);
            }

            middleLeft.setDisable(true);
        });



        Button middleMiddle = new Button("");
        layout.getChildren().add(middleMiddle);
        middleMiddle.setPrefSize(100, 100);
        middleMiddle.relocate(800/4*2, 800/4*2);
        middleMiddle.setStyle("fx-font-size=18");
        middleMiddle.setOnAction(event -> {
            if(won)return;
            tries++;
            if(turn == true) {
                middleMiddle.setText("X");
                row2++;
                col2++;
                dia1++;
                dia2++;

            }
            if(turn == false) {
                middleMiddle.setText("O");
                row2--;
                col2--;
                dia1--;
                dia2--;
            }
            turn = !turn;

            if(tries == 9){
                endGame.setText("Tie, press to play again ");
                endGame.toFront();
                won = true;
                endGame.setDisable(false);
            }

            if( row1 == 3 || row2 == 3 || row3 == 3 || col1 == 3 || col2 == 3 || col3 == 3 || dia1 == 3 || dia2 == 3){
                endGame.setText("X wins, press to play again ");
                endGame.toFront();
                won = true;
                endGame.setDisable(false);

            }
            
            if( row1 == -3 || row2 == -3 || row3 == -3 ||  col1 == -3 || col2 == -3 || col3 == -3 || dia1 == -3 || dia2 == -3){
                endGame.setText("O wins, press to play again ");
                endGame.toFront();
                won = true;
                endGame.setDisable(false);


            }

            middleMiddle.setDisable(true);
        });

        Button middleRight = new Button("");
        layout.getChildren().add(middleRight);
        middleRight.setPrefSize(100, 100);
        middleRight.relocate(800/4*3, 800/4*2);
        middleRight.setStyle("fx-font-size=18");
        middleRight.setOnAction(event -> {
            if(won)return;
            tries++;
            if(turn == true) {
                middleRight.setText("X");
                row2++;
                col3++;

            }
            if(turn == false) {
                middleRight.setText("O");
                row2--;
                col3--;
            }
            turn = !turn;

            if(tries == 9){
                endGame.setText("Tie, press to play again ");
                endGame.toFront();
                won = true;
                endGame.setDisable(false);
            }
            if( row1 == 3 || row2 == 3 || row3 == 3 || col1 == 3 || col2 == 3 || col3 == 3 || dia1 == 3 || dia2 == 3){
                endGame.setText("X wins, press to play again ");
                endGame.toFront();
                won = true;
                endGame.setDisable(false);

            }
            
            if( row1 == -3 || row2 == -3 || row3 == -3 ||  col1 == -3 || col2 == -3 || col3 == -3 || dia1 == -3 || dia2 == -3){
                endGame.setText("O wins, press to play again ");
                endGame.toFront();
                won = true;
                endGame.setDisable(false);


            }

            middleRight.setDisable(true);
        });

        // bottom row
        Button bottomLeft = new Button("");
        layout.getChildren().add(bottomLeft);
        bottomLeft.setPrefSize(100, 100);
        bottomLeft.relocate(800/4, 800/4*3);
        bottomLeft.setStyle("fx-font-size=18");
        bottomLeft.setOnAction(event -> {
            if(won)return;
            tries++;
            if(turn == true) {
                bottomLeft.setText("X");
                row3++;
                col1++;
                dia2++;
     
            }
            if(turn == false) {
                bottomLeft.setText("O");
                row3--;
                col1--;
                dia2--;
               
            }
            turn = !turn;

            if(tries == 9){
                endGame.setText("Tie, press to play again ");
                endGame.toFront();
                won = true;
                endGame.setDisable(false);
            }
            if( row1 == 3 || row2 == 3 || row3 == 3 || col1 == 3 || col2 == 3 || col3 == 3 || dia1 == 3 || dia2 == 3){
                endGame.setText("X wins, press to play again ");
                endGame.toFront();
                won = true;
                endGame.setDisable(false);

            }
            
            if( row1 == -3 || row2 == -3 || row3 == -3 ||  col1 == -3 || col2 == -3 || col3 == -3 || dia1 == -3 || dia2 == -3){
                endGame.setText("O wins, press to play again ");
                endGame.toFront();
                won = true;
                endGame.setDisable(false);


            }

            bottomLeft.setDisable(true);
        });



        Button bottomMiddle = new Button("");
        layout.getChildren().add(bottomMiddle);
        bottomMiddle.setPrefSize(100, 100);
        bottomMiddle.relocate(800/4*2, 800/4*3);
        bottomMiddle.setStyle("fx-font-size=18");
        bottomMiddle.setOnAction(event -> {
            if(won)return;
            tries++;
            if(turn == true) {
                bottomMiddle.setText("X");
                row3++;
                col2++;


            }
            if(turn == false) {
                bottomMiddle.setText("O");
                row3--;
                col2--;

            }
            turn = !turn;


            if(tries == 9){
                endGame.setText("Tie, press to play again ");
                endGame.toFront();
                won = true;
                endGame.setDisable(false);
            }

            if( row1 == 3 || row2 == 3 || row3 == 3 || col1 == 3 || col2 == 3 || col3 == 3 || dia1 == 3 || dia2 == 3){
                endGame.setText("X wins, press to play again ");
                endGame.toFront();
                won = true;
                endGame.setDisable(false);

            }
            
            if( row1 == -3 || row2 == -3 || row3 == -3 ||  col1 == -3 || col2 == -3 || col3 == -3 || dia1 == -3 || dia2 == -3){
                endGame.setText("O wins, press to play again ");
                endGame.toFront();
                won = true;
                endGame.setDisable(false);


            }

            bottomMiddle.setDisable(true);

            
        });

        Button bottomright = new Button("");
        layout.getChildren().add(bottomright);
        bottomright.setPrefSize(100, 100);
        bottomright.relocate(800/4*3, 800/4*3);
        bottomright.setStyle("fx-font-size=18");
        bottomright.setOnAction(event -> {
            if(won)return;
            tries++;
            if(turn == true) {
                bottomright.setText("X");
                row3++;
                col3++;
                dia1++;

            }
            if(turn == false) {
                bottomright.setText("O");
                row3--;
                col3--;
                dia1--;
            }
            turn = !turn;


            if(tries == 9){
                endGame.setText("Tie, press to play again ");
                endGame.toFront();
                won = true;
                endGame.setDisable(false);
            }
            if( row1 == 3 || row2 == 3 || row3 == 3 || col1 == 3 || col2 == 3 || col3 == 3 || dia1 == 3 || dia2 == 3){
                endGame.setText("X wins, press to play again ");
                endGame.toFront();
                won = true;
                endGame.setDisable(false);

            }
            
            if( row1 == -3 || row2 == -3 || row3 == -3 ||  col1 == -3 || col2 == -3 || col3 == -3 || dia1 == -3 || dia2 == -3){
                endGame.setText("O wins, press to play again ");
                endGame.toFront();
                won = true;
                endGame.setDisable(false);


            }

            bottomright.setDisable(true);
           

        });
        

        

        endGame.setOnAction(event -> {
            won = false;
            tries = 0;
                topLeft.setDisable(false);
                topLeft.setText("");
                topMid.setDisable(false);
                topMid.setText("");
                topRight.setDisable(false);
                topRight.setText("");

                middleLeft.setDisable(false);
                middleLeft.setText("");
                middleMiddle.setDisable(false);
                middleMiddle.setText("");
                middleRight.setDisable(false);
                middleRight.setText("");

                bottomLeft.setDisable(false);
                bottomLeft.setText("");
                bottomMiddle.setDisable(false);
                bottomMiddle.setText("");
                bottomright.setDisable(false);
                bottomright.setText("");

                endGame.setDisable(true);
                endGame.toBack();
                row1 = row2 = row3 = col1 = col2 = col3 = dia1 = dia2 = 0;
                endGame.setText("");
            

        });




    }

    public static void main(String[] banana) {
        launch(banana);
    }

}
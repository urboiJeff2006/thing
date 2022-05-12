import java.awt.Color;
import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTMLDocument.RunElement;

import org.w3c.dom.css.Rect;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.value.WeakChangeListener;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.skin.TextInputControlSkin.Direction;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;  
import javafx.scene.text.*;



public class ekans extends Application {

    public ArrayList<Rectangle> snake = new ArrayList<>();
    public Character headDirection = 'U';

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.show();
        Pane layout = new Pane();
        Scene gameScene = new Scene(layout, 1920, 1080);
        primaryStage.setScene(gameScene);
        

        Rectangle rect = new Rectangle(1920/2,1080/2,40,40);

        snake.add(rect);

        layout.getChildren().add(rect);

        // make the endGame button 
        
        gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.RIGHT && headDirection != 'L'){
                    headDirection = 'R';
                } 
                if(event.getCode() == KeyCode.LEFT && headDirection != 'R'){
                    headDirection = 'L';
                } 
                if(event.getCode() == KeyCode.UP && headDirection != 'D'){
                    headDirection = 'U';
                } 
                if(event.getCode() == KeyCode.DOWN && headDirection != 'U'){
                    headDirection = 'D';
                } 
            }


        });
        AnimationTimer timer = new MyTimer(layout);
        timer.start();

    }


    

    class MyTimer extends AnimationTimer{
        Pane layout;
        MyTimer(Pane p){
            layout = p;
        }
        public void handle(long a){
            fun();
        }
        private void fun(){
            try{
                TimeUnit.MILLISECONDS.sleep(100);
            }
            catch(Exception e){

            }
            System.out.println("adfkj");

            Rectangle add = new Rectangle(0,0,40,40);
            double headX = snake.get(0).getX(), headY = snake.get(0).getY();

                if(headDirection == 'U'){
                   add.setY(headY-40);
                   add.setX(headX);
                }
                if(headDirection  == 'D'){
                    add.setY(headY+40);
                    add.setX(headX);
                }
                if(headDirection == 'R'){
                    add.setY(headY);
                    add.setX(headX+40);
                }
                if(headDirection  == 'L'){
                    add.setY(headY);
                    add.setX(headX-40);
                }
                snake.add(0,add);
                System.out.println("at"+ add.getX() + " :" + add.getY());
                layout.getChildren().add(add);
                
                if(snake.size()>15){
                    snake.get(snake.size()-1).setX(10000);
                    snake.remove(snake.size()-1);
                }

        }
    }


    public static void main(String[] banana) {
        launch(banana);
    }

}
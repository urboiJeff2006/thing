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

class pii{
    int   x,  y; 
    pii(int X, int Y){

        x = X;
        y = y;
    }
}
class segment{
    Stack<pii> dest = new Stack();
    
}

public class Snake extends Application {

    public ArrayList<Rectangle> snake = new ArrayList<>();
    public ArrayList<Character> snakeSegments = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.show();
        Pane layout = new Pane();
        Scene gameScene = new Scene(layout, 1920, 1080);
        primaryStage.setScene(gameScene);
        

        Rectangle rect = new Rectangle(100,100,40,40);

        snake.add(rect);
        snakeSegments.add('U');

        Rectangle rect1 = new Rectangle(100,60,40,40);
        snake.add(rect1);
        snakeSegments.add('U');

        layout.getChildren().add(rect);
        layout.getChildren().add(rect1);

        
        
        // make the endGame button 
        
        gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.RIGHT && snakeSegments.get(0) != 'L') snakeSegments.add(0,'R');
                if(event.getCode() == KeyCode.LEFT && snakeSegments.get(0) != 'R') snakeSegments.add(0,'L');
                if(event.getCode() == KeyCode.UP && snakeSegments.get(0) != 'D') snakeSegments.add(0,'U');
                if(event.getCode() == KeyCode.DOWN && snakeSegments.get(0) != 'U') snakeSegments.add(0,'D');

                
                
            }


        });
        AnimationTimer timer = new MyTimer();
        timer.start();

    }


    

    class MyTimer extends AnimationTimer{
        
        public void handle(long a){
            fun();
        }
        private void fun(){
            try{
                TimeUnit.MILLISECONDS.sleep(500);
            }
            catch(Exception e){

            }
            
            for(int i =0; i <snake.size();i++ ){
                
                if(snakeSegments.get(i) == 'U'){
                    snake.get(i).setY(snake.get(i).getY()-40);
                }
                if(snakeSegments.get(i)  == 'D'){
                    snake.get(i).setY(snake.get(i).getY()+40);
                }
                if(snakeSegments.get(i)  == 'R'){
                    snake.get(i).setX(snake.get(i).getX()+40);
                }
                if(snakeSegments.get(i)  == 'L'){
                    snake.get(i).setX(snake.get(i).getX()-40);
                }
            }


        }
    }


    public static void main(String[] banana) {
        launch(banana);
    }

}
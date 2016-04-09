/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bounceballcontrol;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import java.util.*;


/**
 *
 * @author Eric
 */
public class BounceBallControl extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        BallPane ballPane=new BallPane();//Create a ball Pane
        
        //Pause and resume animation
        ballPane.setOnMousePressed(e -> ballPane.pause());
        ballPane.setOnMouseReleased(e -> ballPane.play());
        
        //increase and decrease animation
        ballPane.setOnKeyPressed(e -> {
            if(e.getCode()==KeyCode.UP){
                ballPane.increaseSpeed();
            }
            else if(e.getCode()==KeyCode.DOWN){
                ballPane.decreaseSpeed();
            }
        });
        
        /*
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        */       
        //StackPane root = new StackPane();
        //root.getChildren().add(btn);
                
        Scene scene = new Scene(ballPane, 500,400);        
        primaryStage.setTitle("BounceBallControl");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        //Must request focus after the primary stage is displayed
        ballPane.requestFocus();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

class BallPane extends Pane {
  public final double radius = 20;
  private double x = radius, y = radius;
  private double dx = 1, dy = 1;
  ArrayList<Circle> cc=new ArrayList<Circle>();  
  private Timeline animation;  
  public Circle c1 ;
  public Circle c2 ;
  public Circle c3 ;
  public Circle c4 ;
  public Circle c5 ;  
  public Circle c6 ;  
  public Circle c7 ; 
  ArrayList<Integer> yax=new ArrayList<Integer>();

  public BallPane() {      
    c1 = new Circle(x, y, radius);
    c1.setFill(Color.RED); // Set ball color
    getChildren().add(c1); // Place a ball into this pane
    cc.add(c1);
    yax.add(50);    
    
    
    c2 = new Circle(x, y, radius); 
    c2.setFill(Color.ORANGE); // Set ball color
    getChildren().add(c2); // Place a ball into this pane
    cc.add(c2);        
    yax.add(100);            
    
    c3 = new Circle(x, y, radius);
    c3.setFill(Color.YELLOW); // Set ball color
    getChildren().add(c3); // Place a ball into this pane
    cc.add(c3);
    yax.add(150);    
    
    c4 = new Circle(x, y, radius);
    c4.setFill(Color.GREEN); // Set ball color
    getChildren().add(c4); // Place a ball into this pane
    cc.add(c4);
    yax.add(200);    
    
    c5 = new Circle(x, y, radius);
    c5.setFill(Color.BLUE); // Set ball color
    getChildren().add(c5); // Place a ball into this pane
    cc.add(c5);
    yax.add(250);    
    
    c6 = new Circle(x, y, radius);
    c6.setFill(Color.LIGHTBLUE); // Set ball color
    getChildren().add(c6); // Place a ball into this pane
    cc.add(c6);
    yax.add(300);    
    
    c7 = new Circle(x, y, radius);
    c7.setFill(Color.PURPLE); // Set ball color
    getChildren().add(c7); // Place a ball into this pane
    cc.add(c7);
    yax.add(350);    

    // Create an animation for moving the ball
    animation = new Timeline(
      new KeyFrame(Duration.millis(50), e -> moveBall()));
    animation.setCycleCount(Timeline.INDEFINITE);
    animation.play(); // Start animation
    
   }

  public void play() {
    animation.play();
  }

  public void pause() {
    animation.pause();
  }

  public void increaseSpeed() {
    animation.setRate(animation.getRate() + 0.1);
  }

  public void decreaseSpeed() {
    animation.setRate(
      animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
  }

  public DoubleProperty rateProperty() {
    return animation.rateProperty();
  }
  
  protected void moveBall() {
  //protected void moveBall() {
     Circle opc; 
      int i;
    // Check boundaries
    if (x < radius || x > getWidth() - radius) {
      dx *= -1; // Change ball move direction
    }
    if (y < radius || y > getHeight() - radius) {
      dy *= -1; // Change ball move direction
    }

    // Adjust ball position
    x += dx;
    //y += dy;
    //y=50;
    
    int len=cc.size();
    for(i=0;i<len;i++){
        opc=cc.get(i);
        opc.setCenterX(x);
        opc.setCenterY(yax.get(i));
    }            
  }
}
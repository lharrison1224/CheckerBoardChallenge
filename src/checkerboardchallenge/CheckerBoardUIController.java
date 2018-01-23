/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboardchallenge;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author loganharrison
 */
public class CheckerBoardUIController implements Initializable {
    @FXML
    public MenuItem three;
    
    @FXML
    public MenuItem eight;
    
    @FXML
    public MenuItem ten;
    
    @FXML
    public MenuItem sixteen;
    
    @FXML
    public VBox container;
    
    private CheckerBoard currentBoard = null;
    private final int MENUBAR_HEIGHT = 29;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        //set on actions here so you can use same function to change board size
        three.setOnAction((ActionEvent event) -> {
            changeBoardSize(3);
        });
        
        eight.setOnAction((ActionEvent event) -> {
            changeBoardSize(8);
        });
        
        ten.setOnAction((ActionEvent event) -> {
            changeBoardSize(10);
        });
        
        sixteen.setOnAction((ActionEvent event) -> {
            changeBoardSize(16);
        });

       
        //set up initial board
        CheckerBoard checkerBoard = new CheckerBoard(8, 8, 600.0, 600.0);
        checkerBoard.build();
        currentBoard = checkerBoard;
        container.getChildren().add(1, checkerBoard.getBoard());
        
        //create listener for size change
        ChangeListener<Number> listener = (ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            onResize();
        };
        
        //add listener to both dimensions for the VBox
        container.widthProperty().addListener(listener);
        container.heightProperty().addListener(listener);
    }   
    
    private void onResize(){
        CheckerBoard checkerBoard = new CheckerBoard(currentBoard.getNumRows(), currentBoard.getNumCols(), container.getWidth(), container.getHeight()-MENUBAR_HEIGHT, currentBoard.getLightColor(), currentBoard.getDarkColor());
        checkerBoard.build();
        currentBoard = checkerBoard;
        container.getChildren().add(1, checkerBoard.getBoard());
        container.getChildren().remove(2);
    }
    
    @FXML
    public void changeColorBlue(){
        if(currentBoard.getLightColor() == Color.RED){
            CheckerBoard checkerBoard = new CheckerBoard(currentBoard.getNumRows(), currentBoard.getNumCols(), currentBoard.getWidth(), currentBoard.getHeight(), Color.SKYBLUE, Color.DARKBLUE);
            checkerBoard.build();
            currentBoard = checkerBoard;
            container.getChildren().add(1, checkerBoard.getBoard());
            container.getChildren().remove(2);
        }
    }
    
    @FXML
    public void changeColorDefault(){
        if(currentBoard.getLightColor() == Color.LIGHTBLUE){ 
            CheckerBoard checkerBoard = new CheckerBoard(currentBoard.getNumRows(), currentBoard.getNumCols(), currentBoard.getWidth(), currentBoard.getHeight());
            checkerBoard.build();
            currentBoard = checkerBoard;
            container.getChildren().add(1, checkerBoard.getBoard());
            container.getChildren().remove(2); //remove old board
        }
    }
    
    private void changeBoardSize(int size){
        CheckerBoard checkerBoard = new CheckerBoard(size, size, currentBoard.getWidth(), currentBoard.getHeight(), currentBoard.getLightColor(), currentBoard.getDarkColor());
        checkerBoard.build();
        currentBoard = checkerBoard;
        container.getChildren().add(1, checkerBoard.getBoard());
        container.getChildren().remove(2);
    }
}

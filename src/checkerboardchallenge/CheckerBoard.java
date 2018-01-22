/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboardchallenge;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author loganharrison
 */
public class CheckerBoard {
    private AnchorPane board = null;
    private int numRows;
    private int numCols;
    private double boardWidth;
    private double boardHeight;
    private double rectWidth;
    private double rectHeight;
    private Color lightColor = Color.RED;
    private Color darkColor = Color.BLACK;
    
    public CheckerBoard(int numRows, int numCols,
                        double boardWidth, double boardHeight){
        this.numRows = numRows;
        this.numCols = numCols;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        rectWidth = Math.ceil(boardWidth/numCols);
        rectHeight = Math.ceil(boardHeight/numRows);
    }
    
    public CheckerBoard(int numRows, int numCols,
                        double boardWidth, double boardHeight,
                        Color lightColor, Color darkColor){
        this(numRows, numCols, boardWidth, boardHeight);
        this.lightColor = lightColor;
        this.darkColor = darkColor;
    }
    
    public void build(){
        //ASK ABOUT THIS RETURNING VOID COMPARED TO ANCHORPANE
        GridPane gridPane = new GridPane();
        for(int row = 0; row < numRows; row++){
            for(int col = 0; col < numCols; col++){
                gridPane.add(new Rectangle(rectWidth, rectHeight, (col+row)%2 == 0 ? lightColor : darkColor), col, row);
            }
        }
        AnchorPane anchorPane = new AnchorPane(gridPane);
        this.board = anchorPane;
    }
    
    public AnchorPane getBoard(){
        return board;
    }
    
    public int getNumRows(){
        return numRows;
    }
    
    public int getNumCols(){
        return numCols;
    }
    
    public double getWidth(){
        return boardWidth;
    }
    
    public double getHeight(){
        return boardHeight;
    }
    
    public Color getLightColor(){
        return lightColor;
    }
    
    public Color getDarkColor(){
        return darkColor;
    }
    
    public double getRectangleWidth(){
        return rectWidth;
    }
    
    public double getRectangleHeight(){
        return rectHeight;
    }
}

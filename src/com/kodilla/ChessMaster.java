package com.kodilla;

import com.kodilla.Figures.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class ChessMaster extends Application {

    private Image imageBack = new Image("file:resources/chessBoard.gif");

    private Board board = new Board();
    private int selectedCol = -1;
    private int selectedRow = -1;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageBack, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);


        int columnAmount = 8;
        int rowAmount = 8;

        GridPane grid = new GridPane();

        for (int i = 0; i < columnAmount; i++) {
            grid.getColumnConstraints().add(new ColumnConstraints(83));
        }

        for (int i = 0; i < rowAmount; i++) {
            grid.getRowConstraints().add(new RowConstraints(83 ));
        }

        grid.setAlignment(Pos.CENTER);
        grid.setBackground(background);
        primaryStage.setResizable(false);

        board.initBoard();

        board.setGrid(grid);
        board.refreshGrid();

        grid.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            int col = (int)e.getX()/83 -1;
            int row = (int)e.getY()/83 -1;
            actionClick(grid, col, row);
        });


        Scene scene = new Scene(grid, 800, 800, Color.WHITE);

        primaryStage.setTitle("ChessMaster");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void actionClick(GridPane grid, int col, int row) {
        if (!(board.getFigure(col,row) instanceof None) && notOpponentFigure(board.getFigure(col,row).getFigureColour())) {
                selectedCol = col;
                selectedRow = row;
        } else {
            if(selectedCol != -1 && selectedRow != -1)
                board.move(selectedCol, selectedRow, col, row);
            selectedCol = -1;
            selectedRow = -1;
        }
        board.refreshGrid();
        board.highlightField(grid, col, row);
    }

    private boolean notOpponentFigure(FigureColour figureColour) {
        if(selectedCol==-1){
            return true;
        }
        if (board.getFigure(selectedCol, selectedRow).getFigureColour() == figureColour) {
            return true;
        }
        return false;
    }

}
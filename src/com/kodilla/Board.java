package com.kodilla;

import com.kodilla.Figures.*;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<BoardRow> rows;
    private Player currentPlayer;
    private GridPane grid;
    private FigureColour whoMoves = FigureColour.WHITE;

    public Board() {
        rows = new ArrayList<>();
        for (int n=0; n<8;n++)
            rows.add(new BoardRow());
    }
    public Figure getFigure(int col, int row){
        return rows.get(row).getCols().get(col);
    }
    public void setFigure(int col, int row, Figure figure){
        rows.get(row).getCols().add(col,figure);
        rows.get(row).getCols().remove(col+1);
    }

    public void setGrid(GridPane grid) {
        this.grid=grid;
    }

    public void refreshGrid() {
        grid.getChildren().clear();
        for(int row=0;row<8;row++){
            for(int col=0;col<8;col++){
                Figure figure = getFigure(col,row);
                if(!(figure instanceof None)) {
                    grid.add(figure.getImage(), col, row);
                    GridPane.setHalignment(figure.getImage(), HPos.CENTER);
                    GridPane.setValignment(figure.getImage(), VPos.CENTER);
                }
            }
        }
    }

    public void move(int col1, int row1, int col2, int row2) {
        Figure figure = getFigure(col1, row1);
        int deltaCol = col2-col1;
        int deltaRow = row2-row1;
        if (figure.getFigureColour() != whoMoves)
            return;
        if (getFigure(col2, row2).getFigureColour() == opponentMove(whoMoves)) {
            if (figure.getPossibleMoves().iterator().next().isMoveOver()) {
                if(checkPossibleMoves(figure,deltaCol,deltaRow,true)){
                    makeAMove(col1,row1,col2,row2,figure);
                }
            } else {
                if(isMoveOverFalse(col1,row1,col2,row2,figure,deltaCol,deltaRow,true)){
                    makeAMove(col1,row1,col2,row2,figure);
                }
            }
        } else {
            if (figure.getPossibleMoves().iterator().next().isMoveOver()) {
                if(checkPossibleMoves(figure,deltaCol,deltaRow,false)){
                    makeAMove(col1,row1,col2,row2,figure);
                }
            } else {
                if(isMoveOverFalse(col1,row1,col2,row2,figure,deltaCol,deltaRow,false)){
                    makeAMove(col1,row1,col2,row2,figure);
                }
            }
        }
    }

    public boolean checkPossibleMoves(Figure figure, int deltaCol, int deltaRow, boolean isBreak){
        for (int k = 0; k < figure.getPossibleMoves().size(); k++) {
            if (deltaCol == figure.getPossibleMoves().get(k).getDeltaX() && deltaRow == figure.getPossibleMoves().get(k).getDeltaY() && isBreak==(figure.getPossibleMoves().get(k).getMoveAction()==MoveAction.BREAK)) {
                return true;
            }
        }
        return false;
    }

    public boolean isMoveOverFalse(int col1, int row1, int col2, int row2, Figure figure, int deltaCol, int deltaRow, boolean isBreak) {
        if (firstMove(col1, row1)) {
            if(pathIsClear(col1,row1,col2,row2)){
                return checkPossibleMoves(figure,deltaCol,deltaRow,isBreak);
            }
        } else {
            for (int l = 0; l < figure.getPossibleMoves().size()-1; l++) {
                if (deltaCol == figure.getPossibleMoves().get(l).getDeltaX() && deltaRow == figure.getPossibleMoves().get(l).getDeltaY()&& isBreak==(figure.getPossibleMoves().get(l).getMoveAction()==MoveAction.BREAK)) {
                    if (pathIsClear(col1, row1, col2, row2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void makeAMove(int col1, int row1, int col2, int row2, Figure figure){
        setFigure(col2, row2, figure);
        setFigure(col1, row1, new None());
        whoMoves = opponentMove(whoMoves);
        System.out.println(whoMoves);
    }


    public boolean firstMove (int col1, int row1){
        if(getFigure(col1,row1).isFirstMove()){
            getFigure(col1,row1).setFirstMove(false);
            return true;
        }
        return false;
    }

    public FigureColour opponentMove(FigureColour whoMoves) {
        return (whoMoves==FigureColour.WHITE) ? FigureColour.BLACK : FigureColour.WHITE;
    }

    private boolean pathIsClear(int col1, int row1, int col2, int row2) {
        boolean result = true;
        int deltaCol=col2-col1;
        int deltaRow=row2-row1;
        int steps=(Math.abs(deltaCol)>Math.abs(deltaRow)) ? Math.abs(deltaCol) : Math.abs(deltaRow);
        for(int n = 1;n<steps;n++){
            int tempCol = col1+(deltaCol/steps)*n;
            int tempRow = row1+(deltaRow/steps)*n;
            if(!(getFigure(tempCol,tempRow) instanceof None)){
                result = false;
            }
        }
        return result;
    }


    public void highlightField(GridPane grid, int col, int row) {
        Figure figure = getFigure(col, row);
        if (!figure.getFigureColour().equals(FigureColour.NONE) && !figure.getFigureColour().equals(opponentMove(whoMoves))) {
            grid.getChildren().remove(figure.getImage());
            Rectangle r = new Rectangle();
            r.setHeight(83);
            r.setWidth(83);
            r.setFill(Color.BURLYWOOD);

            grid.add(r, col, row);
            GridPane.setHalignment(r, HPos.CENTER);
            GridPane.setValignment(r, VPos.CENTER);
            grid.add(figure.getImage(), col, row);
        }
    }

    public void initBoard() {
        setFigure(0, 6, new Pawn(FigureColour.WHITE));
        setFigure(1, 6, new Pawn(FigureColour.WHITE));
        setFigure(2, 6, new Pawn(FigureColour.WHITE));
        setFigure(3, 6, new Pawn(FigureColour.WHITE));
        setFigure(4, 6, new Pawn(FigureColour.WHITE));
        setFigure(5, 6, new Pawn(FigureColour.WHITE));
        setFigure(6, 6, new Pawn(FigureColour.WHITE));
        setFigure(7, 6, new Pawn(FigureColour.WHITE));


        setFigure(0, 1, new Pawn(FigureColour.BLACK));
        setFigure(1, 1, new Pawn(FigureColour.BLACK));
        setFigure(2, 1, new Pawn(FigureColour.BLACK));
        setFigure(3, 1, new Pawn(FigureColour.BLACK));
        setFigure(4, 1, new Pawn(FigureColour.BLACK));
        setFigure(5, 1, new Pawn(FigureColour.BLACK));
        setFigure(6, 1, new Pawn(FigureColour.BLACK));
        setFigure(7, 1, new Pawn(FigureColour.BLACK));

        setFigure(0, 7, new Rook(FigureColour.WHITE));
        setFigure(7, 7, new Rook(FigureColour.WHITE));
        setFigure(0, 0, new Rook(FigureColour.BLACK));
        setFigure(7, 0, new Rook(FigureColour.BLACK));

        setFigure(1, 7, new Knight(FigureColour.WHITE));
        setFigure(6, 7, new Knight(FigureColour.WHITE));
        setFigure(1, 0, new Knight(FigureColour.BLACK));
        setFigure(6, 0, new Knight(FigureColour.BLACK));

        setFigure(2, 7, new Bishop(FigureColour.WHITE));
        setFigure(5, 7, new Bishop(FigureColour.WHITE));
        setFigure(2, 0, new Bishop(FigureColour.BLACK));
        setFigure(5, 0, new Bishop(FigureColour.BLACK));

        setFigure(3, 7, new Queen(FigureColour.WHITE));
        setFigure(3, 0, new Queen(FigureColour.BLACK));

        setFigure(4, 7, new King(FigureColour.WHITE));
        setFigure(4, 0, new King(FigureColour.BLACK));
    }
}

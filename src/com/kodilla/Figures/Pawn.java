package com.kodilla.Figures;

import com.kodilla.FigureColour;
import com.kodilla.MoveAction;
import com.kodilla.PossibleMove;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Pawn implements Figure {
    private ImageView image;
    private FigureColour colour;
    private boolean firstMove = true;
    private final Image whitePawn = new Image("file:resources/pawns/whitePawn.gif",80,80,true,true);
    private final Image blackPawn = new Image("file:resources/pawns/blackPawn.gif",80,80,true,true);

    public Pawn(FigureColour colour) {
        this.colour = colour;
        if(colour==FigureColour.WHITE)
            image = new ImageView(whitePawn);
        else
            image = new ImageView(blackPawn);
    }

    @Override
    public List<PossibleMove> getPossibleMoves() {
        List<PossibleMove> result = new ArrayList<>();
        if(colour==FigureColour.BLACK) {
            result.add(new PossibleMove(0, +1, MoveAction.NO_BREAK, false));
            result.add(new PossibleMove(-1, +1, MoveAction.BREAK, false));
            result.add(new PossibleMove(+1, +1, MoveAction.BREAK, false));
            result.add(new PossibleMove(0, +2, MoveAction.FIRST_MOVE, false));
        }else{
            result.add(new PossibleMove(0, -1, MoveAction.NO_BREAK, false));
            result.add(new PossibleMove(-1, -1, MoveAction.BREAK, false));
            result.add(new PossibleMove(+1, -1, MoveAction.BREAK, false));
            result.add(new PossibleMove(0, -2, MoveAction.FIRST_MOVE, false));
        }
        return result;
    }

    @Override
    public FigureColour getFigureColour() {
        return colour;
    }

    @Override
    public boolean isFirstMove() {
        return firstMove;
    }

    @Override
    public void setFirstMove(boolean firstMove) {
        this.firstMove = firstMove;
    }

    @Override
    public ImageView getImage() {
        return image;
    }

}

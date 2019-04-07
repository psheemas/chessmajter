package com.kodilla.Figures;

import com.kodilla.FigureColour;
import com.kodilla.MoveAction;
import com.kodilla.PossibleMove;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Bishop implements Figure  {
    private ImageView image;
    private FigureColour colour;
    private boolean firstMove = true;
    private final Image whiteBishop = new Image("file:resources/pawns/whiteBishop.gif",80,80,true,true);
    private final Image blackBishop = new Image("file:resources/pawns/blackBishop.gif",80,80,true,true);

    public Bishop(FigureColour colour) {
        this.colour = colour;
        if(colour==FigureColour.WHITE)
            image = new ImageView(whiteBishop);
        else
            image = new ImageView(blackBishop);
    }

    @Override
    public List<PossibleMove> getPossibleMoves() {
        List<PossibleMove> result = new ArrayList<>();
        for(int i=-8;i<8;i++) {
            result.add(new PossibleMove(i, i, MoveAction.NO_BREAK, false));
            result.add(new PossibleMove(-i, i, MoveAction.NO_BREAK, false));
            result.add(new PossibleMove(i, i, MoveAction.BREAK, false));
            result.add(new PossibleMove(-i, i, MoveAction.BREAK, false));
        }
        return result;
    }

    @Override
    public FigureColour getFigureColour() {
        return colour;
    }

    @Override
    public ImageView getImage() {
        return image;
    }

    @Override
    public boolean isFirstMove() {
        return firstMove;
    }

    @Override
    public void setFirstMove(boolean firstMove) {
        this.firstMove = firstMove;
    }



}

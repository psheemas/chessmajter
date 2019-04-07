package com.kodilla.Figures;

import com.kodilla.FigureColour;
import com.kodilla.MoveAction;
import com.kodilla.PossibleMove;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Knight implements Figure  {
    private ImageView image;
    private FigureColour colour;
    private boolean firstMove = true;
    private final Image whiteKnight = new Image("file:resources/pawns/whiteKnight.gif",80,80,true,true);
    private final Image blackKnight = new Image("file:resources/pawns/blackKnight.gif",80,80,true,true);

    public Knight(FigureColour colour) {
        this.colour = colour;
        if(colour==FigureColour.WHITE)
            image = new ImageView(whiteKnight);
        else
            image = new ImageView(blackKnight);
    }

    @Override
    public List<PossibleMove> getPossibleMoves() {
        List<PossibleMove> result = new ArrayList<>();
        result.add(new PossibleMove(+1, +2, MoveAction.NO_BREAK, true));
        result.add(new PossibleMove(-1, +2, MoveAction.NO_BREAK, true));
        result.add(new PossibleMove(+1, -2, MoveAction.NO_BREAK, true));
        result.add(new PossibleMove(-1, -2, MoveAction.NO_BREAK, true));
        result.add(new PossibleMove(+2, +1, MoveAction.NO_BREAK, true));
        result.add(new PossibleMove(-2, +1, MoveAction.NO_BREAK, true));
        result.add(new PossibleMove(-2, -1, MoveAction.NO_BREAK, true));
        result.add(new PossibleMove(+2, -1, MoveAction.NO_BREAK, true));
        result.add(new PossibleMove(+1, +2, MoveAction.BREAK, true));
        result.add(new PossibleMove(-1, +2, MoveAction.BREAK, true));
        result.add(new PossibleMove(+1, -2, MoveAction.BREAK, true));
        result.add(new PossibleMove(-1, -2, MoveAction.BREAK, true));
        result.add(new PossibleMove(+2, +1, MoveAction.BREAK, true));
        result.add(new PossibleMove(-2, +1, MoveAction.BREAK, true));
        result.add(new PossibleMove(-2, -1, MoveAction.BREAK, true));
        result.add(new PossibleMove(+2, -1, MoveAction.BREAK, true));

        return result;
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
    public FigureColour getFigureColour() {
        return colour;
    }

    @Override
    public ImageView getImage() {
        return image;
    }

}

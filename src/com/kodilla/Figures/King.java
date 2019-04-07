package com.kodilla.Figures;

import com.kodilla.FigureColour;
import com.kodilla.MoveAction;
import com.kodilla.PossibleMove;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class King implements Figure  {
    private ImageView image;
    private FigureColour colour;
    private boolean firstMove = true;
    private final Image whiteKing = new Image("file:resources/pawns/whiteKing.gif",80,80,true,true);
    private final Image blackKing = new Image("file:resources/pawns/blackKing.gif",80,80,true,true);


    public King(FigureColour colour) {
        this.colour = colour;
        if(colour==FigureColour.WHITE)
            image = new ImageView(whiteKing);
        else
            image = new ImageView(blackKing);
    }

    @Override
    public List<PossibleMove> getPossibleMoves() {
        List<PossibleMove> result = new ArrayList<>();

        result.add(new PossibleMove(+1, +1, MoveAction.NO_BREAK, false));
        result.add(new PossibleMove(-1, +1, MoveAction.NO_BREAK, false));
        result.add(new PossibleMove(-1, -1, MoveAction.NO_BREAK, false));
        result.add(new PossibleMove(+1, -1, MoveAction.NO_BREAK, false));
        result.add(new PossibleMove(+1, 0, MoveAction.NO_BREAK, false));
        result.add(new PossibleMove(-1, 0, MoveAction.NO_BREAK, false));
        result.add(new PossibleMove(0, -1, MoveAction.NO_BREAK, false));
        result.add(new PossibleMove(0, +1, MoveAction.NO_BREAK, false));
        result.add(new PossibleMove(+1, +1, MoveAction.BREAK, false));
        result.add(new PossibleMove(-1, +1, MoveAction.BREAK, false));
        result.add(new PossibleMove(-1, -1, MoveAction.BREAK, false));
        result.add(new PossibleMove(+1, -1, MoveAction.BREAK, false));
        result.add(new PossibleMove(+1, 0, MoveAction.BREAK, false));
        result.add(new PossibleMove(-1, 0, MoveAction.BREAK, false));
        result.add(new PossibleMove(0, -1, MoveAction.BREAK, false));
        result.add(new PossibleMove(0, +1, MoveAction.BREAK, false));

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

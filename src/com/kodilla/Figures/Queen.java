package com.kodilla.Figures;

import com.kodilla.FigureColour;
import com.kodilla.MoveAction;
import com.kodilla.PossibleMove;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Queen implements Figure  {
    private ImageView image;
    private FigureColour colour;
    private boolean firstMove = true;
    private final Image whiteQueen = new Image("file:resources/pawns/whiteQueen.gif",80,80,true,true);
    private final Image blackQueen = new Image("file:resources/pawns/blackQueen.gif",80,80,true,true);

    public Queen(FigureColour colour) {
        this.colour = colour;
        if(colour==FigureColour.WHITE)
            image = new ImageView(whiteQueen);
        else
            image = new ImageView(blackQueen);
    }

    @Override
    public List<PossibleMove> getPossibleMoves() {
        List<PossibleMove> result = new ArrayList<>();

        for(int i=-8;i<8;i++){
            result.add(new PossibleMove(0, i, MoveAction.NO_BREAK, false));
            result.add(new PossibleMove(i, 0, MoveAction.NO_BREAK, false));
            result.add(new PossibleMove(i, i, MoveAction.NO_BREAK, false));
            result.add(new PossibleMove(-i, i, MoveAction.NO_BREAK, false));
            result.add(new PossibleMove(0, i, MoveAction.BREAK, false));
            result.add(new PossibleMove(i, 0, MoveAction.BREAK, false));
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

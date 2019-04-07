package com.kodilla.Figures;

import com.kodilla.FigureColour;
import com.kodilla.PossibleMove;
import javafx.scene.image.ImageView;

import java.util.List;

import static com.kodilla.FigureColour.NONE;

public class None implements Figure{

    @Override
    public List<PossibleMove> getPossibleMoves() {
        return null;
    }

    @Override
    public FigureColour getFigureColour() {
        return NONE;
    }

    @Override
    public ImageView getImage() {
        return null;
    }

    @Override
    public boolean isFirstMove() {
        return false;
    }

    @Override
    public void setFirstMove(boolean firstMove) {
    }

}

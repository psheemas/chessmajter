package com.kodilla.Figures;


import com.kodilla.FigureColour;
import com.kodilla.PossibleMove;
import javafx.scene.image.ImageView;

import java.util.List;

public interface Figure {
    List<PossibleMove> getPossibleMoves();
    FigureColour getFigureColour();
    ImageView getImage();
    boolean isFirstMove();
    void setFirstMove(boolean firstMove);
}

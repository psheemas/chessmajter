package com.kodilla;

import com.kodilla.Figures.Figure;
import com.kodilla.Figures.None;

import java.util.ArrayList;
import java.util.List;

public class BoardRow {
    private List<Figure> cols;

    public List<Figure> getCols() {
        return cols;
    }

    public BoardRow() {
        cols = new ArrayList<>();
        for(int n=0;n<8;n++)
            cols.add(new None());
    }
}

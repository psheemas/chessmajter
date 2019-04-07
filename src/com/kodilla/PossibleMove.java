package com.kodilla;

public class PossibleMove {
    private int deltaX;
    private int deltaY;
    private MoveAction moveAction;
    private boolean moveOver;

    public PossibleMove(int deltaX, int deltaY, MoveAction moveAction, boolean moveOver) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
        this.moveAction = moveAction;
        this.moveOver = moveOver;
    }

    public int getDeltaX() {
        return deltaX;
    }

    public int getDeltaY() {
        return deltaY;
    }

    public MoveAction getMoveAction() {
        return moveAction;
    }

    public boolean isMoveOver() {
        return moveOver;
    }
}

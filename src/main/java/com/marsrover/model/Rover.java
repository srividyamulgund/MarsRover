package com.marsrover.model;

public class Rover {

    private int X;
    private int Y;
    private char orientation;

    public Rover(int x, int y, char orientation) {
        this.X = x;
        this.Y = y;
        this.orientation = orientation;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public char getOrientation() {
        return orientation;
    }

    public void setOrientation(char orientation) {
        this.orientation = orientation;
    }
}
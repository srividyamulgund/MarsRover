package com.marsrover.model;

public class Rover {

    private int X;
    private int Y;
    private String name;
    private char orientation;

    public Rover(int x, int y, String name, char orientation) {
        this.X = x;
        this.Y = y;
        this.name = name;
        this.orientation = orientation;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
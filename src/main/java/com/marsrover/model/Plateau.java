package com.marsrover.model;


import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Plateau {
    private int x;
    private int y;

    public static Map<String, Point> getRoverMap() {
        return roverMap;
    }

    private static Map<String, Point> roverMap = new HashMap<>();

    public Plateau(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isValidX(int x){
        return x > 0;
    }
    public boolean isValidY(int y) {
        return y > 0;
    }

    public static void placeRovers(Rover rover1, Rover rover2){

        if (roverMap.containsKey(rover1.getName())){
            roverMap.replace(rover1.getName(), new Point(rover1.getX(), rover1.getY()));
        }
        else{
            roverMap.put("Rover1", new Point(rover1.getX(), rover1.getY()));
        }
        if (roverMap.containsKey(rover2.getName())){
            roverMap.replace(rover2.getName(), new Point(rover2.getX(), rover2.getY()));
        }
        else{
            roverMap.put("Rover2", new Point(rover2.getX(), rover2.getY()));
        }
    }
}

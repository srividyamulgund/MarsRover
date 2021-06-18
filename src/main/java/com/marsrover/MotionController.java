package com.marsrover;

import com.marsrover.model.Plateau;
import com.marsrover.model.Rover;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MotionController {
    Plateau plateau;
    Rover rover;

    public MotionController(Plateau plateau, Rover rover) {
        this.plateau = plateau;
        this.rover = rover;
    }

    public boolean isRoverPositionInBounds(Plateau plateau, Rover rover) {

        return (rover.getX() <= plateau.getX()) && (rover.getX() >= 0 && rover.getY() >= 0)
                && (rover.getY() <= plateau.getY());
    }

    public boolean areRoversColliding(Plateau plateau, Rover rover) {

        Map<String, Point> roversPlacement = new HashMap<>(Plateau.getRoverMap());

        for(String key : roversPlacement.keySet()){
            if(!key.equals(rover.getName())){
                Point otherRover = roversPlacement.get(key);
                if(otherRover.x == rover.getX() && otherRover.y == rover.getY()){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isInstructionValid(String instruction) {

        for(int i = 0; i < instruction.length(); i++) {
            if (!(instruction.charAt(i) == 'L' || instruction.charAt(i) == 'R' || instruction.charAt(i) == 'M' )) {
                return false;
            }
        }
        return true;
    }

    public Rover executeInstruction(String instruction) {

        if (!isRoverPositionInBounds(plateau, rover)) {
            throw new IllegalArgumentException("Invalid Rover position for the plateau");
        }

        if(areRoversColliding(plateau, rover)) {
            throw new IllegalArgumentException("Rovers colliding for the plateau");
        }

        if (instruction != null) {
            if (!isInstructionValid(instruction)) {
                throw new IllegalArgumentException("Invalid instruction");
            }
            for(int i = 0; i < instruction.length(); i++) {
                if (instruction.charAt(i) == 'L') {

                    if (rover.getOrientation() == 'N') {
                        rover.setOrientation('W');
                    }
                    else if (rover.getOrientation() == 'E') {
                        rover.setOrientation('N');
                    }
                    else if(rover.getOrientation()=='W'){
                        rover.setOrientation('S');
                    }
                    else if(rover.getOrientation()=='S'){
                        rover.setOrientation('E');
                    }
                }
                else if(instruction.charAt(i)=='R') {

                    if (rover.getOrientation() == 'N') {
                        rover.setOrientation('E');
                    }
                    else if(rover.getOrientation()=='E'){
                        rover.setOrientation('S');
                    }
                    else if(rover.getOrientation()=='W'){
                        rover.setOrientation('N');
                    }
                    else if(rover.getOrientation()=='S'){
                        rover.setOrientation('W');
                    }
                }
                else if(instruction.charAt(i)=='M') {
                    if(rover.getOrientation() == 'E'){
                        rover.setX(rover.getX()+1);
                        rover.setY(rover.getY());
                        if(!isRoverPositionInBounds(plateau, rover)) {
                            throw new IllegalArgumentException("Invalid Rover position for the plateau");
                        }
                        if(areRoversColliding(plateau, rover)) {
                            throw new IllegalArgumentException("Rovers colliding for the plateau");
                        }
                    }
                    else if (rover.getOrientation() == 'W'){
                        rover.setX(rover.getX()-1);
                        rover.setY(rover.getY());
                        if(!isRoverPositionInBounds(plateau, rover)) {
                            throw new IllegalArgumentException("Invalid Rover position for the plateau");
                        }
                        if(areRoversColliding(plateau, rover)) {
                            throw new IllegalArgumentException("Rovers colliding for the plateau");
                        }
                    }
                    else if (rover.getOrientation() == 'N'){
                        rover.setX(rover.getX());
                        rover.setY(rover.getY()+1);
                        if(!isRoverPositionInBounds(plateau, rover)) {
                            throw new IllegalArgumentException("Invalid Rover position for the plateau");
                        }
                        if(areRoversColliding(plateau, rover)) {
                            throw new IllegalArgumentException("Rovers colliding for the plateau");
                        }
                    }
                    else if (rover.getOrientation() == 'S'){
                        rover.setX(rover.getX());
                        rover.setY(rover.getY()-1);
                        if(!isRoverPositionInBounds(plateau, rover)) {
                            throw new IllegalArgumentException("Invalid Rover position for the plateau");
                        }
                        if(areRoversColliding(plateau, rover)) {
                            throw new IllegalArgumentException("Rovers colliding for the plateau");
                        }
                    }
                }
            }
        }
        return rover;
    }
}
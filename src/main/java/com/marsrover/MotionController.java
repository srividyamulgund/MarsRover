package com.marsrover;

import com.marsrover.model.Plateau;
import com.marsrover.model.Rover;

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

        if (instruction != null) {
            if (!isInstructionValid(instruction)) {
                throw new IllegalArgumentException("Invalid instruction");
            }
        }
        return rover;
    }
}
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
}
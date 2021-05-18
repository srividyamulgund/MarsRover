package com.marsrover;

import com.marsrover.model.Plateau;
import com.marsrover.model.Rover;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MotionControllerTest {

    @Test
    @DisplayName("returns false if Rover is outside the Plateau")
    public void testRover1Position() {
        Plateau plateau = new Plateau(5, 5);
        Rover rover1 = new Rover(1, 2, 'N');
        MotionController motionControllerRover1 = new MotionController(plateau, rover1);
        Assertions.assertTrue(motionControllerRover1.isRoverPositionInBounds(plateau, rover1), "Rover cannot be out of the Plateau");
    }
}
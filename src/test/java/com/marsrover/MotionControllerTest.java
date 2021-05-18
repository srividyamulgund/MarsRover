package com.marsrover;

import com.marsrover.model.Plateau;
import com.marsrover.model.Rover;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MotionControllerTest {

    @Test
    @DisplayName("returns true if Rover is inside the Plateau")
    public void testRoverPositionInsidePlateau() {
        Plateau plateau = new Plateau(5, 5);
        Rover rover1 = new Rover(1, 2, 'N');
        MotionController motionControllerRover1 = new MotionController(plateau, rover1);
        Assertions.assertTrue(motionControllerRover1.isRoverPositionInBounds(plateau, rover1), "Rover cannot be out of the Plateau");
    }

    @Test
    @DisplayName("returns false if Rover is outside the Plateau")
    public void testRoverPositionOutsidePlateau() {
        Plateau plateau = new Plateau(5, 5);
        Rover rover1 = new Rover(7, 7, 'N');
        MotionController motionControllerRover1 = new MotionController(plateau, rover1);
        Assertions.assertFalse(motionControllerRover1.isRoverPositionInBounds(plateau, rover1), "Rover cannot be out of the Plateau");
    }

    @Test
    @DisplayName("returns error message")
    public void testInvalidInstructions() {
        Plateau plateau = new Plateau(5,5);
        Rover rover = new Rover(3,3,'E');
        String roverInstruction = "ABCDEFGH";
        Rover rover1Expected = new Rover(5,1,'E');
        Assertions.assertThrows(Exception.class, () -> {
            MotionController motionControllerRover = new MotionController(plateau, rover);
            Rover rover1Final = motionControllerRover.executeInstruction(roverInstruction);

        });
    }

    @Test
    @DisplayName("returns valid orientation")
    public void testRoverLeftNorthOrientation() {
        Plateau plateau = new Plateau(5,5);
        Rover rover1 = new Rover(1,2,'N');
        String rover1Instruction = "L";
        MotionController motionControllerRover1 = new MotionController(plateau, rover1);
        Rover rover1Expected = new Rover(1,2,'W');
        Rover rover1Final = motionControllerRover1.executeInstruction(rover1Instruction);
        assertEquals(rover1Expected.getOrientation(),rover1Final.getOrientation(), "Rover final position mismatch" );
        assertEquals(rover1Expected.getX(),rover1Final.getX(), "Rover final position mismatch" );
        assertEquals(rover1Expected.getY(),rover1Final.getY(), "Rover final position mismatch" );
    }
    @Test
    @DisplayName("returns valid orientation")
    public void testRoverLeftEastOrientation() {
        Plateau plateau = new Plateau(5,5);
        Rover rover1 = new Rover(1,2,'E');
        String rover1Instruction = "L";
        MotionController motionControllerRover1 = new MotionController(plateau, rover1);
        Rover rover1Expected = new Rover(1,2,'N');
        Rover rover1Final = motionControllerRover1.executeInstruction(rover1Instruction);
        assertEquals(rover1Expected.getOrientation(),rover1Final.getOrientation(), "Rover final position mismatch" );
        assertEquals(rover1Expected.getX(),rover1Final.getX(), "Rover final position mismatch" );
        assertEquals(rover1Expected.getY(),rover1Final.getY(), "Rover final position mismatch" );
    }
    @Test
    @DisplayName("returns valid orientation")
    public void testRoverLeftWestOrientation() {
        Plateau plateau = new Plateau(5,5);
        Rover rover1 = new Rover(1,2,'W');
        String rover1Instruction = "L";
        MotionController motionControllerRover1 = new MotionController(plateau, rover1);
        Rover rover1Expected = new Rover(1,2,'S');
        Rover rover1Final = motionControllerRover1.executeInstruction(rover1Instruction);
        assertEquals(rover1Expected.getOrientation(),rover1Final.getOrientation(), "Rover final position mismatch" );
        assertEquals(rover1Expected.getX(),rover1Final.getX(), "Rover final position mismatch" );
        assertEquals(rover1Expected.getY(),rover1Final.getY(), "Rover final position mismatch" );
    }
    @Test
    @DisplayName("returns valid orientation")
    public void testRoverLeftSouthOrientation() {
        Plateau plateau = new Plateau(5,5);
        Rover rover1 = new Rover(1,2,'S');
        String rover1Instruction = "L";
        MotionController motionControllerRover1 = new MotionController(plateau, rover1);
        Rover rover1Expected = new Rover(1,2,'E');
        Rover rover1Final = motionControllerRover1.executeInstruction(rover1Instruction);
        assertEquals(rover1Expected.getOrientation(),rover1Final.getOrientation(), "Rover final position mismatch" );
        assertEquals(rover1Expected.getX(),rover1Final.getX(), "Rover final position mismatch" );
        assertEquals(rover1Expected.getY(),rover1Final.getY(), "Rover final position mismatch" );
    }
    @Test
    @DisplayName("returns valid orientation")
    public void testRoverRightNorthOrientation() {
        Plateau plateau = new Plateau(5,5);
        Rover rover1 = new Rover(1,2,'N');
        String rover1Instruction = "R";
        MotionController motionControllerRover1 = new MotionController(plateau, rover1);
        Rover rover1Expected = new Rover(1,2,'E');
        Rover rover1Final = motionControllerRover1.executeInstruction(rover1Instruction);
        assertEquals(rover1Expected.getOrientation(),rover1Final.getOrientation(), "Rover final position mismatch" );
        assertEquals(rover1Expected.getX(),rover1Final.getX(), "Rover final position mismatch" );
        assertEquals(rover1Expected.getY(),rover1Final.getY(), "Rover final position mismatch" );
    }
    @Test
    @DisplayName("returns valid orientation")
    public void testRoverRightEastOrientation() {
        Plateau plateau = new Plateau(5,5);
        Rover rover1 = new Rover(1,2,'E');
        String rover1Instruction = "R";
        MotionController motionControllerRover1 = new MotionController(plateau, rover1);
        Rover rover1Expected = new Rover(1,2,'S');
        Rover rover1Final = motionControllerRover1.executeInstruction(rover1Instruction);
        assertEquals(rover1Expected.getOrientation(),rover1Final.getOrientation(), "Rover final position mismatch" );
        assertEquals(rover1Expected.getX(),rover1Final.getX(), "Rover final position mismatch" );
        assertEquals(rover1Expected.getY(),rover1Final.getY(), "Rover final position mismatch" );
    }
}
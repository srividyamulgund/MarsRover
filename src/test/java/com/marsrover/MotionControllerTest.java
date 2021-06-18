package com.marsrover;

import com.marsrover.model.Plateau;
import com.marsrover.model.Rover;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class MotionControllerTest {

    @Test
    @DisplayName("returns true if Rover is inside the Plateau")
    public void testRoverPositionInsidePlateau() {
        Rover rover1 = new Rover(1, 2, "Rover1", 'N');
        Rover rover2 = new Rover(4, 4, "Rover2", 'N');
        Plateau plateau = new Plateau(5, 5);
        Plateau.placeRovers(rover1, rover2);
        MotionController motionControllerRover1 = new MotionController(plateau, rover1);
        assertTrue(motionControllerRover1.isRoverPositionInBounds(plateau, rover1), "Rover cannot be out of the Plateau");
    }

    @Test
    @DisplayName("returns false if Rover is outside the Plateau")
    public void testRoverPositionOutsidePlateau() {

        Rover rover1 = new Rover(7, 7, "Rover1", 'N');
        Rover rover2 = new Rover(4, 4, "Rover2", 'N');

        Plateau plateau = new Plateau(5, 5);
        Plateau.placeRovers(rover1, rover2);
        MotionController motionControllerRover1 = new MotionController(plateau, rover1);
        Assertions.assertFalse(motionControllerRover1.isRoverPositionInBounds(plateau, rover1), "Rover cannot be out of the Plateau");
    }

    @Test
    @DisplayName("returns error message")
    public void testInvalidInstructions() {
        Rover rover1 = new Rover(3,3, "Rover1", 'E');
        Rover rover2 = new Rover(4, 4, "Rover2", 'N');

        Plateau plateau = new Plateau(5, 5);
        Plateau.placeRovers(rover1, rover2);

        String roverInstruction = "ABCDEFGH";
        //Rover rover1Expected = new Rover(5,1,'E');
        Assertions.assertThrows(Exception.class, () -> {
            MotionController motionControllerRover = new MotionController(plateau, rover1);
            motionControllerRover.executeInstruction(roverInstruction);

        });
    }

    @Test
    @DisplayName("returns valid orientation")
    public void testRoverLeftNorthOrientation() {

        Rover rover1 = new Rover(1,2, "Rover1", 'N');
        Rover rover2 = new Rover(4, 4, "Rover2", 'N');

        Plateau plateau = new Plateau(5, 5);
        Plateau.placeRovers(rover1, rover2);

        String rover1Instruction = "L";
        MotionController motionControllerRover1 = new MotionController(plateau, rover1);
        Rover rover1Expected = new Rover(1,2, "Rover1Expected", 'W');
        Rover rover1Final = motionControllerRover1.executeInstruction(rover1Instruction);
        assertEquals(rover1Expected.getOrientation(),rover1Final.getOrientation(), "Rover final orientation mismatch" );
        assertEquals(rover1Expected.getX(),rover1Final.getX(), "Rover X final position mismatch" );
        assertEquals(rover1Expected.getY(),rover1Final.getY(), "Rover Y final position mismatch" );
    }
    @Test
    @DisplayName("returns valid orientation")
    public void testRoverLeftEastOrientation() {

        Rover rover1 = new Rover(1,2, "Rover1", 'E');
        Rover rover2 = new Rover(4, 4, "Rover2", 'N');

        Plateau plateau = new Plateau(5, 5);
        Plateau.placeRovers(rover1, rover2);

        String rover1Instruction = "L";
        MotionController motionControllerRover1 = new MotionController(plateau, rover1);
        Rover rover1Expected = new Rover(1,2, "Rover1Expected", 'N');
        Rover rover1Final = motionControllerRover1.executeInstruction(rover1Instruction);
        assertEquals(rover1Expected.getOrientation(),rover1Final.getOrientation(), "Rover final orientation mismatch" );
        assertEquals(rover1Expected.getX(),rover1Final.getX(), "Rover X final position mismatch" );
        assertEquals(rover1Expected.getY(),rover1Final.getY(), "Rover Y final position mismatch" );
    }
    @Test
    @DisplayName("returns valid orientation")
    public void testRoverLeftWestOrientation() {

        Rover rover1 = new Rover(1,2, "Rover1", 'W');
        Rover rover2 = new Rover(4, 4, "Rover2", 'N');

        Plateau plateau = new Plateau(5, 5);
        Plateau.placeRovers(rover1, rover2);

        String rover1Instruction = "L";
        MotionController motionControllerRover1 = new MotionController(plateau, rover1);
        Rover rover1Expected = new Rover(1,2, "Rover1Expected", 'S');
        Rover rover1Final = motionControllerRover1.executeInstruction(rover1Instruction);
        assertEquals(rover1Expected.getOrientation(),rover1Final.getOrientation(), "Rover final orientation mismatch" );
        assertEquals(rover1Expected.getX(),rover1Final.getX(), "Rover X final position mismatch" );
        assertEquals(rover1Expected.getY(),rover1Final.getY(), "Rover Y final position mismatch" );
    }
    @Test
    @DisplayName("returns valid orientation")
    public void testRoverLeftSouthOrientation() {

        Rover rover1 = new Rover(1,2, "Rover1", 'S');
        Rover rover2 = new Rover(4, 4, "Rover2", 'N');

        Plateau plateau = new Plateau(5, 5);
        Plateau.placeRovers(rover1, rover2);

        String rover1Instruction = "L";
        MotionController motionControllerRover1 = new MotionController(plateau, rover1);
        Rover rover1Expected = new Rover(1,2, "Rover1Expected", 'E');
        Rover rover1Final = motionControllerRover1.executeInstruction(rover1Instruction);
        assertEquals(rover1Expected.getOrientation(),rover1Final.getOrientation(), "Rover final orientation mismatch" );
        assertEquals(rover1Expected.getX(),rover1Final.getX(), "Rover X final position mismatch" );
        assertEquals(rover1Expected.getY(),rover1Final.getY(), "Rover Y final position mismatch" );
    }
    @Test
    @DisplayName("returns valid orientation")
    public void testRoverRightNorthOrientation() {

        Rover rover1 = new Rover(1,2, "Rover1", 'N');
        Rover rover2 = new Rover(4, 4, "Rover2", 'N');

        Plateau plateau = new Plateau(5, 5);
        Plateau.placeRovers(rover1, rover2);

        String rover1Instruction = "R";
        MotionController motionControllerRover1 = new MotionController(plateau, rover1);
        Rover rover1Expected = new Rover(1,2, "Rover1Expected", 'E');
        Rover rover1Final = motionControllerRover1.executeInstruction(rover1Instruction);
        assertEquals(rover1Expected.getOrientation(),rover1Final.getOrientation(), "Rover final orientation mismatch" );
        assertEquals(rover1Expected.getX(),rover1Final.getX(), "Rover X final position mismatch" );
        assertEquals(rover1Expected.getY(),rover1Final.getY(), "Rover Y final position mismatch" );
    }
    @Test
    @DisplayName("returns valid orientation")
    public void testRoverRightEastOrientation() {

        Rover rover1 = new Rover(1,2, "Rover1", 'E');
        Rover rover2 = new Rover(4, 4, "Rover2", 'N');

        Plateau plateau = new Plateau(5, 5);
        Plateau.placeRovers(rover1, rover2);

        String rover1Instruction = "R";
        MotionController motionControllerRover1 = new MotionController(plateau, rover1);
        Rover rover1Expected = new Rover(1,2, "Rover1Expected", 'S');
        Rover rover1Final = motionControllerRover1.executeInstruction(rover1Instruction);
        assertEquals(rover1Expected.getOrientation(),rover1Final.getOrientation(), "Rover final orientation mismatch" );
        assertEquals(rover1Expected.getX(),rover1Final.getX(), "Rover X final position mismatch" );
        assertEquals(rover1Expected.getY(),rover1Final.getY(), "Rover Y final position mismatch" );
    }
    @Test
    @DisplayName("returns valid orientation")
    public void testRoverRightWestOrientation() {

        Rover rover1 = new Rover(1,2, "Rover1", 'W');
        Rover rover2 = new Rover(4, 4, "Rover2", 'N');

        Plateau plateau = new Plateau(5, 5);
        Plateau.placeRovers(rover1, rover2);

        String rover1Instruction = "R";
        MotionController motionControllerRover1 = new MotionController(plateau, rover1);
        Rover rover1Expected = new Rover(1,2, "Rover1Expected", 'N');
        Rover rover1Final = motionControllerRover1.executeInstruction(rover1Instruction);
        assertEquals(rover1Expected.getOrientation(),rover1Final.getOrientation(), "Rover final orientation mismatch" );
        assertEquals(rover1Expected.getX(),rover1Final.getX(), "Rover X final position mismatch" );
        assertEquals(rover1Expected.getY(),rover1Final.getY(), "Rover Y final position mismatch" );
    }
    @Test
    @DisplayName("returns valid orientation")
    public void testRoverRightSouthOrientation() {

        Rover rover1 = new Rover(1,2, "Rover1", 'S');
        Rover rover2 = new Rover(4, 4, "Rover2", 'N');

        Plateau plateau = new Plateau(5, 5);
        Plateau.placeRovers(rover1, rover2);

        String rover1Instruction = "R";
        MotionController motionControllerRover1 = new MotionController(plateau, rover1);
        Rover rover1Expected = new Rover(1,2, "Rover1Expected", 'W');
        Rover rover1Final = motionControllerRover1.executeInstruction(rover1Instruction);
        assertEquals(rover1Expected.getOrientation(),rover1Final.getOrientation(), "Rover final orientation mismatch" );
        assertEquals(rover1Expected.getX(),rover1Final.getX(), "Rover X final position mismatch" );
        assertEquals(rover1Expected.getY(),rover1Final.getY(), "Rover Y final position mismatch" );
    }
    @Test
    @DisplayName("returns valid orientation")
    public void testRoverMoveSouthOrientation() {

        Rover rover1 = new Rover(1,2, "Rover1", 'S');
        Rover rover2 = new Rover(4, 4, "Rover2", 'N');

        Plateau plateau = new Plateau(5, 5);
        Plateau.placeRovers(rover1, rover2);

        String rover1Instruction = "LM";
        MotionController motionControllerRover1 = new MotionController(plateau, rover1);
        Rover rover1Expected = new Rover(2,2, "Rover1Expected", 'E');
        Rover rover1Final = motionControllerRover1.executeInstruction(rover1Instruction);
        assertEquals(rover1Expected.getOrientation(),rover1Final.getOrientation(), "Rover final orientation mismatch" );
        assertEquals(rover1Expected.getX(),rover1Final.getX(), "Rover X final position mismatch" );
        assertEquals(rover1Expected.getY(),rover1Final.getY(), "Rover Y final position mismatch" );
    }
    @Test
    @DisplayName("returns valid orientation")
    public void testRoverMoveWesttOrientation() {

        Rover rover1 = new Rover(2,2, "Rover1", 'N');
        Rover rover2 = new Rover(4, 4, "Rover2", 'N');

        Plateau plateau = new Plateau(5, 5);
        Plateau.placeRovers(rover1, rover2);

        String rover1Instruction = "LM";
        MotionController motionControllerRover1 = new MotionController(plateau, rover1);
        Rover rover1Expected = new Rover(1,2, "Rover1Expected", 'W');
        Rover rover1Final = motionControllerRover1.executeInstruction(rover1Instruction);
        assertEquals(rover1Expected.getOrientation(),rover1Final.getOrientation(), "Rover final orientation mismatch" );
        assertEquals(rover1Expected.getX(),rover1Final.getX(), "Rover X final position mismatch" );
        assertEquals(rover1Expected.getY(),rover1Final.getY(), "Rover Y final position mismatch" );
    }
    @Test
    @DisplayName("returns valid orientation")
    public void testRoverMoveNorthOrientation() {

        Rover rover1 = new Rover(2,2, "Rover1", 'E');
        Rover rover2 = new Rover(4, 4, "Rover2", 'N');


        Plateau plateau = new Plateau(5, 5);
        Plateau.placeRovers(rover1, rover2);

        String rover1Instruction = "LM";
        MotionController motionControllerRover1 = new MotionController(plateau, rover1);
        Rover rover1Expected = new Rover(2,3, "Rover1Expected", 'N');
        Rover rover1Final = motionControllerRover1.executeInstruction(rover1Instruction);
        assertEquals(rover1Expected.getOrientation(),rover1Final.getOrientation(), "Rover final orientation mismatch" );
        assertEquals(rover1Expected.getX(),rover1Final.getX(), "Rover X final position mismatch" );
        assertEquals(rover1Expected.getY(),rover1Final.getY(), "Rover Y final position mismatch" );
    }
    @Test
    @DisplayName("returns valid orientation")
    public void testRoverMoveEastOrientation() {

        Rover rover1 = new Rover(2,2, "Rover1", 'S');
        Rover rover2 = new Rover(4, 4, "Rover2", 'N');

        Plateau plateau = new Plateau(5, 5);
        Plateau.placeRovers(rover1, rover2);

        String rover1Instruction = "LM";
        MotionController motionControllerRover1 = new MotionController(plateau, rover1);
        Rover rover1Expected = new Rover(3,2, "Rover1Expected", 'E');
        Rover rover1Final = motionControllerRover1.executeInstruction(rover1Instruction);
        assertEquals(rover1Expected.getOrientation(),rover1Final.getOrientation(), "Rover final orientation mismatch" );
        assertEquals(rover1Expected.getX(),rover1Final.getX(), "Rover X final position mismatch" );
        assertEquals(rover1Expected.getY(),rover1Final.getY(), "Rover Y final position mismatch" );
    }
    @Test
    @DisplayName("returns valid orientation")
    public void testRoverRightMoveSouthOrientation() {

        Rover rover1 = new Rover(1,2, "Rover1", 'E');
        Rover rover2 = new Rover(4, 4, "Rover2", 'N');

        Plateau plateau = new Plateau(5, 5);
        Plateau.placeRovers(rover1, rover2);

        String rover1Instruction = "RM";
        MotionController motionControllerRover1 = new MotionController(plateau, rover1);
        Rover rover1Expected = new Rover(1,1, "Rover1Expected", 'S');
        Rover rover1Final = motionControllerRover1.executeInstruction(rover1Instruction);
        assertEquals(rover1Expected.getOrientation(),rover1Final.getOrientation(), "Rover final orientation mismatch" );
        assertEquals(rover1Expected.getX(),rover1Final.getX(), "Rover X final position mismatch" );
        assertEquals(rover1Expected.getY(),rover1Final.getY(), "Rover Y final position mismatch" );
    }
    @Test
    @DisplayName("returns valid orientation")
    public void testRoverRightMoveEastOrientation() {

        Rover rover1 = new Rover(1,2, "Rover1", 'N');
        Rover rover2 = new Rover(4, 4, "Rover2", 'N');

        Plateau plateau = new Plateau(5, 5);
        Plateau.placeRovers(rover1, rover2);

        String rover1Instruction = "RM";
        MotionController motionControllerRover1 = new MotionController(plateau, rover1);
        Rover rover1Expected = new Rover(2,2, "Rover1Expected", 'E');
        Rover rover1Final = motionControllerRover1.executeInstruction(rover1Instruction);
        assertEquals(rover1Expected.getOrientation(),rover1Final.getOrientation(), "Rover final orientation mismatch" );
        assertEquals(rover1Expected.getX(),rover1Final.getX(), "Rover X final position mismatch" );
        assertEquals(rover1Expected.getY(),rover1Final.getY(), "Rover Y final position mismatch" );
    }
    @Test
    @DisplayName("returns valid orientation")
    public void testRoverRightMoveNorthOrientation() {

        Rover rover1 = new Rover(1,2, "Rover1", 'W');
        Rover rover2 = new Rover(4, 4, "Rover2", 'N');

        Plateau plateau = new Plateau(5, 5);
        Plateau.placeRovers(rover1, rover2);

        String rover1Instruction = "RM";
        MotionController motionControllerRover1 = new MotionController(plateau, rover1);
        Rover rover1Expected = new Rover(1,3, "Rover1Expected", 'N');
        Rover rover1Final = motionControllerRover1.executeInstruction(rover1Instruction);
        assertEquals(rover1Expected.getOrientation(),rover1Final.getOrientation(), "Rover final orientation mismatch" );
        assertEquals(rover1Expected.getX(),rover1Final.getX(), "Rover X final position mismatch" );
        assertEquals(rover1Expected.getY(),rover1Final.getY(), "Rover Y final position mismatch" );
    }
    @Test
    @DisplayName("returns valid orientation")
    public void testRoverRightMoveWestOrientation() {

        Rover rover1 = new Rover(2,2, "Rover1", 'S');
        Rover rover2 = new Rover(4, 4, "Rover2", 'N');

        Plateau plateau = new Plateau(5, 5);
        Plateau.placeRovers(rover1, rover2);

        String rover1Instruction = "RM";
        MotionController motionControllerRover1 = new MotionController(plateau, rover1);
        Rover rover1Expected = new Rover(1,2, "Rover1Expected", 'W');
        Rover rover1Final = motionControllerRover1.executeInstruction(rover1Instruction);
        assertEquals(rover1Expected.getOrientation(),rover1Final.getOrientation(), "Rover final orientation mismatch" );
        assertEquals(rover1Expected.getX(),rover1Final.getX(), "Rover X final position mismatch" );
        assertEquals(rover1Expected.getY(),rover1Final.getY(), "Rover Y final position mismatch" );
    }
    @Test
    @DisplayName("returns valid position with orientation for Rover1")
    public void testRover1Position() {

        Rover rover1 = new Rover(1,2, "Rover1", 'N');
        Rover rover2 = new Rover(4, 4, "Rover2", 'N');

        Plateau plateau = new Plateau(5, 5);
        Plateau.placeRovers(rover1, rover2);

        String rover1Instruction = "LMLMLMLMM";
        MotionController motionControllerRover1 = new MotionController(plateau, rover1);
        Rover rover1Expected = new Rover(1,3, "Rover1Expected", 'N');
        try {
            Rover rover1Final = motionControllerRover1.executeInstruction(rover1Instruction);
            assertEquals(rover1Expected.getOrientation(),rover1Final.getOrientation(), "Rover final position mismatch" );
            assertEquals(rover1Expected.getX(),rover1Final.getX(), "Rover final position mismatch" );
            assertEquals(rover1Expected.getY(),rover1Final.getY(), "Rover final position mismatch" );
        } catch (IllegalArgumentException ex) {
            fail(ex.getMessage());
        }
    }
    @Test
    @DisplayName("returns valid position with orientation for Rover2")
    public void testRover2Position() {
        Rover rover1 = new Rover(3,3, "Rover1", 'E');
        Rover rover2 = new Rover(4, 4, "Rover2", 'N');

        Plateau plateau = new Plateau(5, 5);
        Plateau.placeRovers(rover1, rover2);

        String rover2Instruction = "ML";
        MotionController motionControllerRover2 = new MotionController(plateau, rover2);
        Rover rover1Expected = new Rover(4,5, "Rover1Expected", 'W');
        try {
            Rover rover1Final = motionControllerRover2.executeInstruction(rover2Instruction);
            assertEquals(rover1Expected.getOrientation(),rover1Final.getOrientation(), "Rover final position mismatch" );
            assertEquals(rover1Expected.getX(),rover1Final.getX(), "Rover final position X mismatch" );
            assertEquals(rover1Expected.getY(),rover1Final.getY(), "Rover final position Y mismatch" );
        } catch (IllegalArgumentException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    @DisplayName("returns collision message")
    public void testRoversForCollisionOnEastMove() {
        Rover rover1 = new Rover(1,1, "Rover1", 'N');
        Rover rover2 = new Rover(2, 1, "Rover2", 'N');

        Plateau plateau = new Plateau(5, 5);
            Plateau.placeRovers(rover1, rover2);
        String rover1Instruction = "RM";
        MotionController motionControllerRover1 = new MotionController(plateau, rover1);

        Exception ex = assertThrows(IllegalArgumentException.class, () -> motionControllerRover1.executeInstruction(rover1Instruction));

        String expectedMessage = "Rovers colliding for the plateau";
        String actualMessage = ex.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("returns collision message")
    public void testRoversForCollisionOnWestMove() {
        Rover rover1 = new Rover(2,1, "Rover1", 'N');
        Rover rover2 = new Rover(1, 1, "Rover2", 'N');

        Plateau plateau = new Plateau(5, 5);
        Plateau.placeRovers(rover1, rover2);
        String rover1Instruction = "LM";
        MotionController motionControllerRover1 = new MotionController(plateau, rover1);

        Exception ex = assertThrows(IllegalArgumentException.class, () -> motionControllerRover1.executeInstruction(rover1Instruction));

        String expectedMessage = "Rovers colliding for the plateau";
        String actualMessage = ex.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("returns collision message")
    public void testRoversForCollisionOnNorthMove() {
        Rover rover1 = new Rover(1,1, "Rover1", 'E');
        Rover rover2 = new Rover(1, 2, "Rover2", 'N');

        Plateau plateau = new Plateau(5, 5);
        Plateau.placeRovers(rover1, rover2);
        String rover1Instruction = "LM";
        MotionController motionControllerRover1 = new MotionController(plateau, rover1);

        Exception ex = assertThrows(IllegalArgumentException.class, () -> motionControllerRover1.executeInstruction(rover1Instruction));

        String expectedMessage = "Rovers colliding for the plateau";
        String actualMessage = ex.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("returns collision message")
    public void testRoversForCollisionOnSouthMove() {
        Rover rover1 = new Rover(1,2, "Rover1", 'E');
        Rover rover2 = new Rover(1, 1, "Rover2", 'N');

        Plateau plateau = new Plateau(5, 5);
        Plateau.placeRovers(rover1, rover2);
        String rover1Instruction = "RM";
        MotionController motionControllerRover1 = new MotionController(plateau, rover1);

        Exception ex = assertThrows(IllegalArgumentException.class, () -> motionControllerRover1.executeInstruction(rover1Instruction));

        String expectedMessage = "Rovers colliding for the plateau";
        String actualMessage = ex.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("returns collision message")
    public void testRoversForCollisionAtStart() {
        Rover rover1 = new Rover(1,1, "Rover1", 'E');
        Rover rover2 = new Rover(1, 1, "Rover2", 'N');

        Plateau plateau = new Plateau(5, 5);
        Plateau.placeRovers(rover1, rover2);
        String rover1Instruction = "RM";
        MotionController motionControllerRover1 = new MotionController(plateau, rover1);

        Exception ex = assertThrows(IllegalArgumentException.class, () -> motionControllerRover1.executeInstruction(rover1Instruction));

        String expectedMessage = "Rovers colliding for the plateau";
        String actualMessage = ex.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Execute Instructions For Both Rovers")
    public void executeInstructionsForBothRovers() {
        Rover rover1 = new Rover(1,2, "Rover1", 'N');
        Rover rover2 = new Rover(4, 4, "Rover2", 'N');

        Plateau plateau = new Plateau(5, 5);
        Plateau.placeRovers(rover1, rover2);

        String rover1Instruction = "LMLMLMLMM";
        String rover2Instruction = "RM";
        MotionController motionControllerRover1 = new MotionController(plateau, rover1);
        Rover rover1Expected = new Rover(1,3, "Rover1Expected", 'N');
        try {
            Rover rover1Final = motionControllerRover1.executeInstruction(rover1Instruction);
            assertEquals(rover1Expected.getOrientation(),rover1Final.getOrientation(), "Rover final position mismatch" );
            assertEquals(rover1Expected.getX(),rover1Final.getX(), "Rover final X position mismatch" );
            assertEquals(rover1Expected.getY(),rover1Final.getY(), "Rover final Y position mismatch" );
        } catch (IllegalArgumentException ex) {
            fail(ex.getMessage());
        }
        MotionController motionControllerRover2 = new MotionController(plateau, rover2);
        Rover rover2Expected = new Rover(5,4, "Rover1Expected", 'E');
        try {
            Rover rover2Final = motionControllerRover2.executeInstruction(rover2Instruction);
            assertEquals(rover2Expected.getOrientation(),rover2Final.getOrientation(), "Rover final position mismatch" );
            assertEquals(rover2Expected.getX(),rover2Final.getX(), "Rover final X position mismatch" );
            assertEquals(rover2Expected.getY(),rover2Final.getY(), "Rover final Y position mismatch" );
        } catch (IllegalArgumentException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    @DisplayName("Returns file read success for Plateau")
    public void readPlateauFromFile() throws IOException {
        String file = "src/test/resources/input.txt";
        ArrayList<String> fileContent = new ArrayList<>();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while (bufferedReader.ready()) {
                fileContent.add(bufferedReader.readLine());
            }
        }

        String[] currentLine = fileContent.get(0).split(" ");

        Plateau pl1 = new Plateau(Integer.parseInt(currentLine[0]), Integer.parseInt(currentLine[1]));

        assertEquals(5, pl1.getX(), "X co-ordinate is correct");
        assertEquals(5, pl1.getY(), "Y co-ordinate is correct");
    }

    @Test
    @DisplayName("Returns file read success for Plateau and Rover One")
    public void readPlateauAndRoverOneFromFile() throws IOException {
        String file = "src/test/resources/input.txt";
        ArrayList<String> fileContents = new ArrayList<>();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while(bufferedReader.ready()) {
                fileContents.add(bufferedReader.readLine());
            }
        }

        String[] plateauLine = fileContents.get(0).split(" ");
        Plateau plateau = new Plateau();

        plateau.setX(Integer.parseInt(plateauLine[0]));
        plateau.setY(Integer.parseInt(plateauLine[1]));

        String[] roverOneLine = fileContents.get(1).split(" ");
        Rover rover1 = new Rover();
        char orientation = roverOneLine[2].charAt(0);

        rover1.setX(Integer.parseInt(roverOneLine[0]));
        rover1.setY(Integer.parseInt(roverOneLine[1]));
        rover1.setOrientation(orientation);

        assertEquals(5, plateau.getX(), "Plateau's X co-ordinate is a mismatch");
        assertEquals(5, plateau.getY(), "Plateau's Y co-ordinate is a mismatch");

        assertEquals(1, rover1.getX(), "X co-ordinate is incorrect");
        assertEquals(2, rover1.getY(), "Y co-ordinate is incorrect");
        assertEquals('N', rover1.getOrientation(), "Orientation is incorrect");
    }
}
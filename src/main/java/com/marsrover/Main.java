package com.marsrover;

import com.marsrover.model.Plateau;
import com.marsrover.model.Rover;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    private static Plateau createPlateau(String[] plateauCoOrdinates) {
        Plateau plateau = new Plateau();

        plateau.setX(Integer.parseInt(plateauCoOrdinates[0]));
        plateau.setY(Integer.parseInt(plateauCoOrdinates[1]));

        return plateau;
    }

    private static Rover createRover(String[] roverInput) {
        Rover rover = new Rover();
        char roverOneOrientation = roverInput[2].charAt(0);

        rover.setX(Integer.parseInt(roverInput[0]));
        rover.setY(Integer.parseInt(roverInput[1]));
        rover.setOrientation(roverOneOrientation);
        rover.setName("Rover1");

        return rover;
    }


    public static void main(String[] args) throws IOException {
        String file = "src/main/resources/input.txt";
        ArrayList<String> fileContents = new ArrayList<>();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while(bufferedReader.ready()) {
                fileContents.add(bufferedReader.readLine());
            }
        }

        String[] plateauLine = fileContents.get(0).split(" ");
        Plateau plateau = createPlateau(plateauLine);

        String[] roverOneLine = fileContents.get(1).split(" ");
        Rover roverOne = createRover(roverOneLine);

        String roverOneInstruction = fileContents.get(2);

        String[] roverTwoLine = fileContents.get(3).split(" ");
        Rover roverTwo = createRover(roverTwoLine);

        String roverTwoInstruction = fileContents.get(4);

        Plateau.placeRovers(roverOne, roverTwo);

        MotionController motionControllerRover1 = new MotionController(plateau, roverOne);
        Rover rover1Final = motionControllerRover1.executeInstruction(roverOneInstruction);

        MotionController motionControllerRover2 = new MotionController(plateau, roverTwo);
        Rover rover2Final = motionControllerRover2.executeInstruction(roverTwoInstruction);

        System.out.println(" Final position and orientation of " + roverOne.getName() + " is: " + rover1Final.getX() + ", " + rover1Final.getY() + ", " + rover1Final.getOrientation());
        System.out.println(" Final position and orientation of " + roverTwo.getName() + " is: " + rover2Final.getX() + ", " + rover2Final.getY() + ", " + rover2Final.getOrientation());

    }
}

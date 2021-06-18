package com.marsrover;

import com.marsrover.model.Plateau;
import com.marsrover.model.Rover;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

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
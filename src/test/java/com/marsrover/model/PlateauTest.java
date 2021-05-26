package com.marsrover.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {

    @Test
    @DisplayName("returns top right co-ordinates of the plateau")
    public void testPlateauUpperBound(){
        Rover rover1 = new Rover('1', '2', "Rover1", 'N');
        Rover rover2 = new Rover('3', '3', "Rover2", 'W');
        Plateau pl1 = new Plateau(5,5);

        assertEquals(5, pl1.getX(), "X co-ordinate is correct");
        assertEquals(5, pl1.getY(), "Y co-ordinate is correct");
    }

    @Test
    @DisplayName("returns top right co-ordinates of the plateau")
    public void testRoverPlacing(){
        Rover rover1 = new Rover('1', '2', "Rover1", 'N');
        Rover rover2 = new Rover('3', '3', "Rover2", 'W');
        Plateau pl1 = new Plateau(5,5);
        Plateau.placeRovers(rover1,rover2);

        assertEquals(5, pl1.getX(), "X co-ordinate is correct");
        assertEquals(5, pl1.getY(), "Y co-ordinate is correct");
    }

    @Test
    @DisplayName("returns top right co-ordinates of the plateau")
    public void testPlateauNegativeValues(){
        Rover rover1 = new Rover('1', '2', "Rover1", 'N');
        Rover rover2 = new Rover('3', '3', "Rover2", 'W');
        Plateau pl1 = new Plateau(-1,-1);
        Assertions.assertFalse(pl1.isValidX(-1), "X co-ordinate cannot be a negative value");
        Assertions.assertFalse(pl1.isValidY(-1), "Y co-ordinate cannot be a negative value");
    }

    @Test
    @DisplayName("returns top right co-ordinates of the plateau")
    public static void testPlaceRovers(){
        Rover rover1 = new Rover('1', '2', "Rover1", 'N');
        Rover rover2 = new Rover('3', '3', "Rover2", 'W');
        Plateau pl1 = new Plateau(5,5);

       Plateau.placeRovers(rover1, rover2);

        //assertEquals(, "Cannot place rovers");
    }


}
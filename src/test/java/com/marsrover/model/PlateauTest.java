package com.marsrover.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {

    @Test
    @DisplayName("returns top right co-ordinates of the plateau")
    public void testPlateauUpperBound(){
        Plateau pl1 = new Plateau(5,5);
        assertEquals(5, pl1.getX(), "X co-ordinate is correct");
        assertEquals(5, pl1.getY(), "Y co-ordinate is correct");
    }

    @Test
    @DisplayName("returns top right co-ordinates of the plateau")
    public void testPlateauNegativeValues(){
        Plateau pl1 = new Plateau(-1,-1);
        Assertions.assertFalse(pl1.isValidX(-1), "X co-ordinate cannot be a negative value");
        Assertions.assertFalse(pl1.isValidY(-1), "Y co-ordinate cannot be a negative value");
    }

}
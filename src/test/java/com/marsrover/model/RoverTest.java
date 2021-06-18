package com.marsrover.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class RoverTest {

    @Test
    @DisplayName("returns Rover Orientation for a Rover object")
    public void testRoverOrientation(){
        Rover r1 = new Rover(1,2, "Rover1", 'N');
        assertEquals('N', r1.getOrientation(), "Orientation is correct");
    }

    @Test
    @DisplayName("returns Rover co-ordinates for a Rover object")
    public void testRoverPoints() {
        Rover r1 = new Rover(1,2, "Rover1", 'N');
        assertEquals(1, r1.getX(), "X co-ordinate is correct");
        assertEquals(2,r1.getY(), "Y co-ordinate is correct");
    }

}
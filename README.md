# MarsRoverChallenge

The problem below requires some kind of input. You are free to implement any mechanism for feeding input into your solution (for example, using
hard coded data within a unit test). You should provide sufficient evidence that your solution is complete by, as a minimum, indicating that it works
correctly against the supplied test data.
We highly recommend using a unit testing framework. Even if you have not used it before, it is simple to learn and incredibly useful. The code you write should be of production quality, and most importantly, it should be code you are proud of.

# MARS ROVERS
A squad of robotic rovers are to be landed by NASA on a plateau on Mars.
This plateau, which is curiously rectangular, must be navigated by the rovers so that their on board cameras can get a complete view of the
surrounding terrain to send back to Earth.
A rover's position is represented by a combination of an x and y co-ordinates and a letter representing one of the four cardinal compass points.
The plateau is divided up into a grid to simplify navigation. An example position might be 0, 0, N, which means the rover is in the bottom left
corner and facing North.
In order to control a rover, NASA sends a simple string of letters. The possible letters are 'L', 'R' and 'M'. 'L' and 'R' makes the rover spin 90
degrees left or right respectively, without moving from its current spot.
'M' means move forward one grid point, and maintain the same heading.
Assume that the square directly North from (x, y) is (x, y+1).

# Quick start
This has been created using gradle; to run the tests, just execute:
```java
./gradlew test
```
or 

(on windows machines):
```java
gradlew.bat test
```
Use the commandline app

Package the app using:
```java
./gradlew build
```
# Assumptions and Design 

## Assumptions: 

The rover should always be on the Plateau, which means all the rover can't moved out of Plateau. For example we have the Plateau as (5, 5). One Rover is at (3, 3, N) and its instructions is 'MMMMMRMM'. After it executed the second instruction, it will be at (3, 5, N) and the left instruction is 'MMMRMM'. Now it can't move forward N anymore. So there will be an error thrown out as the instructions cannot be executed on the whole. 

The rover can't be moved to overlap/collide on previous rovers, which means when we have two rovers [(0, 1, N), (0, 0, N)], we can't move the second rover, because there is already one rover at (0, 1) already. So there will be an error thrown out as the instructions cannot be executed on the whole. 

Basically I used OO design for 3 classes: 

Plateau - Used to limit how far away the rovers can move to. Also, it maintains a list of rovers. 

Rover - Rover can turn left, turn right and move forward one step. One rover has no idea of other rover nor plateau. 

MotionController - It's used to connect Plateau and Rovers and parse input instructions to move rover to a destination based on the instruction.

Check if a rover move instruction can be executed, which means a rover can't move out of plateau, nor move to overlap/collide on another rover. MotionController will throw an error out as the instructions cannot be executed on the whole. 

Error handle: 
When there is input error(the coordinate is negative or decimal, and etc) or logic error(rover was deployed out plateau, and etc.) The code will throw error.

Unit Testing:
The Red, Green, Refactor approach was followed, as such all of the tests were written first, then ran and broken (Red), then implemented the code / logic (Green) and finally any refactoring that was needed (and could be have been done within the time constraints). Unit Tests are implemented using JUnit. Unit Test cases include testing for valid and invalid inputs and displaying appropriate exceptions for invalid inputs. 

# Input:

The first line of input is the upper-right coordinates of the plateau, the lower-left coordinates are assumed to be 0,0.
The rest of the input is information pertaining to the rovers that have been deployed. Each rover has two lines of input. The first line gives the
rover's position, and the second line is a series of instructions telling the rover how to explore the plateau.
The position is made up of two integers and a letter separated by spaces, corresponding to the x and y co-ordinates and the rover's orientation.
Each rover will be finished sequentially, which means that the second rover won't start to move until the first one has finished moving.

# Output:
The output for each rover should be its final co-ordinates and heading.

Test Input: \
5 5 \
1 2 N \
LMLMLMLMM \
3 3 E \
MMRMMRMRRM 

Expected Output: \
1 3 N \
5 1 E 

### To-do:

- Minor refactoring to replace if-else with enums/lambda.
- Read input from file.

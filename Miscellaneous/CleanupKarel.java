/*
* File: CleanupKarel.java
* -----------------------
* Karel starts at (1, 1) facing East and cleans up any
* beepers scattered throughout his world.
*/

import stanford.karel.*;
public class CleanupKarel extends SuperKarel {
/* Cleans up a field of beepers, one row at a time */
public void run() {
cleanRow();
while (leftIsClear()) {
repositionForRowToWest();
cleanRow();
if (rightIsClear()) {
repositionForRowToEast();
cleanRow();
} else {
/*
* In rows with an even number of streets, we want
* Karel's left to be blocked after he cleans the last
* row, so we turn him to the appropriate orientation.
*/
turnAround();
}
}
}

/* Cleans up a row in whichever direction Karel is facing */
private void cleanRow() {
if (beepersPresent()) {
pickBeeper();
}
while (frontIsClear()) {
move();
if (beepersPresent()) {
pickBeeper();
}
}
}
/* Reposition Karel at far East wall to face West on next row */
private void repositionForRowToWest() {
turnLeft();
move();
turnLeft();
}
/* Reposition Karel at far West wall to face East on next row */
private void repositionForRowToEast() {
turnRight();
move();
turnRight();
}
}

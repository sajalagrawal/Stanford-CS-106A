/*
* File: DoubleBeepers.java
* ------------------------
* Karel doubles the number of beepers on the corner directly
* in front of him in the world. He then returns to his
* original position/orientation.
*/

import stanford.karel.SuperKarel;
public class DoubleBeepers extends SuperKarel {
public void run() {
move();
DoubleBeepersInPile();
moveBackward();
}
/*
* For every beeper on the current corner, Karel places
* two beepers on the corner immediately ahead of him.
*/
private void DoubleBeepersInPile() {
while (beepersPresent()) {
pickBeeper();
PutTwoBeepersNextDoor();
}
MovePileNextDoorBack();
}
/*
* Place two beepers on corner one avenue ahead of Karel
* and move back to starting position/orientation
*/
private void PutTwoBeepersNextDoor() {
move();
putBeeper();
putBeeper();
moveBackward();
}
/*
* Move all the beepers on the corner in front of Karel
* the the corner Karel is currently on.
*/
private void MovePileNextDoorBack() {
move();
while (beepersPresent()) {
MoveOneBeeperBack();
}
moveBackward();
}
/*
* Move one beeper from the current corner back one avenue
* and return to the original position/orientation.
*/
private void MoveOneBeeperBack() {
pickBeeper();
moveBackward();
putBeeper();
move();
}
/*
* Move Karel back one avenue, but have the same
* final orientation.
*/
private void moveBackward() {
turnAround();
move();
turnAround();
}
}

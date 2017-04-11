// Pouya Rad
// 001776546
// CS 301 A - Spring 2017
// Dr. Andrew Nuxoll
// HW Assignment 3
// Part A: 3 April 2017; Part B: 10 April 2017

package edu.up.rad19egr.canon;

/**
 * Created by PouyaRad on 4/4/17.
 */

public class MediumTarget extends Target {

    // Constructor for the Medium Target on the screen.
    // Accepts 4 parameters: an integer indicating the point value, two
    // integers for the X & Y position of the target, and a boolean indicating
    // if the target has been hit.
    public MediumTarget(int pointValue, int x, int y, boolean hit) {
        super(pointValue, x, y, hit);
        setHeight(100);
    }

}

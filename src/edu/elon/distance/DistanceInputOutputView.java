/*
 * DistanceInputOutputView.java 1.0 Feb 19, 2015
 *
 * Copyright (c) 2015 David T. Han
 * Campus Box 3360, Elon University, Elon, NC 27244
 */
package edu.elon.distance;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

/**
 * Creates popup boxes to enter information on cities and their latitudes and
 * longitudes as well as returns information for longest distance between the
 * cities to user
 *
 * @author dhan
 * @version 1.0
 * @since 1.0
 * 
 */
public class DistanceInputOutputView implements DistanceUserInterface {

  /**
   * 
   * create popup box for latitude of entered city
   *
   * @param getLoc
   *        last entered location
   * @return strLat use string latitude to store in string array
   */
  @Override
  public String getLat(String getLoc) {
    String strLat = (String) JOptionPane.showInputDialog(null,
        "Enter Latitude for " + getLoc, "Input Latitude",
        JOptionPane.QUESTION_MESSAGE, null, null, 32.7842);
    return strLat;
  }

  /**
   * 
   * enter a city to store
   *
   * @return getLoc provides getLoc to store in array
   */
  @Override
  public String getLoc() {
    String getLoc = (String) JOptionPane.showInputDialog(null,
        "Enter Location Name: ", "Input Location Name",
        JOptionPane.QUESTION_MESSAGE, null, null, "Charleston");
    return getLoc;
  }

  /**
   * 
   * create popup box for longitude of entered city
   *
   * @param getLoc
   *        last entered location
   * @return strLong provides latest longitude to store in array
   */
  @Override
  public String getLong(String getLoc) {
    // MAKE SURE GETLOC IS RECOGNIZED
    String strLong = (String) JOptionPane.showInputDialog(null,
        "Enter Longitude for " + getLoc, "Input Longitude",
        JOptionPane.QUESTION_MESSAGE, null, null, -79.9381);
    return strLong;
  }

  /**
   * 
   * Asks for number of cities that will be stored
   *
   * @return numLoc provides number of rows for creating an array
   */
  @Override
  public int getNumLoc() {
    String basenumber = (String) JOptionPane.showInputDialog(null,
        "Enter number of locations to be entered:",
        "Input Number OF Locations", JOptionPane.QUESTION_MESSAGE, null, null,
        10);
    int numLoc = Integer.parseInt(basenumber);
    return numLoc;
  }

  /**
   * 
   * Create display box to show all information entered and the furthest
   * distance between which two cities
   *
   * @param citiesArr
   *        array with cities, longitude, and latitude
   * @param distance
   *        furthest length between supplied cities
   * @param numLoc
   *        number of locations user is using
   * @param city1
   *        first city used to calculate distance
   * @param city2
   *        second city used to calculate distance
   */
  @Override
  public void showValues(String citiesArr[][], double distance, int numLoc,
      String city1, String city2) {
    UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(
        "Monospaced", Font.PLAIN, 12)));
    String title = "Location Information";
    String message = String.format("%-35s %-25s %-25s \n", "Location",
        "Latitude", "Longitude");
    for (int i = 0; i < numLoc; i++) {
      message = message
          + String.format("%-35s %-25s %-25s \n", citiesArr[i][0],
              citiesArr[i][1], citiesArr[i][2]);
    }
    String measure = String.format("%.2f", distance);
    message = message + "\n" + "Farthest distance is " + measure
        + " miles from " + city1 + " to " + city2;
    JOptionPane.showMessageDialog(null, message, title,
        JOptionPane.INFORMATION_MESSAGE);
  }
}

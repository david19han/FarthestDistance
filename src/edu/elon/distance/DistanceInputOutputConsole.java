/*
 * DistanceInputOutputConsole.java 1.0 Mar 10, 2015
 *
 * Copyright (c) 2015 David T. Han
 * Campus Box 3360, Elon University, Elon, NC 27244
 */
package edu.elon.distance;

import java.util.Scanner;

/**
 * Uses console to asks for input from user
 *
 * @author dhan
 * @version 1.0
 * @since 1.0
 * 
 */
public class DistanceInputOutputConsole implements DistanceUserInterface {
  /**
   * 
   * uses console to ask for latitude of entered city
   *
   * @param getLoc last entered location
   * @return strLat use string latitude to store in string array
   */
  @Override
  public String getLat(String getLoc) {
    Scanner in = new Scanner(System.in);
    System.out.println("Enter Latitude for: " + getLoc);
    String strLat = in.nextLine();
    return strLat;
  }

  /**
   * 
   * uses console to ask for a city to store
   *
   * @return getLoc provides getLoc to store in array
   */
  @Override
  public String getLoc() {
    Scanner in = new Scanner(System.in);
    System.out.println("Enter Location name:");
    String strLoc = in.nextLine();
    return strLoc;
  }

  /**
   * 
   * use console to ask for longitude of entered city
   *
   * @param getLoc last entered location
   * @return strLong provides latest longitude to store in array
   */
  @Override
  public String getLong(String getLoc) {
    Scanner in = new Scanner(System.in);
    System.out.println("Enter Longitude for: " + getLoc);
    String strLong = in.nextLine();
    return strLong;
  }

  /**
   * 
   * Use console to ask for number of cities that will be stored
   *
   * @return numLoc provides number of rows for creating an array
   */
  @Override
  public int getNumLoc() {
    Scanner in = new Scanner(System.in);
    System.out.println("Enter number of locations to be entered:");
    int numLoc = in.nextInt();
    return numLoc;
  }

  /**
   * 
   * Create display in console to show all information entered and the furthest
   * distance between which two cities
   *
   * @param citiesArr array with cities, longitude, and latitude
   * @param distance furthest length between supplied cities
   * @param numLoc number of locations user is using
   * @param city1 first city used to calculate distance
   * @param city2 second city used to calculate distance
   */
  @Override
  public void showValues(String citiesArr[][], double distance, int numLoc,
          String city1, String city2) {
    String title = "Location Information";
    System.out.println(title);
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

    System.out.println(message);

  }
}

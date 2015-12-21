/*
 * DistanceUserInterface.java 1.0 Mar 10, 2015
 *
 * Copyright (c) 2015 David T. Han
 * Campus Box 3360, Elon University, Elon, NC 27244
 */
package edu.elon.distance;

/**
 * Uses Polymorphism to be able to access either the console or joptionpane
 * based on user's preference
 *
 * @author dhan
 * @version 1.0
 * @since 1.0
 * 
 */
public interface DistanceUserInterface {
  /**
   * 
   * Uses methods from console and inputoutputview to be able to access
   * whichever one is coded in the Main class
   *
   * @param getLoc
   * @return
   */
  public String getLat(String getLoc);

  public String getLoc();

  public String getLong(String getLoc);

  public int getNumLoc();

  public void showValues(String citiesArr[][], double distance, int numLoc,
          String city1, String city2);

}

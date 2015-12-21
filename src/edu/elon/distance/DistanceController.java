/*
 * DistanceController.java 1.0 Feb 19, 2015
 *
 * Copyright (c) 2015 David T. Han
 * Campus Box 3360, Elon University, Elon, NC 27244
 */
package edu.elon.distance;

/**
 * create system to read entered information (whether by console or
 * joptionpane), process them through double arrays to use in the haversine
 * function and through string arrays to display the furthest distance back to
 * the user
 *
 * @author dhan
 * @version 1.0
 * @since 1.0
 * 
 */
public class DistanceController {
  private DistanceUserInterface ui;

  public DistanceController() {
    // ui = new DistanceInputOutputView();
    // ui = new DistanceInputOutputConsole();

  }

  public void go() {

    int numLoc = ui.getNumLoc();
    DistanceModel model = new DistanceModel(numLoc);

    for (int i = 0; i < numLoc; i++) {
      String loc = ui.getLoc();
      model.addLocArray(loc);
      String lat = ui.getLat(loc);
      model.addLatArray(lat);
      String lon = ui.getLong(loc);
      model.addLongArray(lon);
    }

    double[][] longLat = model.numsArray(numLoc);
    double distance = model.haversin(longLat, numLoc);
    String[][] citiesArr = model.citiesArr(numLoc);
    String city1 = model.city1(citiesArr);
    String city2 = model.city2(citiesArr);

    ui.showValues(citiesArr, distance, numLoc, city1, city2);

  }

  public void setUi(DistanceUserInterface ui) {
    this.ui = ui;
  }

}
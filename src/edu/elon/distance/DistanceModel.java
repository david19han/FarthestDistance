/*
 * DistanceModel.java 1.0 Feb 19, 2015
 *
 * Copyright (c) 2015 David T. Han
 * Campus Box 3360, Elon University, Elon, NC 27244
 */
package edu.elon.distance;

import java.util.Arrays;

/**
 * establishes methods to transfer information from user to arrays and create
 * distance formulas to determine farthest cities
 *
 * @author dhan
 * @version 1.0
 * @since 1.0
 * 
 */
public class DistanceModel {
  private String[][] cities;
  private double[][] longLat;
  private int cityCount;
  private String[] locArr;
  private String[] latArr;
  private String[] longArr;
  private int latNum;
  private int locNum;
  private int longNum;
  private int c1;
  private int c2;
  private String city1;
  private String city2;

  private double minimum;
  private double largest;

  /**
   * 
   * Creates string array and titles for the string array that we will display
   * to the user
   *
   * @param numLoc
   *        number of locations user is using
   */
  public DistanceModel(int numLoc) {
    cities = new String[1 + numLoc][3];
    cityCount = 1;

    locArr = new String[numLoc];
    latArr = new String[numLoc];
    longArr = new String[numLoc];
    latNum = 0;
    locNum = 0;
    longNum = 0;

    minimum = 0;
    largest = 0;
  }

  /**
   * 
   * creates one dimension array to store latitudes in
   *
   * @param strLat
   *        string form of latitude entered
   * @return
   */
  public void addLatArray(String strLat) {
    latArr[latNum] = strLat;
    latNum++;
  }

  public String getLatArray(int number) {
    return latArr[number];
  }

  /**
   * 
   * creates one dimension array to store locations in
   *
   * @param getLoc
   *        last entered location
   * @return
   */
  public void addLocArray(String getLoc) {
    locArr[locNum] = getLoc;
    locNum++;
  }

  public String getLocArray(int number) {
    return locArr[number];
  }

  /**
   * 
   * creates one dimension array to store longitudes in
   *
   * @param strLong
   *        string form of longitude
   * @return
   */
  public void addLongArray(String strLong) {
    longArr[longNum] = strLong;
    longNum++;
  }

  public String getLongArray(int number) {
    return longArr[number];
  }

  /**
   * 
   * stores the location, latitude, and longitude arrays into one large array
   *
   * @param numLoc
   *        number of locations user is using
   * @return
   */
  public String[][] citiesArr(int numLoc) {
    for (int i = 0; i < numLoc; i++) {
      cities[i][0] = locArr[i];
    }
    for (int i = 0; i < numLoc; i++) {
      cities[i][1] = latArr[i];
    }
    for (int i = 0; i < numLoc; i++) {
      cities[i][2] = longArr[i];
    }
    return cities;
  }

  /**
   * 
   * returns string of first city in largest distance
   *
   * @param citiesArr
   *        array with cities, longitude, and latitude
   * @return
   */
  public String city1(String[][] citiesArr) {
    return citiesArr[c1][0];
  }

  /**
   * 
   * returns string of second city in largest distance
   *
   * @param citiesArr
   *        array with cities, longitude, and latitude
   * @return
   */
  public String city2(String[][] citiesArr) {
    return citiesArr[c2][0];
  }

  /**
   * The equals() method is inherited from Object and it compares two names
   * arrays to see if they are equal to each other, not only in length but also
   * in the elements within each array.
   * 
   * @param obj
   *        and names instance to compare against implicit object
   * @return true if the arrays are equal to each other, otherwise false
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {


    DistanceModel other = (DistanceModel) obj;
    
    if(locArr.length != other.locArr.length){
      return false;
    }
    
    for(int i = 0; i<locArr.length; i++){
      if(locArr[i] != other.locArr[i]){
        return false;
      }
    }
    
    
    if (c1 != other.c1) {
      return false;
    }
    if (c2 != other.c2) {
      return false;
    }
    if (!Arrays.deepEquals(cities, other.cities)) {
      return false;
    }
    
    if (city1 == null) {
      if (other.city1 != null) {
        return false;
      }
    } else if (!city1.equals(other.city1)) {
      return false;
    }
    if (city2 == null) {
      if (other.city2 != null) {
        return false;
      }
    } else if (!city2.equals(other.city2)) {
      return false;
    }
    if (Double.doubleToLongBits(largest) != Double
        .doubleToLongBits(other.largest)) {
      return false;
    }
    if (!Arrays.equals(locArr, other.locArr)) {
      return false;
    }
    return true;
  }

  /**
   * 
   * creates method for junit to test max distance
   *
   * @param longLat
   *        double array for doubles
   * @param numLoc
   *        number of locations user is using
   * @return largest to show longest distance
   */
  public double getMaximumDistance(double[][] longLat, int numLoc) {
    final double RADIUS = 3959.87;
    double distance = 0;

    for (int j = 0; j < numLoc - 1; j++) {
      for (int i = j + 1; i < numLoc; i++) {
        double lat1 = longLat[j][0];
        double long1 = longLat[j][1];
        double lat2 = longLat[i][0];
        double long2 = longLat[i][1];
        double dLat = Math.toRadians(lat2 - lat1);
        double dLong = Math.toRadians(long2 - long1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
            + Math.sin(dLong / 2) * Math.sin(dLong / 2) * Math.cos(lat1)
            * Math.cos(lat2);
        double c = 2 * Math.asin(Math.sqrt(a));
        double length = RADIUS * c;
        if (length > largest) {
          largest = length;
          c1 = j;
          c2 = i;
        }
      }

    }
    return largest;
  }

  /**
   * 
   * creates method for junit to test smallest distance
   *
   * @param longLat
   *        double array for doubles
   * @param numLoc
   *        number of locations user is using
   * @return
   */
  public double getMinimumDistance(double[][] longLat, int numLoc) {
    final double RADIUS = 3959.87;
    // double distance = Double.MAX_VALUE;
    minimum = Double.MAX_VALUE;
    for (int j = 0; j < numLoc - 1; j++) {
      for (int i = j + 1; i < numLoc; i++) {
        double lat1 = longLat[j][0];
        double long1 = longLat[j][1];
        double lat2 = longLat[i][0];
        double long2 = longLat[i][1];
        double dLat = Math.toRadians(lat2 - lat1);
        double dLong = Math.toRadians(long2 - long1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
            + Math.sin(dLong / 2) * Math.sin(dLong / 2) * Math.cos(lat1)
            * Math.cos(lat2);
        double c = 2 * Math.asin(Math.sqrt(a));
        double length = RADIUS * c;
        if (length < minimum) {
          minimum = length;
          c1 = j;
          c2 = i;
        }
      }

    }
    return minimum;
  }

  public int getNumberOfLocations(int numLoc) {
    return numLoc;
  }

  /**
   * Compares different hash codes and determines if they are different or the
   * same.
   * 
   * @return integer or a hash code value for the object
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + c1;
    result = prime * result + c2;
    result = prime * result + Arrays.hashCode(cities);
    result = prime * result + ((city1 == null) ? 0 : city1.hashCode());
    result = prime * result + ((city2 == null) ? 0 : city2.hashCode());
    long temp;
    temp = Double.doubleToLongBits(largest);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    result = prime * result + Arrays.hashCode(locArr);
    return result;
  }

  /**
   * 
   * haversin formula and double loop to find largest distance within all the
   * cities entered and store length and cities involved with the distance
   * http://rosettacode.org/wiki/Haversine_formula#Java
   * 
   * @param longLat
   *        double array for doubles
   * @param numLoc
   *        number of locations user is using
   * @return
   */
  public double haversin(double[][] longLat, int numLoc) {
    final double RADIUS = 3959.87;
    double distance = 0;

    for (int j = 0; j < numLoc - 1; j++) {
      for (int i = j + 1; i < numLoc; i++) {
        double lat1 = longLat[j][0];
        double long1 = longLat[j][1];
        double lat2 = longLat[i][0];
        double long2 = longLat[i][1];
        double dLat = Math.toRadians(lat2 - lat1);
        double dLong = Math.toRadians(long2 - long1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
            + Math.sin(dLong / 2) * Math.sin(dLong / 2) * Math.cos(lat1)
            * Math.cos(lat2);
        double c = 2 * Math.asin(Math.sqrt(a));
        double length = RADIUS * c;
        if (length > largest) {
          largest = length;
          c1 = j;
          c2 = i;
        }
      }

    }
    return largest;
  }

  /**
   * 
   * creates two dimension array to store latitudes and longitudes in from which
   * to calculate longest distance
   *
   * @param numLoc
   *        number of locations user is using
   * @return longLat to show double array to use with haversin formula
   */
  public double[][] numsArray(int numLoc) {
    longLat = new double[numLoc][2];
    for (int i = 0; i < numLoc; i++) {
      double numLat = Double.parseDouble(latArr[i]);
      longLat[i][0] = numLat;
    }
    for (int i = 0; i < numLoc; i++) {
      double numLong = Double.parseDouble(longArr[i]);
      longLat[i][1] = numLong;
    }
    return longLat;
  }

  /**The toString() method is inherited from Object, it tells the size of the
   * arrays names, lat, and lon, as well as the Maximum Distance and Minimum
   * Distance the model calculates.
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    /*
     * return "DistanceModel [cities=" + Arrays.toString(cities) + ", longLat="
     * + Arrays.toString(longLat) + ", cityCount=" + cityCount + ", locArr=" +
     * Arrays.toString(locArr) + ", latArr=" + Arrays.toString(latArr) +
     * ", longArr=" + Arrays.toString(longArr) + ", latNum=" + latNum +
     * ", locNum=" + locNum + ", longNum=" + longNum + ", c1=" + c1 + ", c2=" +
     * c2 + ", city1=" + city1 + ", city2=" + city2 + "]";
     */
    return "DistanceModel [currentSizeLoc = " + locArr.length
        + ", smallestDistance = " + minimum + ", largestDistance = " + largest
        + "]";
  }
}

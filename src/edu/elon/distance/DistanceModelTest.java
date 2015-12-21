/*
 * DistanceModelTest.java 1.0 Mar 5, 2015
 *
 * Copyright (c) 2015 David T. Han
 * Campus Box 3360, Elon University, Elon, NC 27244
 */
package edu.elon.distance;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * sets up a test to make sure distancemodel is operating as expected
 *
 * @author dhan
 * @version 1.0
 * @since 1.0
 * 
 */
public class DistanceModelTest {
  private String[][] cities;
  private String[][] newCities;
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
  private DistanceModel model;

  /**
   * creates array information in place of GuiView input
   *
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    locArr = new String[5];
    latArr = new String[5];
    longArr = new String[5];
    longLat = new double[5][2];

    newCities = new String[6][3];

    latNum = 0;
    locNum = 0;
    longNum = 0;
    // latArr[0] = "-20";

    locArr[0] = "Charleston";
    locArr[1] = "Delaware";
    locArr[2] = "Drexel";
    locArr[3] = "Elon";
    locArr[4] = "Northeastern";
    longLat[0][0] = 32.7842;
    longLat[1][0] = 39.6791;
    longLat[2][0] = 39.954;
    longLat[3][0] = 36.1072;
    longLat[4][0] = 42.3389;
    longLat[0][1] = -79.9381;
    longLat[1][1] = -75.7522;
    longLat[2][1] = -75.188;
    longLat[3][1] = -79.5013;
    longLat[4][1] = -71.0903;
    /*
     * newCities[0][0] = "Charleston"; newCities[1][0] = "Delaware";
     * newCities[2][0] = "Drexel"; newCities[3][0] = "Elon"; newCities[4][0] =
     * "Northeastern"; newCities[0][1] = "32.7842"; newCities[1][1] = "39.6791";
     * newCities[2][1] = "39.954"; newCities[3][1] = "36.1072"; newCities[4][1]
     * = "42.3389"; newCities[0][2] = "-79.9381"; newCities[1][2] = "-75.7522";
     * newCities[2][2] = "-75.188"; newCities[3][2] = "-79.5013";
     * newCities[4][2] = "-71.0903";
     */
    model = new DistanceModel(locArr.length);

  }

  /**
   * allows junittest operations
   *
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {
  }

  /**
   * compares distancemodel and distancemodeltest
   * {@link edu.elon.distance.DistanceModel#equals(java.lang.Object)}.
   */
  @Test
  public void testEqualsObject() {
    DistanceModel test = new DistanceModel(locArr.length);
    boolean expected = true;
    boolean actual = model.equals(test);
    assertEquals(expected, actual);
  }

  /**
   * Test method for finding max distance in model
   * {@link edu.elon.distance.DistanceModel#getMaximumDistance(double[][], int)}
   * .
   */
  @Test
  public void testGetMaximumDistance() {
    double expected = Math.round(817.90);
    double actual = Math
        .round(model.getMaximumDistance(longLat, locArr.length));
    double delta = 0.01;
    assertEquals(expected, actual, delta);
  }

  /**
   * Test method for finding min distance in model
   * {@link edu.elon.distance.DistanceModel#getMinimumDistance(double[][], int)}
   * .
   */
  @Test
  public void testGetMinimumDistance() {
    double expected = Math.round(35.0);
    double actual = Math
        .round(model.getMinimumDistance(longLat, locArr.length));
    double delta = 0.01;
    assertEquals(expected, actual, delta);
  }

  /**
   * Test method for recognizing how many locations are in the array
   * {@link edu.elon.distance.DistanceModel#getNumberOfLocations(int)}.
   */
  @Test
  public void testGetNumberOfLocations() {

    int expected = 5;
    int actual = model.getNumberOfLocations(locArr.length);
    assertEquals(expected, actual);
  }

  /**
   * Test method for what is returned as a string
   * {@link edu.elon.distance.DistanceModel#toString()}.
   */
  @Test
  public void testToString() {
    String actual = "DistanceModel [currentSizeLoc = " + locArr.length
        + ", smallestDistance = "
        + model.getMinimumDistance(longLat, locArr.length)
        + ", largestDistance = "
        + model.getMaximumDistance(longLat, locArr.length) + "]";
    String expected = model.toString();
    assertEquals(expected, actual);
  }

  /**
   * Test method for adding a latitude of type String into a latitude array.
   * {@link edu.elon.distance.DistanceModel#addLatArray(String)}.
   */
  @Test
  public void testaddLatArray() {
    model.addLatArray("-30");
    String actual = "-30";
    String expected = model.getLatArray(0);
    assertEquals(expected, actual);
  }

  /**
   * Test method for adding a location of type String into a location array.
   * {@link edu.elon.distance.DistanceModel#addLocArray(String)}.
   */
  @Test
  public void testaddLocArray() {
    model.addLocArray("Los Angeles");
    String actual = "Los Angeles";
    String expected = model.getLocArray(0);
    assertEquals(expected, actual);
  }

  /**
   * Test method for adding a longitude of type String into a longitude array.
   * {@link edu.elon.distance.DistanceModel#addLongArray(String)}.
   */
  @Test
  public void testaddLongArray() {
    model.addLongArray("-60");
    String actual = "-60";
    String expected = model.getLongArray(0);
    assertEquals(expected, actual);
  }

  /**
   * Test method for storing location, latitude, and longitude arrays into one
   * large array. {@link edu.elon.distance.DistanceModel#citiesArr(int)}.
   */

  @Test
  public void testcitiesArr() {

    model.addLocArray("Charleston");
    model.addLocArray("Delaware");
    model.addLocArray("Drexel");
    model.addLocArray("Elon");
    model.addLocArray("Northeastern");

    model.addLatArray("32.7842");
    model.addLatArray("39.6791");
    model.addLatArray("39.954");
    model.addLatArray("36.1072");
    model.addLatArray("42.3389");

    model.addLongArray("-79.9381");
    model.addLongArray("-75.7522");
    model.addLongArray("-75.188");
    model.addLongArray("-79.5013");
    model.addLongArray("-71.0903");

    newCities[0][0] = "Charleston";
    newCities[1][0] = "Delaware";
    newCities[2][0] = "Drexel";
    newCities[3][0] = "Elon";
    newCities[4][0] = "Northeastern";
    newCities[0][1] = "32.7842";
    newCities[1][1] = "39.6791";
    newCities[2][1] = "39.954";
    newCities[3][1] = "36.1072";
    newCities[4][1] = "42.3389";
    newCities[0][2] = "-79.9381";
    newCities[1][2] = "-75.7522";
    newCities[2][2] = "-75.188";
    newCities[3][2] = "-79.5013";
    newCities[4][2] = "-71.0903";

    String[][] actual = model.citiesArr(5);
    String[][] expected = newCities;
    Assert.assertArrayEquals(expected, actual);

  }
  
  /**
   * Test method for storing latitudes and longitudes into one array.
   * {@link edu.elon.distance.DistanceModel#numsArray(integer)}.
   */
  @Test
  public void testnumsArray() {
    model.addLatArray("32.7842");
    model.addLatArray("39.6791");
    model.addLatArray("39.954");
    model.addLatArray("36.1072");
    model.addLatArray("42.3389");

    model.addLongArray("-79.9381");
    model.addLongArray("-75.7522");
    model.addLongArray("-75.188");
    model.addLongArray("-79.5013");
    model.addLongArray("-71.0903");
    
    double [][] actual = model.numsArray(5);
    double [][] expected = longLat;
    Assert.assertArrayEquals(expected,actual);
  }
  
  /**
   * Test method for returning first city involved in the largest distance calculation
   * {@link edu.elon.distance.DistanceModel#city2(String[][])}.
   */
  @Test
  public void testcity1() {
    model.getMaximumDistance(longLat, 5);
    
    newCities[0][0] = "Charleston";
    newCities[1][0] = "Delaware";
    newCities[2][0] = "Drexel";
    newCities[3][0] = "Elon";
    newCities[4][0] = "Northeastern";
    newCities[0][1] = "32.7842";
    newCities[1][1] = "39.6791";
    newCities[2][1] = "39.954";
    newCities[3][1] = "36.1072";
    newCities[4][1] = "42.3389";
    newCities[0][2] = "-79.9381";
    newCities[1][2] = "-75.7522";
    newCities[2][2] = "-75.188";
    newCities[3][2] = "-79.5013";
    newCities[4][2] = "-71.0903";

    
    String actual = model.city1(newCities);
    String expected = "Charleston";
    assertEquals(expected, actual);
  }
  
  /**
   * Test method for returning second city involved in the largest distance calculation
   * {@link edu.elon.distance.DistanceModel#city2(String[][])}.
   */
  @Test
  public void testcity2() {
    model.getMaximumDistance(longLat, 5);
    
    newCities[0][0] = "Charleston";
    newCities[1][0] = "Delaware";
    newCities[2][0] = "Drexel";
    newCities[3][0] = "Elon";
    newCities[4][0] = "Northeastern";
    newCities[0][1] = "32.7842";
    newCities[1][1] = "39.6791";
    newCities[2][1] = "39.954";
    newCities[3][1] = "36.1072";
    newCities[4][1] = "42.3389";
    newCities[0][2] = "-79.9381";
    newCities[1][2] = "-75.7522";
    newCities[2][2] = "-75.188";
    newCities[3][2] = "-79.5013";
    newCities[4][2] = "-71.0903";

    
    String actual = model.city2(newCities);
    String expected = "Northeastern";
    assertEquals(expected, actual);
  }


}

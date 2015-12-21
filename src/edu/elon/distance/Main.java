/*
 * Main.java 1.0 Feb 19, 2015
 *
 * Copyright (c) 2015 David T. Han
 * Campus Box 3360, Elon University, Elon, NC 27244
 */
package edu.elon.distance;

/**
 * create a class that initiates the entire program to begin interacting with
 * the user.
 *
 * @author dhan
 * @version 1.0
 * @since 1.0
 * 
 */
public class Main {

  /**
   * Using an interface requires user to select how they would prefer to input
   * information: by console or jOptionPane. User must select which code to
   * comment out in order to begin running the program.
   *
   * @param args
   */
  public static void main(String[] args) {
    DistanceController controller = new DistanceController();
    DistanceUserInterface ui = null;
    ui = new DistanceInputOutputView();
    //ui = new DistanceInputOutputConsole();
    controller.setUi(ui);
    controller.go();
    System.exit(0);
  }

}
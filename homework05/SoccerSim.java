/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  SoccerSim.java
 *  Purpose       :  Simulates a user inputed number of soccer balls kicked on a field.
 *  @author       :  B.J. Johnson
 *  Date          :  2018-03-06
 *  Description   :
 *  Warnings      :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2018-03-30  Rohan Bramhe  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class SoccerSim{
  public static void main( String[] args ){
    Ball flag = new Ball(0,0,0,0);
    double fieldLength = 200;
    double maxSpeed = 50;
    int maxballNumber = 200;
    Scanner reader = new Scanner(System.in);
    System.out.println("How many soccer balls are on the field? ");
    int ballNumber = reader.nextInt();
    if (ballNumber <= 1 || ballNumber > maxballNumber){
      System.out.println("Enter a valid number of balls.");
    }
    reader = new Scanner(System.in);
    System.out.println("Time slice (enter 0 if you don't have a time split): ");
    double timeSplit = reader.nextDouble();
    if (timeSplit < 0){
      System.out.println("Enter a valid time slice.");
    }
    if (timeSplit == 0){
      timeSplit = 1;
    }
    int i = 0;
    double[] xList = new double[ballNumber];
    double[] yList = new double[ballNumber];
    double[] xSpeedList = new double[ballNumber];
    double[] ySpeedList = new double[ballNumber];
    Ball balls = null;
    while(i < ballNumber){
      if(ballNumber>maxballNumber || ballNumber<1 || timeSplit<0){
        System.out.println("Either the ball number or the time split is incorrect");
        break;
      }
      double x = ( Math.random() * 2 * fieldLength ) -fieldLength;
      double y = ( Math.random() * 2 * fieldLength ) - fieldLength;
      double xSpeed = ( Math.random() * 2 * maxSpeed ) - maxSpeed;
      double ySpeed = ( Math.random() * 2 * maxSpeed ) - maxSpeed;
      xList[i] = x;
      yList[i] = y;
      xSpeedList[i] = xSpeed;
      ySpeedList[i] = ySpeed;
      i = i + 1;
      System.out.println("Ball " + i + " : " + x + "," + y + "   Speed: " + xSpeed + "," + ySpeed);
      balls = new Ball(x,y,xSpeed,ySpeed);
    }
    if (balls.VerifyCollision(xList, yList) == false){
      System.out.println("No initial collision.");
    }
    else{
      System.out.println("Initial collision.");
    }
    Clock c = new Clock(0,0,0);
    double maxCurrentSpeed = 1.1;
    while( true ){
      maxCurrentSpeed = balls.getMaxSpeed(xSpeedList, ySpeedList);
      System.out.println(" ");
      System.out.println("Current positions:");
      System.out.println("Max Speed: " + maxCurrentSpeed);
      if (balls.VerifyCollision(xList, yList)){
        break;
      }
      if (balls.CollisionFlag(xList, yList)){
        break;
      }
      else{
        xList = balls.updatexList(xList, xSpeedList, timeSplit);
        yList = balls.updateyList(yList, ySpeedList, timeSplit);
        i=0;
        while(i<ballNumber){
          System.out.println("Ball " + (i+1));
          System.out.println(xList[i] + "," + yList[i]);
          i = i + 1;
        }
        System.out.println("No collision at " + c.hours + ":" + c.minutes + ":" + c.seconds);
      }
      c.tick(timeSplit);
      if (Math.abs(maxCurrentSpeed)<1){
        System.out.println("NO COLLISION POSSIBLE.");
        break;
      }
    }
    }
  }

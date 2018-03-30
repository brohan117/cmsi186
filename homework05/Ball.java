/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Ball.java
 *  Purpose       :  Provides a class describing a ball that can be kicked.
 *  @author       :  Rohan Bramhe
 *  Date          :  2017-03-30
 *  Description   :
 *  Warnings      :
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2018-03-30  Rohan Bramhe  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.lang.Math;
import java.util.Arrays;

public class Ball{
  double x1;
  double y1;
  double x2;
  double y2;
  double xSpeed;
  double ySpeed;
  double radius;
  int hours;
  int minutes;
  double seconds;
  double fieldLength;
  double[] time;
  double maxCurrentSpeed;


  public Ball(double x1, double y1, double xSpeed, double ySpeed){
    double radius = 4.45;
    this.radius = radius;
    this.x1= x1;
    this.y1 = y1;
    this.xSpeed = xSpeed;
    this.ySpeed = ySpeed;
  }

  public boolean CollisionFlag(double[] xList, double[] yList){
    Ball balls = null;
    int a = 0;
    while (a< (xList.length)){
      double d = Math.sqrt( Math.pow(xList[a], 2) + Math.pow(yList[a], 2) );
      if(d < 4.45){
        System.out.println("Collision between ball number " + (a+1) + " and the flagpole");
        return true;
      }
      else{
        a = a +1;
      }
    }
    return false;
  }

  public boolean VerifyCollision(double[] xList, double[] yList){
    Ball balls = null;
    int a = 0;
    int b = 1;
    while (a< (xList.length-1)){
      double d = Math.sqrt( (Math.pow(Math.abs(xList[b]-xList[a]),2)) + (Math.pow(Math.abs(yList[b]-yList[a]),2)) );
      if(d<8.9){
        System.out.println("Collision between ball number " + (a+1) + " and ball number " + (b+1));
        return true;
      }
      else{
        b = b + 1;
      }
      if(b == xList.length){
        b = a+2;
        a = a + 1;
      }
    }
    return false;
  }

  public double[] updatexList(double[] xList, double[] xSpeedList, double timeSplit){
    int i = 0;
    while(i < timeSplit){
      int j = 0;
      while(j < xList.length){
        xList[j] = xList[j] + (xSpeedList[j]);
        xSpeedList[j] = xSpeedList[j] * 0.99;
        j = j + 1;
      }
      i = i+1;
    }
    return xList;
  }

  public double[] updateyList(double[] yList, double[] ySpeedList, double timeSplit){
    int i = 0;
    while(i < timeSplit){
      int j = 0;
      while(j < yList.length){
        yList[j] = yList[j] + (ySpeedList[j]);
        ySpeedList[j] = ySpeedList[j] * 0.99;
        j = j + 1;
      }
      i = i+1;
    }
    return yList;
  }

  public double getMaxSpeed(double[] xSpeedList, double[] ySpeedList){
    int i = 0;
    maxCurrentSpeed = 0;
    while(i<xSpeedList.length){
      if(xSpeedList[i]<0){
        xSpeedList[i] = -1 * xSpeedList[i];
      }
      if(ySpeedList[i]<0){
        ySpeedList[i] = -1 * ySpeedList[i];
      }
      if(maxCurrentSpeed < xSpeedList[i]){
        maxCurrentSpeed = xSpeedList[i];
      }
      if(maxCurrentSpeed < ySpeedList[i]){
        maxCurrentSpeed = ySpeedList[i];
      }
      i = i+1;
    }
    return maxCurrentSpeed;
  }

  public static void main( String[] args ){
    Ball a = new Ball(1, 2, 3, 4);
    Ball b = new Ball(5, 6, 7, 8);
    System.out.println("x value of a: " + a.x1);
    System.out.println("y value of a: " + a.y1);
    System.out.println("xSpeed value of a: " + a.xSpeed);
    System.out.println("ySpeed value of a: " + a.ySpeed);
    System.out.println(" ");
    System.out.println("x value of b: " + b.x1);
    System.out.println("y value of b: " + b.y1);
    System.out.println("xSpeed value of b: " + b.xSpeed);
    System.out.println("ySpeed value of b: " + b.ySpeed);
    System.out.println(" ");
    /**We expect to get all numbers in order (1 to 8) because of the "this.x1 = x1... in our constructor.
    */
    Ball c = new Ball(-1, -2.5, 0, -7);
    System.out.println("x value of c: " + c.x1);
    System.out.println("y value of c: " + c.y1);
    System.out.println("xSpeed value of c: " + c.xSpeed);
    System.out.println("ySpeed value of c: " + c.ySpeed);
    System.out.println("Radius value of c: " + c.radius);
    System.out.println(" ");
    /** We expect to get all numbers in order (9 to 6) plus the ball's radius, 4.45.
    I tried inputting a value that wasn't a double and the program wouldn't compile.
    */
    Ball d = new Ball(123.45, 234.5,  3.45, 4.5);
    System.out.println("x value of d: " + d.x1);
    System.out.println("y value of d: " + d.y1);
    System.out.println("xSpeed value of d: " + d.xSpeed);
    System.out.println("ySpeed value of d: " + d.ySpeed);
    System.out.println("Radius value of d: " + d.radius);
    System.out.println(" ");
    /** We expect to get all numbers in order plus the ball's radius, 4.45.
    */
    Ball e = new Ball(77, -77,  77, -77);
    System.out.println("x value of e: " + e.x1);
    System.out.println("y value of e: " + e.y1);
    System.out.println("xSpeed value of e: " + e.xSpeed);
    System.out.println("ySpeed value of e: " + e.ySpeed);
    System.out.println("Radius value of e: " + e.radius);
    /** We expect to get all numbers in order plus the ball's radius, 4.45.
    */
    System.out.println(" ");
    System.out.println("Collision with a flag at position 0,0: " + a.CollisionFlag(new double[] { 123.0, 80.0, -1.0, 103.0}, new double[] {200.0, 60.0, -2.0, 73.0}));
    /** We expect to get a true output, ball number 3 is colliding with the flagpole at the start.
    */
    System.out.println("Collision with a flag at position 0,0: " + a.CollisionFlag(new double[] { -60.0, 81.0, 124.0, 197.0}, new double[] {36.0, -103.0, 116.0, 91.0}));
    /** We expect to get a false output, no ball hits the flagpole at the start.
    */
    System.out.println("Collision with a flag at position 0,0: " + a.CollisionFlag(new double[] { -161.0, -125.0, 0.0}, new double[] {-41.0, -169.0, 2.0}));
    /** We expect to get a true output, ball number 3 is colliding with the flagpole at the start.
    */
    System.out.println(" ");
    System.out.println("Verify Collision between more than 2 balls: " + a.VerifyCollision(new double[] { 123.0, 80.0, -1.0, 1.0}, new double[] {200.0, 60.0, -2.0, 0.0}));
    /** We expect to get a true output, the balls are colliding at the start.
    */
    System.out.println("Verify Collision between more than 2 balls: " + a.VerifyCollision(new double[] { -200.0, -200.0, 200.0, 200.0}, new double[] {-200.0, 200.0, 200.0, -200.0}));
    /** We expect to get a false output, the balls are not colliding at the start.
    */
    System.out.println("Verify Collision between more than 2 balls: " + a.VerifyCollision(new double[] { 134, -58.0, -91.0, -79.0, 103}, new double[] {85.0, -82.0, 143.0, 167.0, -28}));
    /** We expect to get a false output, the balls are not colliding at the start.
    */
    System.out.println("Verify Collision between more than 2 balls: " + a.VerifyCollision(new double[] { 0.0, -200.0, 3.0, 200.0}, new double[] {0.0, 200.0, 1.0, -200.0}));
    /** We expect to get a true output, the balls are colliding at the start.
    */
    System.out.println("Verify Collision between more than 2 balls: " + a.VerifyCollision(new double[] { 0.0, -200.0, 100.0, 102.0}, new double[] {0.0, 200.0, 100.0, 99.0}));
    /** We expect to get a true output, the balls are colliding at the start.
    */
    System.out.println(" ");
    System.out.println("Update xList & yList test (timeSplit = 3):");
    double[] xList = {a.x1, b.x1, c.x1, d.x1, e.x1};
    double[] xSpeedList = {a.xSpeed, b.xSpeed, c.xSpeed, d.xSpeed, e.xSpeed};
    double[] yList = {a.y1, b.y1, c.y1, d.y1, e.y1};
    double[] ySpeedList = {a.ySpeed, b.ySpeed, c.ySpeed, d.ySpeed, e.ySpeed};
    System.out.println("Initial xList: " + Arrays.toString(xList));
    System.out.println("Updated xList: " + Arrays.toString(a.updatexList(xList, xSpeedList, 3)));
    System.out.println("Initial yList: " + Arrays.toString(yList));
    System.out.println("Updated yList: " + Arrays.toString(a.updatexList(yList, ySpeedList, 3)));
    /** We expect to get the updated values of x and y to appear in order in the arrays xList and ylist.
    */
    System.out.println(" ");
    System.out.println("Max speed: " + a.getMaxSpeed(new double[] { 123.0, 80.0, -1.0, 1.0}, new double[] {200.0, 60.0, -2.0, 0.0}));
    /** We expect to get 200 as a result.
    */
    System.out.println("Max speed: " + a.getMaxSpeed(new double[] { 0.0, -200.0, 100.0, 102.0}, new double[] {0.0, 100.0, 100.0, 99.0}));
    /** We expect to get 200 as a result.
    */
    System.out.println("Max speed: " + a.getMaxSpeed(new double[] { 134, -58.0, -91.0, -79.0, 103}, new double[] {85.0, -82.0, 143.0, 167.0, -28}));
    /** We expect to get 167 as a result.
    */
    System.out.println("Max speed: " + a.getMaxSpeed(new double[] { -134, 58.0, 11.0}, new double[] {85.0, -82.0, 14.0}));
    /** We expect to get 134 as a result.
    */
    System.out.println("Max speed: " + a.getMaxSpeed(new double[] { 123.0, 80.0, -1.0}, new double[] {0.0, 100.0, 100.0}));
    /** We expect to get 123 as a result.
    */
  }
}

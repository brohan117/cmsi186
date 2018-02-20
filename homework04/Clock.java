/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Clock.java
 *  Purpose       :  Provides a class defining methods for the ClockSolver class
 *  @author       :  Rohan Bramhe
 *  Date written  :  2017-02-20
 *  Description   :  This class provides a bunch of methods which may be useful for the ClockSolver class
 *                   for Homework 4, part 1.  Includes the following:
 *
 *  Notes         :  None right now.  I'll add some as they occur.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-28  B.J. Johnson  Initial writing and release
 *  @version 1.0.1  2018-02-20  Rohan Bramhe  Fill in methods and headers
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
public class Clock {
  int hours;
  int minutes;
  double seconds;
  double hoursAngle;
  double minutesAngle;
  double secondsAngle;
  double angle;
  double delta;
  double timeSplit;

    private static final double DEFAULT_TIME_SLICE_IN_SECONDS = 60.0;
    private static final double INVALID_ARGUMENT_VALUE = -1.0;
    private static final double MAXIMUM_DEGREE_VALUE = 360.0;
    private static final double HOUR_HAND_DEGREES_PER_SECOND = 0.00784;
    private static final double MINUTE_HAND_DEGREES_PER_SECOND = 0.1;

  public Clock(int hours, int minutes, double seconds){
    try{
    if (hours < 0 || hours > 12){
      throw new IllegalArgumentException();
    }
  }
    catch (Exception e){
      System.err.println("Enter a valid number of hours.");
    }
    try{
    if (minutes < 0 || minutes > 60){
      throw new IllegalArgumentException();
    }
  }
    catch (Exception e){
      System.err.println("Enter a valid number of minutes.");
    }
    try{
    if (seconds < 0 || seconds > 60){
      throw new IllegalArgumentException();
    }
  }
    catch (Exception e){
      System.err.println("Enter a valid number of seconds.");
    }
    this.hours = hours;
    this.minutes = minutes;
    this.seconds = seconds;
  }

  public double gethoursAngle(){
    hoursAngle = hours*30 + minutes*0.5 + seconds*0.008333;
    while (hoursAngle >= 360){
      hoursAngle = hoursAngle - 360;
    }
    return hoursAngle;
  }

  public double getminutesAngle(){
    minutesAngle = minutes*6 + seconds*0.1;
    while (minutesAngle >= 360){
      minutesAngle = minutesAngle - 360;
    }
    return minutesAngle;
  }

  public double getangle(double hoursAngle, double minutesAngle){
    angle = Math.abs(hoursAngle - minutesAngle);
    if (angle > 180){
      angle = 360 - angle;
    }
    return angle;
  }

  public void tick(double timeSplit){
    this.seconds = this.seconds + timeSplit;
    while (this.seconds >= 60)  {
      this.seconds = this.seconds - 60;
      this.minutes = this.minutes + 1;
      while(this.minutes >= 60) {
        this.minutes = this.minutes - 60;
        this.hours = this.hours + 1;
    if (this.hours > 12){
    System.out.println("Done!");
    }
      }
    }
  }

  public double getdelta(double timeSplit){
    delta = (timeSplit * 10) / 240;
    return delta;
  }

  public static void main( String[] args ) {
    Clock a = new Clock(12, 30, 0);
    System.out.println(a.gethoursAngle());
    System.out.println(a.getminutesAngle());
    System.out.println(a.getangle(a.gethoursAngle(), a.getminutesAngle()));
    a.tick(180);
    System.out.println(a.hours);
    System.out.println(a.minutes);
    System.out.println(a.seconds);
    System.out.println(a.getdelta(90));
  }

}

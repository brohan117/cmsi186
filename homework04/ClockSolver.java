/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  ClockSolver.java
 *  Purpose       :  The main program for the ClockSolver class
 *  @see
 *  @author       :  Rohan Bramhe
 *  Date written  :  2018-02-20
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
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Scanner;

public class ClockSolver {

    public static void main( String[] args ) {
      Scanner reader = new Scanner(System.in);
      System.out.println("Enter an angle: ");
      double userangle = reader.nextDouble();
      if (userangle < 0 || userangle > 360){
        System.out.println("Enter a valid angle");
      }
      reader = new Scanner(System.in);
      System.out.println("Enter a time split (enter 0 if there's no time split): ");
      double timeSplit = reader.nextDouble();
      if (timeSplit == 0){
        System.out.println("Setting time split to 60 seconds.");
        timeSplit = 60;
      }
      if (timeSplit < 0 || timeSplit > 1800){
        System.out.println("Enter a valid time split");
      }
      double time = 0;
      Clock a = new Clock(0,0,0);
      System.out.println("The clock's hands are at " + userangle + " degrees at these times:" );
      while (time <= 43200){
        if ( (a.getangle(a.gethoursAngle(), a.getminutesAngle() ) > ( userangle - a.getdelta(timeSplit)) ) &&               ( a.getangle(a.gethoursAngle(), a.getminutesAngle())  < (userangle + a.getdelta(timeSplit)))){
          System.out.println((a.hours) + ":" + (a.minutes) + ":" + (a.seconds));
          a.tick(timeSplit);
          time = time + timeSplit;
        }
        else{
          a.tick(timeSplit);
          time = time + timeSplit;
        }
      }
    }
  }

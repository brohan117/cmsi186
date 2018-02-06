/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Die.java
 *  Purpose       :  Provides a class describing a single die that can be rolled
 *  @author       :  Rohan Bramhe
 *  Date          :  2018-02-06
 *  Description   :  This class provides the data fields and methods to describe a single game die.  A
 *                   die can have "N" sides.  Sides are randomly assigned sequential pip values, from 1
 *                   to N, with no repeating numbers.  A "normal" die would thus has six sides, with the
 *                   pip values [spots] ranging in value from one to six.  Includes the following:
 *                   public Die( int nSides );                  // Constructor for a single die with "N" sides
 *                   public int roll();                         // Roll the die and return the result
 *                   public int getSides()                      // get the number of sides on this die
 *                   public int getValue()                      // get the value of this die
 *                   public void setSides()                     // change the configuration and return the new number of sides
 *                   public String toString()                   // Instance method that returns a String representation
 *                   public static String toString()            // Class-wide method that returns a String representation
 *                   public static void main( String args[] );  // main for testing porpoises
 *
 *  Notes         :  Restrictions: no such thing as a "two-sided die" which would be a coin, actually.
 *                   Also, no such thing as a "three-sided die" which is a physical impossibility without
 *                   having it be a hollow triangular prism shape, presenting an argument as to whether
 *                   the inner faces are faces which then should be numbered.  Just start at four for
 *                   minimum number of faces.  However, be aware that a four-sided die dosn't have a top
 *                   face to provide a value, since it's a tetrahedron [pyramid] so you'll have to figure
 *                   out a way to get the value, since it won't end up on its point.
 *
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the number of sides or pips is out of range
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-06  B.J. Johnson  Initial writing and release
 *  @version 1.0.1  2018-02-06  Rohan Bramhe  Fill in methods
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
public class Die {

  /**
   * private instance data
   */
   public int sides;
   public int pips;
   private int MINIMUM_SIDES = 4;

   // public constructor:
  /**
   * constructor
   * @param sides int value containing THIS card's rank
   * @throws      IllegalArgumentException
   * Note: parameter must be checked for validity; invalid value must throw "IllegalArgumentException"
   */
   public Die( int nSides ) {
     try{
     if (nSides < MINIMUM_SIDES){
       throw new IllegalArgumentException("Enter a larger number");
     }
   }
     catch (Exception e){
       System.err.println("Value entered is not valid.");
     }
     this.sides = nSides;
     this.pips = 0;
   }

  /**
   * Roll the die and return the result
   * @return  integer value of the result of the roll, whatever would be on top, randomly selected
   * @throws  IllegalArgumentException
   */
   public int roll() {
     int roll = (int) (Math.random() * sides) + 1;
     this.pips = roll;
      System.out.println( " " );
      return roll;
   }

  /**
   * @return the side count of THIS die instance
   */
   public int getSides() {
      return this.sides;
   }

  /**
   * @return the pip count of THIS die instance; whatever is on top when the die stops rolling
   */
   public int getValue() {
      return this.pips;
   }

   public int setValue(int kValue) {
     try{
     if(kValue < 0 || kValue > sides){
       throw new IllegalArgumentException("Enter a valid number");
     }
   }
     catch (Exception e){
       System.err.println("Value entered is not valid.");
     }
      this.pips = kValue;
      return getValue();
   }
  /**
   * @param  int  the number of sides to set/reset for this Die instance
   * @return      The new number of sides, in case anyone is looking
   * @throws      IllegalArgumentException
   */
   public int setSides( int nSides ) {
     try{
     if (nSides < MINIMUM_SIDES){
       throw new IllegalArgumentException("Enter a larger number");
     }
   }
     catch (Exception e){
       System.err.println("Value entered is not valid.");
     }
      this.sides = nSides;
      return nSides;
   }

  /**
   * @return Public Instance method that returns a String representation of THIS die instance
   * @throws UnsupportedOperationException
   */
   public String toString() {
     String stringSides = Integer.toString(this.sides);
      return stringSides;
   }

  /**
   * @return Class-wide method that returns a String representation of THIS die instance
   */
   public static String toString( Die d ) {
     String stringSides = Integer.toString(d.getSides());
      return stringSides;
   }

  /**
   * A little test main to check things out
   */
   public static void main( String[] args ) {
      Die d = new Die( 6 );
      System.out.println("Die d");
      System.out.println("First roll, 6 sides: " + d.roll());
      System.out.println("Second roll, 6 sides: " + d.roll());
      System.out.println("Get Sides: " + d.getSides());
      System.out.println("Get value: " + d.getValue());
      System.out.println("Set value to 4: " + d.setValue(4));
      System.out.println("Set sides to 12: " + d.setSides(12));
      System.out.println("Public to string: " + d.toString());
      System.out.println("class wide to string: " + d.toString(d));
      System.out.println();

      Die e = new Die( 8 );
      System.out.println("Die e");
      System.out.println("First roll, 8 sides: " + e.roll());
      System.out.println("Second roll, 8 sides: " + e.roll());
      System.out.println("Get Sides: " + e.getSides());
      System.out.println("Get value: " + e.getValue());
      System.out.println("Set value to 4: " + e.setValue(4));
      System.out.println("Set sides to 16: " + e.setSides(16));
      System.out.println("Public to string: " + e.toString());
      System.out.println("class wide to string: " + e.toString(e));
      System.out.println();

      Die f = new Die( 10 );
      System.out.println("Die f");
      System.out.println("First roll, 10 sides: " + f.roll());
      System.out.println("Second roll, 10 sides: " + f.roll());
      System.out.println("Get Sides: " + f.getSides());
      System.out.println("Get value: " + f.getValue());
      System.out.println("Set value to 4: " + f.setValue(4));
      System.out.println("Set sides to 16: " + f.setSides(16));
      System.out.println("Public to string: " + f.toString());
      System.out.println("class wide to string: " + f.toString(f));
      System.out.println();

      Die g = new Die( 12 );
      System.out.println("Die g");
      System.out.println("First roll, 12 sides: " + g.roll());
      System.out.println("Second roll, 12 sides: " + g.roll());
      System.out.println("Get Sides: " + g.getSides());
      System.out.println("Get value: " + g.getValue());
      System.out.println("Set value to 4: " + g.setValue(4));
      System.out.println("Set sides to 16: " + g.setSides(16));
      System.out.println("Public to string: " + g.toString());
      System.out.println("class wide to string: " + g.toString(g));
      System.out.println();

      Die h = new Die( 3 );
      System.out.println("Die h");
      System.out.println("First roll, 3 sides: " + h.roll());
      System.out.println("Second roll, 3 sides: " + h.roll());
      System.out.println("Get Sides: " + h.getSides());
      System.out.println("Get value: " + h.getValue());
      System.out.println("Set value to 4: " + h.setValue(4));
      System.out.println("Set sides to 20: " + h.setSides(20));
      System.out.println("Public to string: " + h.toString());
      System.out.println("class wide to string: " + h.toString(h));
   }

}

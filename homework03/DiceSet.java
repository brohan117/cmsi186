/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  DiceSet.java
 *  Purpose       :  Provides a class describing a set of dice
 *  Author        :  Rohan Bramhe
 *  Date          :  2018-02-09
 *  Description   :  This class provides everything needed (pretty much) to describe a set of dice.  The
 *                   idea here is to have an implementing class that uses the Die.java class.  Includes
 *                   the following:
 *                   public DiceSet( int k, int n );                  // Constructor for a set of k dice each with n-sides
 *                   public int sum();                                // Returns the present sum of this set of dice
 *                   public void roll();                              // Randomly rolls all of the dice in this set
 *                   public void rollIndividual( int i );             // Randomly rolls only the ith die in this set
 *                   public int getIndividual( int i );               // Gets the value of the ith die in this set
 *                   public void setIndividual( int i, int jValue );  // Sets the ith die in this set to the value of jValue
 *                   public String toString();                        // Returns a stringy representation of this set of dice
 *                   public static String toString( DiceSet ds );     // Classwide version of the preceding instance method
 *                   public boolean isIdentical( DiceSet ds );        // Returns true iff this set is identical to the set ds
 *                   public static void main( String[] args );        // The built-in test program for this class
 *
 *  Notes         :  Stolen from Dr. Dorin pretty much verbatim, then modified to show some interesting
 *                   things about Java, and to add this header block and some JavaDoc comments.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the number of sides or pips is out of range
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-09  B.J. Johnson  Initial writing and release
 *  @version 1.0.1  2018-02-06  Rohan Bramhe  Fill in methods
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
public class DiceSet {

  /**
   * private instance data
   */
   private int count;
   private int sides;
   private Die[] dieArray;

   // public constructor:
  /**
   * constructor
   * @param  count int value containing total dice count
   * @param  sides int value containing the number of pips on each die
   * @throws IllegalArgumentException if one or both arguments don't make sense
   * @note   parameters are checked for validity; invalid values throw "IllegalArgumentException"
   */
   public DiceSet( int count, int sides ) {
      try{
         if(count < 1 || sides < 4){
            throw new IllegalArgumentException("Enter a valid count and valid number of sides : ");
         }
      }
      catch (Exception e){
         System.err.println("Value(s) entered is/are not valid.");
      }
      this.count = count;
      this.sides = sides;
      this.dieArray = new Die[count];
      int i = 0;
      while (i < count){
         Die a = new Die(sides);
         this.dieArray[i] = a;
         i = i + 1;
      }
   }

  /**
   * @return the sum of all the dice values in the set
   */
   public int sum() {
     int i = 0;
     int sum = 0;
     while (i < count){
       sum = sum + this.dieArray[i].getValue();
       i = i + 1;
     }
      return sum;
   }

  /**
   * Randomly rolls all of the dice in this set
   */
   public void DiceSetroll() {
     int i = 0;
     while (i < count){
       this.dieArray[i].pips = this.dieArray[i].roll();
       i = i + 1;
     }
   }

  /**
   * Randomly rolls a single die of the dice in this set
   * @param  dieIndex int of which die to roll
   * @trhows IllegalArgumentException if the index is out of range
   */
   public int rollIndividual( int dieIndex ) {
     int a = 0;
     a = this.dieArray[dieIndex].roll();
     return a;
   }

  /**
   * Gets the value of the die in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @trhows IllegalArgumentException if the index is out of range
   */
   public int getIndividual( int dieIndex ) {
     return this.dieArray[dieIndex].getValue();
   }

  /**
   * Gets the value of the die in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to set the value of
   * @param  dieValue int of the value to set for that die
   * @trhows IllegalArgumentException if the index is out of range
   */
   public void setIndividual( int dieIndex, int dieValue ) {
   }

  /**
   * @return Public Instance method that returns a String representation of the DiceSet instance
   */
   public String toString() {
     int i = 0;
     String stringArray = "";
     while (i < count){
       stringArray = stringArray + "[" +String.valueOf(this.dieArray[i].getValue()) + "]";
       i = i + 1;
     }
     return stringArray;
   }

  /**
   * @return Class-wide version of the preceding instance method
   */
   public static String toString( DiceSet ds ) {
      return "";
   }

  /**
   * @return  tru iff this set is identical to the set passed as an argument
   */
   public boolean isIdentical( DiceSet ds ) {
     if (ds.sum() == this.sum()){
       return true;
     }
     else{
       return false;
     }
   }
  /**
   * A little test main to check things out
   */
   public static void main( String[] args ) {
     DiceSet a = new DiceSet( 2, 6 );
     System.out.println("Two die, 6 sides each: " + a.sum());
     System.out.println("Roll second dice " + a.rollIndividual(1));
     System.out.println("Get individual dice value: " + a.getIndividual(1));
     System.out.println("Value to string: " + a.toString());
     a.DiceSetroll();
     System.out.println("Values to string after roll: " + a.toString());

     DiceSet b = new DiceSet(2,6);
     DiceSet c = new DiceSet(2,6);
     System.out.println(b);
     System.out.println(c);
     System.out.println("Is identical test: " + b.isIdentical(c));
   }

}

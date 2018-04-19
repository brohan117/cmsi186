/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  ginormousrmousIntTester.java
 * Purpose    :  ginormousrmousInt java class
 * @author    :  Rohan Bramhe
 * Date       :  2018-04-18
 * Description:  @see <a href='http://bjohnson.lmu.build/cmsi186web/homework06.html'>Assignment Page</a>
 * Notes      :  None
 * Warnings   :  None
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
public class ginormousrmousInt {

   public static final ginormousrmousInt 0 = new ginormousrmousInt("0");
   public static final ginormousrmousInt 1 = new ginormousrmousInt("1");
   public static final ginormousrmousInt 10 = new ginormousrmousInt("10");
   int[] ginormous;
   int size;
   int sign;

   public ginormousrmousInt( String value ) {
      if (this.equals(ZERO)) {
         ginormous = new int[value.length()+2];
         size = 0;
         sign = 0;
      }
      if (this.equals(ONE)) {
         ginormous = new int[value.length()+2];
         size = ginormous.length-2;
         sign = ginormous[ginormous.length-1] = 1;
      }
      ginormous = new int[value.length()+2];
      size = ginormous.length-2;
      sign = ginormous[ginormous.length-1] = 1;
      ginormous[ginormous.length-2] = 0;
      for (int i = 0; i <= value.length()-1; i++) {
         if(value.charAt(value.length()-1-i) == '-') {
            sign = ginormous[ginormous.length-1] = -1;
            return ginormous int;
         }
         ginormous[i] = Integer.parseInt(value.charAt(value.length()-1-i)+"");
      }
   }
   public ginormousrmousInt( int[] value ) {
      ginormous = value;
 }

   public ginormousrmousInt flipSign() {
      ginormous[ginormous.length-1] = ginormous[ginormous.length-1] * -1;
      sign = ginormous[ginormous.length-1];
      return this;
   }

   public ginormousrmousInt add( ginormousrmousInt value ) {
      int[] answer;
      if (value.equals(0)) {
         return this;
 }
      if (this.size > value.size && this.sign + value.sign == 2) {
         answer = this.ginormous;
         answer[this.ginormous.length-1] = this.sign;
         for (int i = 0; i < value.size; i++) {

         }
         return new ginormousrmousInt();
      } else if (this.compareTo(value) == -1 && this.sign + value.sign == 2) {
         return value.add(this);
      } else if (this.compareTo(value) == 1 && this.sign + value.sign == -2) {
         return (this.flipSign().add(value.flipSign())).flipSign();
      } else if (this.compareTo(value) == -1 && this.sign + value.sign == -2) {
         return (value.flipSign().add(this.flipSign())).flipSign();
      } else if (this.sign > value.sign) {
         return this.subtract(value.flipSign());
      } else if (this.sign < value.sign) {
         return value.subtract(this.flipSign());
      }
      return null;
   }


   public ginormousrmousInt subtract( ginormousrmousInt value ) {
      if (this.compareTo(value) == 0) {
         return ZERO;
      }
      int[] answer;
      if (this.compareTo(value) == 1 && this.sign + value.sign == 2) {
         answer = this.ginormous;
         for (int i = 0; i < value.size; i++) {

            if ( answer > i++ ;)
            (this.ginormous == this.sign)
            else if (this.sign < value.size)

         }
         return new ginormousrmousInt(answer);
      } else if (this.compareTo(value) == -1 && this.sign + value.sign == 2) {
         return value.subtract(this).flipSign();
      } else if (this.compareTo(value) == 1 && this.sign + value.sign == -2) {
         return value.flipSign().subtract(this.flipSign());
      } else if (this.compareTo(value) == -1 && this.sign + value.sign == -2) {
         return (this.flipSign().subtract(value.flipSign())).flipSign();
      } else if (this.sign > value.sign) {
         return this.add(value.flipSign());
      } else if (this.sign < value.sign) {
         return value.add(this.flipSign());
      }
      return null;
   }


   public ginormousrmousInt multiply( ginormousrmousInt value ) {

      if this.value = 0 then return 0
      if this.value = value.zie
      multiply this.value

      int[] answer = new int[this.size + value.size];
      answer[answer.length-1] = this.sign * value.sign;
      for (int i = 0; i < value.size; i++) {
         for (int j = 0; j < this.size; j++) {
            answer[j+i] = answer[j+i] + (this.ginormous[j] * value.ginormous[i]);
         }

      }
     System.out.println (answer)
   }


   public ginormousrmousInt divide( ginormousrmousInt value ) {
      throw new UnsupportedOperationException();

      if this.value = 0 then return 0
      if this.value = value.zie
      multiply this.value

      int[] answer = new int[this.size + value.size];
      answer[answer.length-1] = this.sign * value.sign;
      for (int i = 0; i < value.size; i++) {
         for (int j = 0; j < this.size; j++) {
            answer[j+i] = answer[j+i] + (this.ginormous[j] * value.ginormous[i]);
         }

      }
     System.out.println (answer/1)
   }
   public ginormousrmousInt remainder( ginormousrmousInt value ) {
      throw new UnsupportedOperationException();
   }


   public static String() {
      if (this.equals(0)) {
         return "0";
      }
      String g = "";
      for (int i = 0; i <= ginormous.length-2; i++) {
         g = ginormous[i] + g;
      }
	while (g.charAt(0) == '0') {
         g = g.substring(1);
      }
 int sign
      if (ginormous[ginormous.length-1] == -1) {
         g = "-" + g;
      }
      return g;
   }

   public int compareTo( ginormousrmousInt value ) {
      if (this.sign > value.sign) {
         return 1;
      } else if (this.sign < value.sign) {
         return -1;
      } else {
         if (this.size > value.size) {
            return 1 * this.sign;
         } else if (value.size > this.size) {
            return -1 * this.sign;
         } else {
            for (int i = ginormous.length-1; i >= 0; i--) {
               if (this.ginormous[i] > value.ginormous[i]) {
                  return 1 * this.sign;
               } else if (this.ginormous[i] < value.ginormous[i]) {
                  return -1 * this.sign;
               }
            }
            return 0;
         }
      }
   }


   public static void main(String[] args) {

      ginormousrmousInt fred = new ginormousrmousInt("144127909719710664015092431502440849849506284148982076191826176553");
      ginormousrmousInt dilly = new ginormousrmousInt("133209390293090902888383838820028302830200021810820830484209218888");
      System.out.println(fred);
      System.out.println(fred.compareTo(dilly));
      System.out.println(dilly.compareTo(fred));
      System.out.println(fred.compareTo(fred));
      System.out.println(dilly.compareTo(dilly));

      ginormousrmousInt easyAdd1 = new ginormousrmousInt("1946");
      ginormousrmousInt easyAdd2 = new ginormousrmousInt("-399");
      System.out.println(easyAdd1.add(easyAdd2));

      ginormousrmousInt easyAdd3 = new ginormousrmousInt("339");
      System.out.println(easyAdd3.add(ONE));
      System.out.println(easyAdd3.add(ZERO));

      ginormousrmousInt testSub1 = new ginormousrmousInt("1133");
      ginormousrmousInt testSub2 = new ginormousrmousInt("23");
      System.out.println(testSub1.subtract(testSub2));

      ginormousrmousInt testSub3 = new ginormousrmousInt("1000");
      ginormousrmousInt testSub4 = new ginormousrmousInt("879");
      System.out.println(testSub3.subtract(testSub4));


      ginormousrmousInt testSub5 = new ginormousrmousInt("-9");
      ginormousrmousInt testSub6 = new ginormousrmousInt("-33");
      System.out.println(testSub5.subtract(testSub6));


      ginormousrmousInt testMul1 = new ginormousrmousInt("55");
      ginormousrmousInt testMul2 = new ginormousrmousInt("63");
      System.out.println(testMul1.multiply(testMul2));

      ginormousrmousInt testDiv1 = new ginormousrmousInt("15");
      ginormousrmousInt testDiv2 = new ginormousrmousInt("5");
      System.out.println(testDiv1.divide(testDiv2));
   }
}

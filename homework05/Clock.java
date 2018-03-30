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
    while (this.seconds >= 60){
      this.seconds = this.seconds - 60;
      this.minutes = this.minutes + 1;
      while(this.minutes >= 60){
        this.minutes = this.minutes - 60;
        this.hours = this.hours + 1;
    if (this.hours > 12){
      System.out.println("Done!");
    }
      }
    }
  }

  public double getdelta(double timeSplit){
    delta = (timeSplit * 11) / 240;
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

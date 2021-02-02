/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 27.11.2019
  * @author 
  */

public abstract class Fahrzeug {
  
  protected int passenger;
  protected int maxSpeed;
  protected float co2;
  protected int type;




  public int getMaxSpeed() {
    return maxSpeed;
  }

  public void setMaxSpeed(int maxSpeed) {
    this.maxSpeed=maxSpeed;
  }

  public int getPassenger() {
    return passenger;
  }

  public void setPassenger(int passenger) {
    this.passenger=passenger;
  }

  public float getCo2() {
    return co2;
  }

  public int getType() {
    return type;
  }


} // end of class Fahrzeug


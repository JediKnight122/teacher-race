import javax.naming.event.NamespaceChangeListener;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 27.11.2019
  * @author 
  */

public abstract class Lehrer {
  
  protected int reaction;
  protected int acceleration;
  protected String name;
  protected String nachName;
  protected int vehicle;
  protected float s;
  protected float v;
  protected float vms;
  protected String typ;
  protected String siegesSpruch;

public Lehrer(){

}
  public Lehrer(String n, String nn, int r, int a) {
    name = n;
    nachName=nn;
    reaction = r;
    acceleration = a;
    System.out.println("Angelegt: Name="+n+" "+nachName+" Reaktion="+r+" Beschleunigung="+a);
  }
  public Lehrer(String n, String nn, int a) {
    name = n;
    nachName=nn;
    acceleration = a;
    System.out.println("Angelegt: Name="+n+" "+nachName+ " Beschleunigung="+a);
  }
  public void setV(int speed) {
    v=speed;
    vms=v*1000/3600;
  }

  public float getV(){
    return v;
  }

  public float getS(){
    return s;
  }

  public void setS(float strecke){
    s=strecke;
  }
  public void setReaction(int r) {
    reaction = r; 
  }
  public int getReaction() {
    return reaction; 
  }
  public void setAcceleration(int acceleration){this.acceleration=acceleration;}
  public String getName() {
    return name; 
  }
  public int getVehicle() {
    return vehicle; 
  }
  public void setVehicle(int v) {
    vehicle = v; 
  }

  public float getVms() {
    return vms;
  }

  public int getAcceleration() {
    return acceleration;
  }

  public String getNachName() {
    return nachName;
  }

  public void freuen(){
    System.out.print(name+" "+ nachName+" : `");
    System.out.println(siegesSpruch+"´");
  }

  public String getTyp(){ return typ;}
} // end of class Lehrer


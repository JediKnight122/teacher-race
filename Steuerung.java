/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 27.11.2019
  * @author 
  */
import java.util.*;
public class Steuerung {
  
  public static void main(String[] args) throws InterruptedException {  
    Scanner sc = new Scanner(System.in);
    int zufallsZahl;
    int vorNameAuswahl;
    int nachNameAuswahl;
    int anzLehrer;
    int streckenLaenge;
    double streckenGefaelleModifikator=1;
    int eingabe;
    int gewinnerNummer=-1;
    int spielGeschwindigkeit=1;

    //Namenlisten: beliebige, zusätzliche Anzahl an Namen einfach mit einem Komma hinten anfügen.
    String[] vorNamen={"Simon" ,"Finn", "Maren", "Michael", "Volker", "Billi", "Rey", "Pascal", "Saru", "Patrick"};
    String[] nachNamen={"Walter", "Stuerzel", "Wiskandt", "Schuh", "Weber", "J.", "Hau","Seifert","Skywalker", "Burnham"};


    //Streckennamen
    String[] strecken={"Rheinstrasse", "B-500", "Citytour", "Fremersberg", "Schwarzwaldhochstrasse (hoch)","Schwarzwaldhochstrasse (runter)", "Merkurtour"};


    //Eingabeaufforderung
    System.out.println("Wieviele Lehrer? ");
    anzLehrer = sc.nextInt();

    //Lehrer erstellen
    Lehrer[] lehrer = new Lehrer[anzLehrer];
    for (int i=0; i<lehrer.length; i++) {

      //Zufalls-Namen-Kombinationen
      vorNameAuswahl=(int) Math.floor(Math.random()*(vorNamen.length-0)+0);
      nachNameAuswahl=(int) Math.floor(Math.random()*(nachNamen.length-0)+0);
      zufallsZahl = (int) Math.floor(Math.random()*(3-1)+1);

      if (i>0) {
        //System.out.println("Lehrer "+i+" anlegen");

    switch (zufallsZahl) {
      case 1:
      lehrer[i]=new Normalo(vorNamen[vorNameAuswahl], nachNamen[nachNameAuswahl], (int) Math.floor(Math.random() * (20-2+1)+2), (int) Math.floor(Math.random() * (10-5+1)+5));
    break;
      case 2:
        lehrer[i]=new Theoretiker(vorNamen[vorNameAuswahl], nachNamen[nachNameAuswahl], (int) Math.floor(Math.random() * (20-2+1)+2), (int) Math.floor(Math.random() * (10-5+1)+5));
        break;
      case 3:
        lehrer[i]=new Praktiker(vorNamen[vorNameAuswahl], nachNamen[nachNameAuswahl], (int) Math.floor(Math.random() * (20-2+1)+2), (int) Math.floor(Math.random() * (10-5+1)+5));
        break;
    }

      } else {
        //System.out.println("Lehrer "+i+" anlegen");
        switch(zufallsZahl){
          case 1:
        lehrer[i]=new Normalo( vorNamen[vorNameAuswahl], nachNamen[nachNameAuswahl], (int) Math.floor(Math.random()*(10-5+1)+5));
        break;
          case 2:
            lehrer[i]=new Theoretiker( vorNamen[vorNameAuswahl], nachNamen[nachNameAuswahl], (int) Math.floor(Math.random()*(10-5+1)+5));
            break;
          case 3:
            lehrer[i]=new Praktiker( vorNamen[vorNameAuswahl], nachNamen[nachNameAuswahl], (int) Math.floor(Math.random()*(10-5+1)+5));
            break;
        }

      }     
    } // end of for
    //Autos zu Lehrer zuweisen
    System.out.println("------------------------------------");
    int vehicle;
    Fahrzeug[] fahrzeug = new Fahrzeug[lehrer.length];
    String[] fahrzeugName = new String[3];
    fahrzeugName[0] = "Pedelec";
    fahrzeugName[1] = "E-Auto";
    fahrzeugName[2] = "Formel1-Rennwagen";

    for (int i=0; i<lehrer.length; i++) {
      System.out.println("Bitte geben Sie ein Fahrzeug f\u00fcr "+lehrer[i].getName()+" "+lehrer[i].getNachName()+" an (1=Pedelec, 2=E-Auto, 3=Formel1)");
      vehicle = sc.nextInt();
      lehrer[i].setVehicle(vehicle);

      if (vehicle==1) {
        fahrzeug[i]=new Pedelec();
      }
      else if (vehicle==2){
        fahrzeug[i]=new EAuto();
      }
      else if (vehicle==3){
        fahrzeug[i]=new Rennwagen();
      }

    } // end of for

    //Streckenwahl
    System.out.println("Welche Stecke soll gefahren werden? Bitte 1 bis "+strecken.length+" eingeben.");
    for (int i=0; i<strecken.length; i++){
      System.out.println(i+1+". "+strecken[i]);
    }

    eingabe=sc.nextInt();
    Strecke strecke = new Strecke (eingabe);
    streckenLaenge=strecke.getLaenge();


    System.out.println("Alles klar! Das wird lustig!");
    System.out.println("Name der Strecke:  "+strecke.getName());
    System.out.println("L\u00e4nge der Strecke: "+streckenLaenge);
    System.out.println("Gef\u00e4lle der Strecke: "+strecke.getGefaelle());

    lehrer[0].setReaction(10);
    streckenGefaelleModifikator=strecke.getGefaelle();

    for (int i=0; i<lehrer.length; i++){
      lehrer[i].setAcceleration(lehrer[i].getAcceleration()+(int)(lehrer[i].getAcceleration()*(streckenGefaelleModifikator/100)));
      System.out.println("Beschleunigung für "+lehrer[i].getName()+" unter Berücksichtigung des Gefälles: "+lehrer[i].getAcceleration());
    }

    System.out.println("------------------------------------");

    for (int i=0; i<fahrzeug.length; i++){
      fahrzeug[i].setMaxSpeed(fahrzeug[i].getMaxSpeed()+(int)(fahrzeug[i].getMaxSpeed()*(streckenGefaelleModifikator/100)));
    }


    System.out.println("Wie schnell soll das Rennen ablaufen? 1 = Standard, 2 = Doppelt, ...");
    spielGeschwindigkeit=sc.nextInt();
    System.out.println("------------------------------------");
    System.out.println("Das Rennen kann beginnen! Am Start sind:");
    for (int i=0; i<lehrer.length; i++) {
      System.out.println(lehrer[i].getName()+" mit "+fahrzeugName[lehrer[i].getVehicle()-1]);
    } // end of for
    System.out.println("------------------------------------");
    for (int i = 10; i > 0; i--) {
      System.out.print("\r" + i + "...");
      System.out.flush();
      Thread.sleep(1000/spielGeschwindigkeit);
    }
    System.out.println("\rLos!!");
    String gewinner="";  
    int cnt=1;
    int newV;

    while (gewinner.equals("")) { 

      System.out.println(cnt+" ------------------------------------");
      for (int i=0; i<lehrer.length; i++) {
        System.out.println(lehrer[i].getName()+ " v="+lehrer[i].getV()+/*" vms="+lehrer[i].vms+*/" s="+lehrer[i].getS());
            if (lehrer[i].getS()>streckenLaenge) {

              //System.out.println("Gewinnernummer: "+i);

              gewinnerNummer=i;
            gewinner=lehrer[i].getName();
            
          } // end of if

        //Berechnung Strecke und Geschwindigkeit
        if (cnt>=lehrer[i].getReaction()) {

          //Speed erh�hen falls noch nicht maxSpeed
          if (lehrer[i].getV()<fahrzeug[i].getMaxSpeed()) {
            newV=(int)lehrer[i].getV()+(lehrer[i].getAcceleration()+(lehrer[i].getAcceleration() *((int)streckenGefaelleModifikator/100)));
            if (newV>fahrzeug[i].getMaxSpeed()) {
              newV=fahrzeug[i].getMaxSpeed();
            } // end of if
            lehrer[i].setV(newV);
          } // end of if
          //Strecke berechnen
          float gefahreneStrecke = lehrer[i].getVms()+lehrer[i].getS();
          lehrer[i].setS(gefahreneStrecke);

        } // end of if
      } // end of for
      Thread.sleep(1000/spielGeschwindigkeit);
      //Abbruch falls kein Gewinner
      cnt++;
      if (cnt>70) {
        gewinner="keiner, Zeitabbruch";
      } // end of if
    }
    System.out.println("-------------------------");
    System.out.println("Der Gewinner ist... "+gewinner);

    if (!gewinner.equals("keiner, Zeitabbruch")) {

      lehrer[gewinnerNummer].freuen();

      int counter=0;
      int fahrzeugNummerVMax=0;

      for (int i=0; i <= fahrzeug.length-1; i++) {

        if (fahrzeug[gewinnerNummer].getMaxSpeed() >= fahrzeug[i].getMaxSpeed()) {
          counter++;
        }
        else {
          if (fahrzeug[fahrzeugNummerVMax].getMaxSpeed()<=fahrzeug[i].getMaxSpeed()){
            fahrzeugNummerVMax=i;
          }
        }


      }
      if (counter >= lehrer.length) {
        System.out.println("Das Fahrzeug mit der größten Geschwindigkeit hat gewonnen.");
      }
      else {

        int i = fahrzeugNummerVMax;
        while (lehrer[fahrzeugNummerVMax].getS() < lehrer[gewinnerNummer].getS()) {

          if (i==fahrzeugNummerVMax) {
            i=gewinnerNummer;
          }
          else {
          i=fahrzeugNummerVMax;
          }

            if (cnt >= lehrer[i].getReaction()) {

              //Speed erh�hen falls noch nicht maxSpeed
              if (lehrer[i].getV() <= fahrzeug[i].getMaxSpeed()) {
                newV=(int) lehrer[i].getV()+(lehrer[i].getAcceleration()+(lehrer[i].getAcceleration() * ((int) streckenGefaelleModifikator / 100)));
                if (newV > fahrzeug[i].getMaxSpeed()) {
                  newV=fahrzeug[i].getMaxSpeed();
                } // end of if
                lehrer[i].setV(newV);
              } // end of if
              //Strecke berechnen
              float gefahreneStrecke=lehrer[i].getVms()+lehrer[i].getS();
              lehrer[i].setS(gefahreneStrecke);

            } // end of if
          }
    int laenge= (int)lehrer[fahrzeugNummerVMax].getS()-streckenLaenge;
        System.out.println("Das schnellste Fahrzeug hätte nach "+laenge+" weiteren Metern gewonnen.");
        }


      }

    System.out.println("So, das war es für dieses Mal!");



  } // end of main



} // end of class Steuerung


























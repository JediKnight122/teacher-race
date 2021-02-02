public class Normalo extends Lehrer {

    public Normalo(String n, String nn, int r, int a) {
        typ="Normalo";
        name = n;
        nachName=nn;
        reaction = r;
        acceleration = a;
        System.out.println("Angelegt: Name= "+n+" "+nachName+" Reaktion="+r+" Beschleunigung="+a+" Typ: "+typ);
        siegesSpruch="Was auch immer...kann ich jetzt wieder gehen?";
    }
    public Normalo(String n, String nn, int a) {
        typ="Normalo";
        name = n;
        nachName=nn;
        acceleration = a;
        System.out.println("Angelegt: Name= "+n+" "+nachName+ " Beschleunigung="+a+" Typ: "+typ);
        siegesSpruch="Auch Nachteile sind kein Problem f\u00fcr mich!";
    }
}

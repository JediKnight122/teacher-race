public class Praktiker extends Lehrer {

    public Praktiker(String n, String nn, int r, int a) {
        typ="Praktiker";
        name = n;
        nachName=nn;
        reaction = r-8;
        acceleration = a-5;
        System.out.println("Angelegt: Name= "+n+" "+nachName+" Reaktion="+r+" Beschleunigung="+a+" Typ: "+typ);
        siegesSpruch="Ach, habe ich schon gewonnen? Tats\u00e4chlich?";
    }
    public Praktiker(String n, String nn, int a) {
        typ="Praktiker";
        name = n;
        nachName=nn;
        acceleration = a-5;
        System.out.println("Angelegt: Name= "+n+" "+nachName+ " Beschleunigung="+a+" Typ: "+typ);
        siegesSpruch= "Hat irgendjemand etwas anderes erwartet?";
    }

}

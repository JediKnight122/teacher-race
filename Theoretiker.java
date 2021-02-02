public class Theoretiker extends Lehrer {


    public Theoretiker(String n, String nn, int r, int a) {

        typ="Theoretiker";
        name = n;
        nachName=nn;
        reaction = r+8;
        acceleration = a+6;
        System.out.println("Angelegt: Name= "+n+" "+nachName+" Reaktion="+r+" Beschleunigung="+a+" Typ: "+typ);
        siegesSpruch="Gut geplant ist halb gewonnen!";
    }
    public Theoretiker(String n, String nn, int a) {
        typ="Theoretiker";
        name = n;
        nachName=nn;
        acceleration = a+6;
        System.out.println("Angelegt: Name= "+n+" "+nachName+ " Beschleunigung="+a+" Typ: "+typ);
        siegesSpruch="Langsam und beharrlich.";
    }


}

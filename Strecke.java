public class Strecke {
    private int laenge;
    private String name;
    private double gefaelle;

    public Strecke (int nummer){
        if (nummer==1){
           name = "Rheinstrasse";
           laenge = 200;
           gefaelle = 0;
        }
        else if (nummer==2){
            name = "B-500";
            laenge = 500;
            gefaelle = 0;
        }
        else if (nummer==3){
            name = "Citytour";
            laenge = 750;
            gefaelle = 0;
        }
        else if (nummer==4){
            name = "Fremersberg";
            laenge = 1000;
            gefaelle = -15;
        }
        else if (nummer==5){
            name = "Schwarzwaldhochstrasse (hoch)";
            laenge = 800;
            gefaelle = -30;
        }

        else if (nummer==6){
            name = "Schwarzwaldhochstrasse (runter)";
            laenge = 800;
            gefaelle = 30;
        }

        else if (nummer==7){
            name = "Merkurtour";
            laenge = 1000;
            gefaelle = -55;
        }


    }

    public int getLaenge() {
        return laenge;
    }

    public String getName() {
        return name;
    }

    public double getGefaelle() {
        return gefaelle;
    }
}

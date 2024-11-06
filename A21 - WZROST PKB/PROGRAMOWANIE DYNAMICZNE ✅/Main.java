import java.util.ArrayList;

public class Main {
    static ArrayList<Double> pkbPoland = new ArrayList<Double>();
    static ArrayList<Double> pkbGermany = new ArrayList<Double>();
    static double pkbRaisePoland = 1.06;
    static double pkbRaiseGermany = 1.012;
    public static void main(String args[]){
        pkbPoland.add(6000.0);
        pkbGermany.add(12000.0);
        System.out.format("\nPKB Polski podwoi sie po %d latach", doublePkb(pkbPoland, pkbRaisePoland));
        System.out.format("\nPKB Polski dorowna PKB Niemiec po %d latach", catchSecondCountry(pkbPoland, pkbRaisePoland, pkbGermany, pkbRaiseGermany));
    }

    public static int doublePkb(ArrayList<Double> pkb, double raise){
       int i = 0;
       double currentPkb = pkb.get(i);
       do{
            pkb.add(currentPkb * raise);
            currentPkb = pkb.get(++i);
       }while(currentPkb < pkb.get(0) * 2);

       return i;
    }

    public static int catchSecondCountry(ArrayList<Double> pkb1, double raise1, ArrayList<Double> pkb2, double raise2){
        int i = 0;
        double currentPkb1 = pkb1.get(i);
        double currentPkb2 = pkb2.get(i);

        do{
            pkb1.add(currentPkb1 * raise1);
            pkb2.add(currentPkb2 * raise2);

            ++i;
            currentPkb1 = pkb1.get(i);
            currentPkb2 = pkb2.get(i);
        }while(currentPkb1 <= currentPkb2);

        return i;
    }
}

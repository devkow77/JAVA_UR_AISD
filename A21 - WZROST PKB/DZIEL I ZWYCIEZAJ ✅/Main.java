public class Main {
    static double pkbPoland = 6000;
    static double pkbGermany = 12000;
    static double pkbRaisePoland = 1.06;
    static double pkbRaiseGermany = 1.012;
    public static void main(String args[]){
        int years = doublePkb(pkbPoland, pkbPoland * 2, pkbRaisePoland, 0);
        System.out.format("\nPKB Polski podwoi sie po %d latach", years);
        int years2 = catchSecondCountry(pkbPoland, pkbRaisePoland, pkbGermany, pkbRaiseGermany, 0);
        System.out.format("\nPKB Polski dorowna PKB Niemiec po %d latach", years2);
    }

    public static int doublePkb(double startPkb, double endPkb, double raisePkb, int years){
        if(startPkb >= endPkb){
            return years;
        }else{
            return doublePkb(startPkb * raisePkb, endPkb, raisePkb, years + 1);
        }
    }

    public static int catchSecondCountry(double pkbCountry1, double raisePkbCountry1, double pkbCountry2, double raisePkbCountry2, int years){
        if(pkbCountry1 >= pkbCountry2){
            return years;
        }else{
            return catchSecondCountry(pkbCountry1 * raisePkbCountry1, raisePkbCountry1, pkbCountry2 * raisePkbCountry2, raisePkbCountry2, years + 1);
        }
    }
}

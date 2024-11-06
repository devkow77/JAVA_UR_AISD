public class Main {    
    static double pkbPolska = 6000;
    static double pkbNiemcy = 12000;
    static double pkbWzrostPolska = 1.06;
    static double pkbWzrostNiemcy = 1.012;
    public static void main(String args[]){
        int iloscLatDoPodwojenia = 0;
        int iloscLatDoWyrownania = 0;
        

        // podwojenie pkb Polski
        double pkbPolskaTemp = pkbPolska;
        while(pkbPolskaTemp < pkbPolska * 2){
            pkbPolskaTemp *= pkbWzrostPolska;
            iloscLatDoPodwojenia++;
        }
        System.out.format("\nPKB Polski podwoi sie po %d latach", iloscLatDoPodwojenia);

        // dogonienie pkb Polski do pkb Niemiec
        pkbPolskaTemp = pkbPolska;
        double pkbNiemcyTemp = pkbNiemcy;
        while(pkbPolskaTemp < pkbNiemcyTemp){
            pkbPolskaTemp *= pkbWzrostPolska;
            pkbNiemcyTemp *= pkbWzrostNiemcy;
            iloscLatDoWyrownania++;
        }
        System.out.format("\nPKB Polski dorowna PKB Niemiec po %d latach", iloscLatDoWyrownania);
    }
}

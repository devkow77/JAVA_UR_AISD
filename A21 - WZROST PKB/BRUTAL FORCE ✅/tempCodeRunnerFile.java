public class Main {    
    static double pkbPolska = 6000;
    static double pkbNiemcy = 12000;
    static double pkbWzrostPolska = 1.06;
    static double pkbWzrostNiemcy = 1.012;
    public static void main(String args[]){
        int iloscLatDoPodwojenia = 0;
        int iloscLatDoWyrownania = 0;
        

        double pkbPolskaTemp = pkbPolska;
        while(pkbPolskaTemp < pkbPolska * 2){
            pkbPolskaTemp *= pkbPolska;
            iloscLatDoPodwojenia++;
            System.out.println(pkbPolskaTemp);
            System.out.println(iloscLatDoPodwojenia);
        }
        System.out.format("PKB Polski podwoi sie po %d latach", iloscLatDoPodwojenia);

    }
}

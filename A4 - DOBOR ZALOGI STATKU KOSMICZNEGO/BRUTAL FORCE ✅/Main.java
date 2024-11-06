/*
D: kosmonauci (k1,k2,k3,k4,k5)
Z: Podaj zaloge z jak najmnniejsza liczba osob ktora zawiera A,B,C,D
A - k1, k4
B - k2, k3, k4
C - k3, k5
D - k1, k2, k5
ODP np: k4, k5 Napisz program w javie
*/

public class Main {
    final static String[] kosmonauci = {"A D", "B D", "B C", "A B", "C D"};
    final static int N = kosmonauci.length; 
    static int[] tab = new int[N + 1]; 
    String najlepszeRozwiazanie = "";
    static int najlepszaIloscZalogi = 5;
    public static void main(String args[]){
        // WSZYSTKIE PRZYPADKI PODZBIOROW
        for(int j = 0; j < Math.pow(2, N); j++){
            String zaloga = "";
            String funkcje = "";
            int obecnaIloscZalogi = 0;

            // DODANIE OPISU WEDLUG AKTUALNEGO PODZBIORU
            for(int i = 0; i < N; i++){
                if(tab[i] == 1){
                    zaloga += " k" + (i+1);
                    funkcje += " " + kosmonauci[i];
                    obecnaIloscZalogi++;
                }
            }

            // WYPISANIE AKTUALNEGO PODZBIORU
            String aktualneRozwiazanie = "{";

            for(int i = 0; i < N; i++){
                aktualneRozwiazanie += " " + tab[i];
            }

            aktualneRozwiazanie += " } Zaloga:" + zaloga + " Funkcje:" + funkcje;

           

             if (obecnaIloscZalogi < najlepszaIloscZalogi && funkcje.contains("A B C D")){
                najlepszaIloscZalogi = obecnaIloscZalogi;
                 System.out.println(aktualneRozwiazanie);
            }

            // UTWORZENIE AKTUALNEGO PODZBIORU
            int i = 0;
            do{
                if(tab[i] == 1){
                    tab[i] = 0;
                    i++;
                }else{
                    tab[i] = 1;
                    break;
                }
            }while(true);
        }
    }
}

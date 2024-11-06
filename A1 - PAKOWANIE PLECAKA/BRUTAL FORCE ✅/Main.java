// BRUTAL FORCE - WSZYSTSKIE MOZLIWE KOMBINACJE DO WYGENEROWANIA
// [0,0,0,0,0,0]
// [1,0,0,0,0,0]
// [0,1,0,0,0,0]
// [1,1,0,0,0,0] itd.

public class Main{
    static int[] OBJETOSC = new int[]{6,2,3,2,3,1};
    static int[] WARTOSC = new int[]{6,4,5,7,10,2};
    final static int MAX_V = 10;
    static int N = OBJETOSC.length;
    static int[] tab = new int[N+1]; // np. [0,1,0,0,0,0]
    static public void main(String args[]){
        int najlepszeV = 0;
        int najlepszeW = 0;
        String najlepszeRozwiazanie = "";

        // iteracja po wszystkich mozliwosciach
        for(int j = 0; j < Math.pow(2, N); j++){
            int obecneV = 0;
            int obecneW = 0;
            String obecneRozwiazanie = "{ ";

            // 1. obliczanie aktualnej mozliwosci np. [0,0,0,0,0,0]
            for(int i = 0; i < N; i++){
                if(tab[i] == 1){
                    obecneV += OBJETOSC[i];
                    obecneW += WARTOSC[i];
                    obecneRozwiazanie += i + " ";
                }
            }

            obecneRozwiazanie += "} V: " + obecneV + " W: " + obecneW;

            // 2. sprawdzenie czy lepsza niz poprzednia
            if(obecneV <= MAX_V && obecneW > najlepszeW){
                najlepszeV = obecneV;
                najlepszeW = obecneW;
                najlepszeRozwiazanie = obecneRozwiazanie;
                System.out.println(najlepszeRozwiazanie);
            }
         

            // 2. wygenerowanie kolejnej mozliwosci np. [1,0,0,0,0,0]
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

        // wypisanie ostatecznego wyniku
        System.out.format("Ostatecznie najlepsze rozwiazanie to: %s", najlepszeRozwiazanie);
    }
}
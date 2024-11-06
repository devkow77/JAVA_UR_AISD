//  sprawdzic co zle w drugim
public class Main {
    static int[] OBJETOSC = new int[]{6,2,3,2,3,1};
    static int[] WARTOSC = new int[]{6,4,5,7,10,2};
    static int N = OBJETOSC.length;
    final static int MAX_V = 10;
    static public void main(String args[]){
        // pakowanieNajlzejszych();
        pakowanieNajcenniejszych();
    }

    // pakowanie plecaka od przedmiotow z najnizsza objetoscia
    static public void pakowanieNajlzejszych(){
        boolean[] spakowane = new boolean[N];

        int obecneV = 0;
        int obecneW = 0;

        while(true){
            int minV = Integer.MAX_VALUE;
            int indexPrzedmiotu = -1;
            // iteracja po kazdym przedmiocie
            for(int i = 0; i < N; i++){
                // znaleziono kolejny przedmiot spelniajacy wymagania
                if(OBJETOSC[i] < minV && !spakowane[i] && obecneV + OBJETOSC[i] <= MAX_V){
                    indexPrzedmiotu = i;
                }
            }

            // nie znaleziono przedmiotu
            if(indexPrzedmiotu == -1){
                break;
            }

            obecneV += OBJETOSC[indexPrzedmiotu];
            obecneW += WARTOSC[indexPrzedmiotu];
        }

        // wypisanie zawartosci
        System.out.println("Zawartosc plecaka: ");
        for(int i = 0; i < N; i++){
            if(spakowane[i]){
                System.out.print(i + "");
            }
        }
        System.out.format("\nV: %d W: %d", obecneV, obecneW);
    }   

    // pakowowanie plecaka od przedmiotow z najwyzsza wartoscia
    static public void pakowanieNajcenniejszych(){
        boolean[] spakowane = new boolean[N];

        int obecneV = 0;
        int obecneW = 0;

        while(true){
            int maxW = 0;
            int wybranyPrzedmiot = -1;

            for(int i = 0; i < N; i++){
                if(WARTOSC[i] > maxW && !spakowane[i] && obecneV + OBJETOSC[i] <= MAX_V){
                    maxW = WARTOSC[i];  // Track the maximum value found
                    wybranyPrzedmiot = i;
                }
            }

            if(wybranyPrzedmiot == -1){
                break;
            }

            obecneV += OBJETOSC[wybranyPrzedmiot];
            obecneW += WARTOSC[wybranyPrzedmiot];
            spakowane[wybranyPrzedmiot] = true;  // Mark item as packed
        }

        // Wypisanie zawartości
        System.out.println("Spakowane przedmioty: ");
        for(int i = 0; i < N; i++){
            if(spakowane[i]){
                System.out.print(i + " ");
            }
        }
        System.out.format("\nV: %d W: %d", obecneV, obecneW);
    }
}


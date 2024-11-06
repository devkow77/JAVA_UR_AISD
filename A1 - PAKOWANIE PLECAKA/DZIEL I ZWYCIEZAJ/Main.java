// NIE JEST TO METODA DZIEL I ZWYCIEZAJ WEDLUG CHATA GPT :(

public class Main {
    static int[] OBJETOSC = new int[]{6,2,3,2,3,1};
    static int[] WARTOSC = new int[]{6,4,5,7,10,2};
    static int N = OBJETOSC.length;
    static int MAX_V = 10;
    static boolean[] spakowanePrzedmioty = new boolean[N]; // np. [0,0,1,0,0,1]
    static public void main(String args[]){
        // przypisanie wybranych przedmiotow
        boolean[] wybranePrzedmioty = pakowanieOdNajmniejszego(spakowanePrzedmioty, 0);
        int koncowaObjetoscPlecaka = 0;
        int koncowaWartoscPlecaka = 0;
        // wypisanie rezultatu
        System.out.print("Wybrane przedmioty: ");
        for(int i = 0; i < N; i++){
            if(wybranePrzedmioty[i]){
                koncowaObjetoscPlecaka += OBJETOSC[i];
                koncowaWartoscPlecaka += WARTOSC[i];
                System.out.print(i + " ");
            }
        }
        System.out.format("\nV: %d W: %d", koncowaObjetoscPlecaka, koncowaWartoscPlecaka);
    }

    static public boolean[] pakowanieOdNajmniejszego(boolean[] spakowanePrzedmioty, int aktualnaObjetosc){
        // jezeli V wynosi 10
        if(aktualnaObjetosc >= MAX_V){
            return spakowanePrzedmioty;
        }
        // w innym przypadku
        else{
            int indexPrzedmiotu = -1;
            int minV = Integer.MAX_VALUE;

            // iteracja po kazdym przedmiocie
            for(int i = 0; i < N; i++){
                // szukanie najmniejszego przedmiotu ktory nie zostal spakowany i miesci sie w plecaku
                if(OBJETOSC[i] < minV && !spakowanePrzedmioty[i] && aktualnaObjetosc + OBJETOSC[i] <= MAX_V){
                   minV = OBJETOSC[i];
                   indexPrzedmiotu = i;
                }
            }

            // jezeli nie ma co spakowac zwroc przedmioty
            if(indexPrzedmiotu == -1){
                return spakowanePrzedmioty;
            }

            spakowanePrzedmioty[indexPrzedmiotu] = true;
            aktualnaObjetosc += OBJETOSC[indexPrzedmiotu];
        }

        return pakowanieOdNajmniejszego(spakowanePrzedmioty, aktualnaObjetosc);
    }
}

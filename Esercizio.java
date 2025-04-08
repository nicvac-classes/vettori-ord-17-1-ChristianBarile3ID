//LEGGERE LE ISTRUZIONI NEL FILE README.md

//Import di Classi Java necessarie al funzionamento del programma
import java.util.Scanner;
import java.util.Random;

// Classe principale, con metodo main
class Esercizio {

    public static void bubbleSort(int[]V) {
        int i, j, temp;
        boolean scambio;
        scambio = true;
        for (i=0; i<V.length && scambio; ++i) {
            scambio = false;
            for (j=0; j<(V.length-1)-i; ++j) {
                if (V[j]>V[j+1]) {
                    temp = V[j];
                    V[j] = V[j+1];
                    V[j+1] = temp;
                    scambio = true;
                }
            }
        }
    }

    public static void merge(int[] V, int[] W, int[] X) {
        int i, j, k;
        i = 0;
        j = 0;
        k = 0;
        while (i<V.length && j<W.length) {
            if (V[i]<W[j]) {
                X[k] = V[i];
                ++i;
            } else {
                X[k] = W[j];
                ++j;
            }
            ++k;
        }
        while (i<V.length) {
            X[k] = V[i];
            ++i;
            ++k;
        }
        while (j<W.length) {
            X[k] = W[j];
            ++j;
            ++k;
        }
    }

    public static int ricercaBinaria(int[] V, int val) {
        int i, idx, iStart, iEnd, centro;
        iStart = 0;
        iEnd = V.length-1;
        centro = iStart+(iEnd-iStart)/2;
        idx = -1;
        while (idx==-1 && iStart<=iEnd) {
            if (val>V[centro]) {
                iStart = centro+1;
            } else if (val<V[centro]) {
                iEnd = centro-1;
            } else {
                idx = centro;
            }
            centro = iStart+(iEnd-iStart)/2;
        }
        return idx;
    }

    public static void visualizzaVettore(int[] V) {
        int i;
        for (i=0; i<V.length; ++i) {
            System.out.println(V[i]);
        }
    }
   
    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        int N, rand, NV, NW, NX, i, idx, val;
        System.out.println("Inserire il numero di numeri interi casuali da generare: ");
        N = Integer.parseInt(in.nextLine());
        int[] V = new int[N];
        int[] W = new int[N];
        NV = 0;
        NW = 0;
        Random random = new Random();
        for (i=0; i<N; ++i) {
            rand = random.nextInt(N);
            if (rand%2==0) {
                V[NV] = rand;
                ++NV;
            } else {
                W[NW] = rand;
                ++NW;
            }
        }
        System.out.println("------ VETTORE V NON ORDINATO ------");
        visualizzaVettore(V);
        System.out.println("------ VETTORE W NON ORDINATO ------");
        visualizzaVettore(W);
        bubbleSort(V);
        bubbleSort(W);
        System.out.println("------ VETTORE V ORDINATO ------");
        visualizzaVettore(V);
        System.out.println("------ VETTORE W ORDINATO ------");
        visualizzaVettore(W);
        NX = NV+NW;
        int[] X = new int[NX];
        merge(V, W, X);
        System.out.println("------ VETTORE MERGE ORDINATO ------");
        visualizzaVettore(X);
        System.out.println("Inserisci il valore da cercare: ");
        val = Integer.parseInt(in.nextLine());
        idx = ricercaBinaria(X, val);
        if (idx!=-1) {
            System.out.println("Il valore " + val + " è stato trovato alla posizione: " + idx);
        } else {
            System.out.println("Il valore " + val + " non è stato trovato");
        }
    }
}

//LEGGERE LE ISTRUZIONI NEL FILE README.md;

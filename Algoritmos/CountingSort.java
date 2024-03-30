package Algoritmos;

public class CountingSort {
    public void countingSort(int[] vetor, int k) {
        if (vetor.length == 0 || k <= 0) {
            return;
        }
    
        int maior = vetor[0];
        for (int i = 1; i < vetor.length; i++) {
            maior = Math.max(maior, vetor[i]);
        }
    
        int[] contagem = new int[k + 1];
    
        for (int i = 0; i < vetor.length; i++) {
            contagem[vetor[i]]++;
        }
    
        for (int i = 1; i <= k; i++) {
            contagem[i] += contagem[i - 1];
        }

        int i = 0;
        for (int j = 0; j <= k; j++) {
            while (contagem[j] > 0) {
                vetor[i++] = j;
                contagem[j]--;
            }
        }
    }
    
}

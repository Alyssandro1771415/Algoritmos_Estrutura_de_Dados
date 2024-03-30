package Algoritmos;

import java.util.Arrays;

public class MergeSort {

    public int[] Merge_Sort(int[] vetor){

        Integer tamanho = vetor.length;

        if(tamanho <= 1){

            return vetor;

        } else{

            int meio = tamanho / 2;
            int[] vetor_esquerdo = Merge_Sort(Arrays.copyOfRange(vetor, 0, meio));
            int[] vetor_direito = Merge_Sort(Arrays.copyOfRange(vetor, meio, vetor.length));            

            int[] vetorFinal = merge(vetor_esquerdo, vetor_direito);

            return vetorFinal;

        }

    }

    private int[] merge(int[] esquerdo, int[] direito) {
        int[] result = new int[esquerdo.length + direito.length];
        int i = 0, j = 0, k = 0;

        while (i < esquerdo.length && j < direito.length) {
            if (esquerdo[i] <= direito[j]) {
                result[k++] = esquerdo[i++];
            } else {
                result[k++] = direito[j++];
            }
        }

        while (i < esquerdo.length) {
            result[k++] = esquerdo[i++];
        }

        while (j < direito.length) {
            result[k++] = direito[j++];
        }

        return result;
    }

}

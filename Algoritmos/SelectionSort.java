package Algoritmos;

public class SelectionSort {

    public void Selection_Sort(int []vetor) {

        Integer tamanho = vetor.length;

        for (int i = 0; i < tamanho-1; i++) {
            
            int indexMenorValor = i;

            for (int j = i+1; j < tamanho; j++) {
                
                if(vetor[j] < vetor[indexMenorValor]){

                    indexMenorValor = j;

                }

            }

            int auxiliar = vetor[i];
            vetor[i] = vetor[indexMenorValor];
            vetor[indexMenorValor] = auxiliar;

        }
    }
}

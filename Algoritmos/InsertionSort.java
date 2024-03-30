package Algoritmos;

public class InsertionSort {
    
    public void Insertion_Sort(double[] vetor) {

        Integer tamanho = vetor.length;

        for (int i = 1; i < tamanho; i++) {

            double numeroAtual = vetor[i];
            int indexAnterior = i-1;

            while ((indexAnterior >= 0) && (vetor[indexAnterior] > numeroAtual)) {
                
                vetor[indexAnterior+1] = vetor[indexAnterior];
                indexAnterior -= 1;

            }
            vetor[indexAnterior+1] = numeroAtual;
        }
    }
}

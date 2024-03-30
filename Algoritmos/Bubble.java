package Algoritmos;

public class Bubble {

    public void BubbleSort(double[] vetor) {

        int tamanho = vetor.length;
        int trocas = 0;

        for (int i = 0; i < tamanho; i++) {

            for (int j = 0; j < tamanho - 1; j++) {

                if (vetor[j] > vetor[j + 1]) {

                    double auxiliar = vetor[j + 1];
                    vetor[j + 1] = vetor[j];
                    vetor[j] = auxiliar;

                    trocas += 1;

                }

            }

            if (trocas == 0) {
                break;
            } else {
                trocas = 0;
            }

        }
    }

}

package Algoritmos;

public class QuickSort {
    
    public void quickSort(double[] vetor, int inicio, int fim) {
		if (inicio < fim) {
		  int posicaoPivo = separar(vetor, inicio, fim);
		  quickSort(vetor, inicio, posicaoPivo - 1);
		  quickSort(vetor, posicaoPivo + 1, fim);
		}
	  }
	  
	  public int separar(double[] vetor, int inicio, int fim) {
		double pivo = vetor[inicio];
		int i = inicio + 1, f = fim;
		while (i <= f) {
		  if (vetor[i] <= pivo) {
			i++;
		  } else if (pivo < vetor[f]) {
			f--;
		  } else {
			double troca = vetor[i];
			vetor[i] = vetor[f];
			vetor[f] = troca;
			i++;
			f--;
		  }
		}
		vetor[inicio] = vetor[f];
		vetor[f] = pivo;
		return f;
	  }
	  
}
  
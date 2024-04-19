package Algoritmos;

import java.util.HashMap;

public class CountingSort {
    
    public void countingSort(double[] array) {
        double minimo = array[0];
        double maximo = array[0];
        for (double valor : array) {
          if (valor < minimo) {
            minimo = valor;
          } else if (valor > maximo) {
            maximo = valor;
          }
        }
    
        // Subtrair o mínimo de todos os elementos para garantir que todos sejam
        // positivos
        for (int i = 0; i < array.length; i++) {
          array[i] -= minimo;
        }
    
        // Usar HashMap para contar a ocorrência de cada valor
        HashMap<Double, Integer> contagem = new HashMap<>();
        for (double valor : array) {
          contagem.put(valor, contagem.getOrDefault(valor, 0) + 1);
        }
    
        // Reconstruir o array original com os valores ordenados
        int index = 0;
        for (double i = 0; i <= maximo - minimo; i++) {
          int count = contagem.getOrDefault(i, 0);
          for (int j = 0; j < count; j++) {
            array[index++] = i + minimo; // Adicionar o mínimo de volta
          }
        }
      }
}

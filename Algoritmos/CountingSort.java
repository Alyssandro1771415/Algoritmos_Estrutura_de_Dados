package Algoritmos;

public class CountingSort {
    public void ordenacaoPorContagem(double[] array) {
        
        double minimo = array[0];
        double maximo = array[0];
        for (double valor : array) {
          if (valor < minimo) {
            minimo = valor;
          } else if (valor > maximo) {
            maximo = valor;
          }
        }
      
        int[] contagem = new int[(int) (maximo - minimo + 1)];
      
        for (int i = 0; i < contagem.length; i++) {
          contagem[i] = 0;
        }
      
        for (double valor : array) {
          contagem[(int) (valor - minimo)]++;
        }
      
        for (int i = 1; i < contagem.length; i++) {
          contagem[i] += contagem[i - 1];
        }
      
        double[] saida = new double[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
          saida[contagem[(int) (array[i] - minimo)] - 1] = array[i];
          contagem[(int) (array[i] - minimo)]--;
        }
      
        for (int i = 0; i < array.length; i++) {
          array[i] = saida[i];
        }
      }
                
}

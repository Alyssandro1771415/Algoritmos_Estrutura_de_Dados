package org.example;

public class InsertionSort {
    private int trocas;
    private int comparacoes;
    private long tempoExecucao;

    public InsertionSort() {
        this.trocas = 0;
        this.comparacoes = 0;
        this.tempoExecucao = 0;
    }

    public int[] sort(int[] arr) {
        long startTime = System.nanoTime();

        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
                comparacoes++;
                trocas++;
            }
            arr[j + 1] = key;
        }

        long endTime = System.nanoTime();
        tempoExecucao = endTime - startTime;

        return arr;
    }

    public int getTrocas() {
        return trocas;
    }

    public int getComparacoes() {
        return comparacoes;
    }

    public long getTempoExecucao() {
        return tempoExecucao;
    }
}

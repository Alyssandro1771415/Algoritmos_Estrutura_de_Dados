import java.util.ArrayList;
import Algoritmos.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        ArrayList<double[]> vectors = processFiles.process_Files("./DataBases");

        Bubble ordernarBubble = new Bubble();
        ArrayList<Algoritmo> algoritmos = new ArrayList<>();

        String[] databaseNames = {
                "1M constantes",
                "1M crescente",
                "1M decrescente",
                "1M desordem 10 finais",
                "1M desordem 10 iniciais",
                "1M desordenado",
                "2M constantes",
                "2M crescente",
                "2M decrescente",
                "2M desordem 10 finais",
                "2M desordem 10 iniciais",
                "2M desordenado",
                "3M constantes",
                "3M crescente",
                "3M decrescente",
                "3M desordem 10 finais",
                "3M desordem 10 iniciais",
                "3M desordenado"
        };

        long memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        for (double[] ds : vectors) {

            System.out.printf("%s=> \n", databaseNames[vectors.indexOf(ds)]);

            long startTime = System.currentTimeMillis();
            ordernarBubble.BubbleSort(ds);
            long endTime = System.currentTimeMillis();

            long memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

            System.out.println("\tMemory used: " + (memoryAfter - memoryBefore) + " bytes");
            System.out.println("\tTotal time: " + (endTime - startTime) / 1000 + " segundos\n");

            algoritmos.add(new Algoritmo("Bubble Sort", (endTime - startTime) / 1000, (memoryAfter - memoryBefore), databaseNames[vectors.indexOf(ds)]));
            break;
        }

        gerarCsv(algoritmos, "Results");

    }

    public static void gerarCsv(List<Algoritmo> algoritmos, String nomeArquivo) throws IOException {

        try (RandomAccessFile raf = new RandomAccessFile(nomeArquivo + ".csv", "rw")) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(raf.getFD()))) {

                if (raf.length() == 0) {
                    bufferedWriter.write("Algoritmo,Base de Dados,Tempo,Memoria");
                    bufferedWriter.newLine();
                }

                raf.seek(raf.length());

                for (Algoritmo algoritmo : algoritmos) {
                    bufferedWriter.write(
                            algoritmo.getNome() + "," + algoritmo.getDataBase() + "," + (int) algoritmo.getTempo() + "," + (int) algoritmo.getMemoria());
                    bufferedWriter.newLine();
                }
            }
        }
    }

    public static class Algoritmo {
        private String nome;
        private double tempo;
        private double memoria;
        private String dataBase;

        public String getDataBase() {
            return dataBase;
        }

        public void setDataBase(String dataBase) {
            this.dataBase = dataBase;
        }

        public Algoritmo(String nome, double tempo, double memoria, String dataBase) {
            this.nome = nome;
            this.tempo = tempo;
            this.memoria = memoria;
            this.dataBase = dataBase;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public double getTempo() {
            return tempo;
        }

        public void setTempo(double tempo) {
            this.tempo = tempo;
        }

        public double getMemoria() {
            return memoria;
        }

        public void setMemoria(double memoria) {
            this.memoria = memoria;
        }
    }
}

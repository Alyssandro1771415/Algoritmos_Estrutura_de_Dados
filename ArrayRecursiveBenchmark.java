import java.util.Random;

public class ArrayRecursiveBenchmark {

    public static void main(String[] args) {
        int size = 1000;
       
        int[] array = generateRandomArray(size);

        // Executar o benchmark e obter o tempo de execução médio
        double totalTime = 0;
        for (int i = 0; i < 10; i++) {
            totalTime += benchmark(array);
        }

        double averageTime = totalTime / 10;
        System.out.println("Tempo médio de execução: " + averageTime + " segundos");
    }

    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    public static int sumArray(int[] array, int index) {
        if (index >= array.length) {
            return 0;
        }
        return array[index] + sumArray(array, index + 1);
    }

    public static double benchmark(int[] array) {
        long startTime = System.nanoTime();
        int sum = sumArray(array, 0);
        long endTime = System.nanoTime();
        double elapsedTime = (endTime - startTime) / 1000000000.0; // Converter para segundos
        System.out.println("Soma dos elementos do array: " + sum);
        return elapsedTime;
    }
}
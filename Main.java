import java.util.ArrayList;
import Algoritmos.*;

public class Main {

    public static void main(String[] args) {
        
        ArrayList<double[]> vectors = processFiles.process_Files("./DataBases");

        Bubble ordernarBubble = new Bubble();

        String[] databaseNames = {
            "1M desordem 10 finais", 
            "1M desordem 10 iniciais", 
            "1M desordenado", 
            "2M desordem 10 finais", 
            "2M desordem 10 iniciais", 
            "2M desordenado", 
            "3M desordem 10 finais", 
            "3M desordem 10 iniciais", 
            "3M desordenado"
        };
        

        for (double[] ds : vectors) {
            
            System.out.printf("%s=> \n", databaseNames[vectors.indexOf(ds)]);

            long memoryBefore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

            long startTime = System.currentTimeMillis();
            ordernarBubble.BubbleSort(ds);
            long endTime = System.currentTimeMillis();

            long memoryAfter = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

            System.out.println("\tMemory used: " + (memoryAfter - memoryBefore) + " bytes");
            System.out.println("\tTotal time: " + (endTime - startTime)/1000 + " segundos\n");

        }

    }
}

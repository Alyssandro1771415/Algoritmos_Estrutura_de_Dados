import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class processFiles {

        public static ArrayList<double[]> process_Files(String directoryPath) {
        File directory = new File(directoryPath);
        ArrayList<double[]> vectors = new ArrayList<>();

        if (!directory.isDirectory()) {
            System.err.println("O caminho especificado não é um diretório.");
            return vectors;
        }

        File[] files = directory.listFiles((dir, name) -> name.toLowerCase().endsWith(".txt"));
        if (files == null) {
            System.err.println("Nenhum arquivo .txt encontrado no diretório.");
            return vectors;
        }

        for (File file : files) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                ArrayList<Double> values = new ArrayList<>();
                String line;
                while ((line = reader.readLine()) != null) {
                    double value = Double.parseDouble(line.trim());
                    values.add(value);
                }
                double[] doubleArray = new double[values.size()];
                for (int i = 0; i < values.size(); i++) {
                    doubleArray[i] = values.get(i);
                }
                vectors.add(doubleArray);
            } catch (IOException | NumberFormatException e) {
                System.err.println("Erro ao ler o arquivo " + file.getName() + ": " + e.getMessage());
            }
        }

        return vectors;
    }

}

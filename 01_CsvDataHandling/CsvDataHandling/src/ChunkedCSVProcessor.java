import java.io.*;

public class ChunkedCSVProcessor {
    public static void main(String[] args) {
        final int CHUNK_SIZE = 100;
        int totalCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("customers-1000.csv"))) {
            
            int chunkCount = 0;

            while ((br.readLine()) != null) {
                chunkCount++;
                totalCount++;
                if (chunkCount == CHUNK_SIZE) {
                    System.out.println("Processed " + totalCount + " records...");
                    chunkCount = 0;
                }
            }

            if (chunkCount > 0) {
                System.out.println("Processed " + totalCount + " records (final chunk).");
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
} 

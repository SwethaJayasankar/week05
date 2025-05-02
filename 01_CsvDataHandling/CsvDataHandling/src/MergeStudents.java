import java.io.*;

public class MergeStudents {
    public static void main(String[] args) {
        try (
            BufferedReader br1 = new BufferedReader(new FileReader("D:/CapLabWorks/CapLabWorks/week_6/CsvDataHandling/CsvDataHandling/students1.csv"));
            BufferedReader br2 = new BufferedReader(new FileReader("D:/CapLabWorks/CapLabWorks/week_6/CsvDataHandling/CsvDataHandling/students2.csv"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("D:/CapLabWorks/CapLabWorks/week_6/CsvDataHandling/CsvDataHandling/studentsMerged.csv"));
        ) {
            String line1, line2;

            bw.write("ID,NAME,AGE,MARKS,GRADE\n");

            while ((line1 = br1.readLine()) != null && (line2 = br2.readLine()) != null) {
                String[] a = line1.split(",");
                String[] b = line2.split(",");
                if (a[0].equalsIgnoreCase("ID") || b[0].equalsIgnoreCase("ID")) continue;

                bw.write(a[0] + "," + a[1] + "," + a[2] + "," + b[1] + "," + b[2] + "\n");
            }

            System.out.println("Merge completed. Output: studentsMerged.csv");

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}

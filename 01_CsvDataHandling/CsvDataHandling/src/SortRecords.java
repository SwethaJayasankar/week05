import java.io.*;
import java.util.*;

public class SortRecords {
    public static void main(String[] args) {
        List<String[]> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("employee.csv"))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    employees.add(parts);
                }
            }
            employees.sort((a, b) -> Integer.parseInt(b[3]) - Integer.parseInt(a[3]));

            System.out.println("Top 5 highest-paid employees:");
            for (int i = 0; i < Math.min(5, employees.size()); i++) {
                String[] emp = employees.get(i);
                System.out.println("ID: " + emp[0] + ", Name: " + emp[1] + ", Dept: " + emp[2] + ", Salary: " + emp[3]);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

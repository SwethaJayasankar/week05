import java.io.*;
import java.util.regex.*;

public class InvalidCred {
    public static void main(String[] args) {
      //  List<String[]> validEmployees = new ArrayList<>();
        Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        Pattern phonePattern = Pattern.compile("^\\d{10}$");

        try (BufferedReader br = new BufferedReader(new FileReader("D:/CapLabWorks/CapLabWorks/week_6/CsvDataHandling/CsvDataHandling/cred.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s+");
                boolean emailValid = emailPattern.matcher(parts[0].trim()).matches();
                boolean phoneValid = phonePattern.matcher(parts[1].trim()).matches();

                 if (!emailValid) System.out.println("  → Invalid Email: " + parts[0]);
                 if (!phoneValid) System.out.print("  → Invalid Phone: " + parts[1]+"\n===\n");
            }

        }catch(IOException e) {
        	System.out.println("File not found ");
        }
    }
 }

import java.io.*;
import java.util.*;

public class JsonToCsv {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:/CapLabWorks/CapLabWorks/week_6/CsvDataHandling/CsvDataHandling/students.json"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:/CapLabWorks/CapLabWorks/week_6/CsvDataHandling/CsvDataHandling/studentsfromcsv.csv"));

        String line;
        List<String> rows = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.startsWith("{") && line.endsWith("},")) {
                rows.add(line.substring(0, line.length() - 1)); 
            } else if (line.startsWith("{") && line.endsWith("}")) {
                rows.add(line);
            }
        }

        bw.write("ID,Name,Email,Marks\n");

        for (String row : rows) {
            row = row.replace("{", "").replace("}", "").replace("\"", "");
            String[] fields = row.split(",");
            Map<String, String> map = new HashMap<>();

            for (String field : fields) {
                String[] keyVal = field.split(":");
                map.put(keyVal[0].trim(), keyVal[1].trim());
            }

            bw.write(map.get("id") + "," + map.get("name") + "," + map.get("email") + "," + map.get("marks") + "\n");
        }

        br.close();
        bw.close();
        System.out.println("Converted JSON to CSV .");
    }
}

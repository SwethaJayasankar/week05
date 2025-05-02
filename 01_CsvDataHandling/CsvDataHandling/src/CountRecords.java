
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class CountRecords {
	public static void main(String args[]) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("D:/CapLabWorks/CapLabWorks/week_6/CsvDataHandling/CsvDataHandling/employee.csv"));
			int count =0 ;
			
			while((br.readLine())!=null) {
				count++;
			}
			br.close();
			System.out.println("Total Records : "+ count);
		}catch(IOException e) {
			System.out.println("File not found");
		}
	
	}
}
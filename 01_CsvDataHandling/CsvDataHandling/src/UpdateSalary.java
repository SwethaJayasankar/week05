import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UpdateSalary {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("D:/CapLabWorks/CapLabWorks/week_6/CsvDataHandling/CsvDataHandling/employee.csv"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("D:/CapLabWorks/CapLabWorks/week_6/CsvDataHandling/CsvDataHandling/employeeUpdated.csv"));
			String i;
			br.readLine();
			while((i=br.readLine())!=null) {
				String[] arr = i.split(",");
				String updatedsal = String.valueOf(Integer.valueOf(arr[3])+10000);
			    bw.append(arr[0]+","+arr[1]+","+arr[2]+","+updatedsal+"\n");
				
				
			}
			br.close();
			bw.close();
			System.out.println("successfully updated");
			
		}catch(IOException e) {
			System.out.println("File not found");
		}
	}
	

}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class GetEmployee {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("D:/CapLabWorks/CapLabWorks/week_6/CsvDataHandling/CsvDataHandling/employee.csv"));
			String i;
			while((i=br.readLine())!=null) {
				String[] arr = i.split(",");
			
				if(arr[1].equalsIgnoreCase("Devi")) {
					System.out.println("Devis department : "+ arr[2] +"--Salary : "+ arr[3]);
				}
				

			}
			br.close();
			
		}catch(IOException e) {
			System.out.println("File not found");
		}
	}
	

}

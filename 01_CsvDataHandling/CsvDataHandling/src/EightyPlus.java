import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EightyPlus {
	public static void main(String args[]) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("D:/CapLabWorks/CapLabWorks/week_6/CsvDataHandling/CsvDataHandling/Students.csv"));
			String i;
			
			while((i=br.readLine())!=null) {
				int marks = Integer.valueOf(i.split("\\s+")[3]);
				if(marks>95) {
					System.out.println(i);
				}
				
			}
			br.close();
		}
		catch(IOException e) {
			System.out.println("File not found !! ");
		}
	}

}

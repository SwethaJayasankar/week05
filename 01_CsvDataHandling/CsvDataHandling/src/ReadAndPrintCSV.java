
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndPrintCSV {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("Students.csv"));
			String i;
			while((i = br.readLine())!=null) {
				String[] arr = i.split("\\s+");
				System.out.println("Id : "+ arr[0] + "| Name : "+ arr[1] + "| Age : "+ arr[2] + "| Marks : "+ arr[3]);
			}
			br.close();
		}catch(IOException e) {
			System.out.println("File not found");
		}
	}
}
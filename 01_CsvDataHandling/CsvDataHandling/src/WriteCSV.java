
import java.io.FileWriter;
import java.io.IOException;
public class WriteCSV {
	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("employee.csv");
			fw.append("Id,Name,Department,Salary\n");
			fw.append("1,Priya,HR,80000\n");
			fw.append("2,Tanu,Sales,90000\n");
			fw.append("3,Keerthi,Sales,70000\n");
			fw.append("4,Devi,Engineering,80000\n");
			fw.append("5,Mohan,Sales,80000\n");
			fw.close();
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
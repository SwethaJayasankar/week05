import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Student {
    public int id;
    public String name;
    public int age;
    public int marks;

    public Student(int id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

}
public class StudentList{
	public static void main(String[] args) {
		try {
			List<Student> studentrecords = new ArrayList<>();
			BufferedReader br = new BufferedReader(new FileReader("D:/CapLabWorks/CapLabWorks/week_6/CsvDataHandling/CsvDataHandling/Students.csv"));
			String i;
			while((i=br.readLine())!=null) {
				String[] arr = i.split("\\s+");
				studentrecords.add(new Student(Integer.valueOf(arr[0]),arr[1],Integer.valueOf(arr[2]),Integer.valueOf(arr[3])));

			}
			for(int j = 0; j < studentrecords.size(); j++) {
			    System.out.println(studentrecords.get(j).id + " " +
			                       studentrecords.get(j).name + " " +
			                       studentrecords.get(j).age + " " +
			                       studentrecords.get(j).marks);
			}
			br.close();
		}catch(IOException e ) {
			System.out.println("File Not found ! ");
		}
	}
}


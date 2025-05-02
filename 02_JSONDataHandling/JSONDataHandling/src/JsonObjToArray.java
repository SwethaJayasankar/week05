import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

class Student{
	public String name;
	public int age;
	public Student(String name,int age) {
		this.name=name;this.age=age;
	}
	
}
public class JsonObjToArray {
	public static void main(String[] args) {
		try {
			List<Student> students = new ArrayList<>();
	        students.add(new Student("Priya", 18));
	        students.add(new Student("Raj", 20));

	        ObjectMapper mapper = new ObjectMapper();
	        String jsonArray = mapper.writeValueAsString(students);

	        System.out.println(jsonArray);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}

package basicproblems;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Student{
	private String name;
	private int age;
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public int getAge() {
		return this.age;
	}
	public String getName() {
		return this.name;
	}
	
}

public class GetClassDetails {
	public static void main(String[] args) {
		try {
			Class<?> classname = Class.forName("basicproblems.Student");
			System.out.println(classname.getName());
			System.out.println("Constructors : ");
			for(Constructor c : classname.getDeclaredConstructors()) {
				System.out.println(c);
			}
			System.out.println("Methods : ");
			for(Method m : classname.getDeclaredMethods()) {
				System.out.println(m);
			}
			System.out.println("Fields : ");
			for(Field f : classname.getDeclaredFields()) {
				System.out.println(f);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}

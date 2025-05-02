package basicproblems;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Student1{
	private String name;
	private int age;
	public Student1(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	
}

public class ModifyAge {
	public static void main(String[] args) {
		try {
			Student1 s = new Student1("Ben",16);
			Class<?> classname = s.getClass();
			Field f = classname.getDeclaredField("age");
			
			f.setAccessible(true);
			System.out.println("Before modifying : " + f.get(s));
			f.set(s, 18);
			System.out.println("After modifying : " + f.get(s));
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}

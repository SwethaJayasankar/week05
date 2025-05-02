package basicproblems;

import java.lang.reflect.Method;

class Calculator{
	private int multiply(int a,int b) {
		return a*b;
	}
}

public class CalculatorInvoke{
	public static void main(String[] args) {
		try {
			Class<?> classname = Class.forName("basicproblems.Calculator");
			 Object calculatorInstance = classname.getDeclaredConstructor().newInstance();
			Method method = classname.getDeclaredMethod("multiply", int.class, int.class);
            method.setAccessible(true);

            System.out.println("Result of multiply: " + method.invoke(calculatorInstance, 5,3));
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

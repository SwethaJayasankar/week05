import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo{
	String task();
	String assignedTo();
	String priority() default "MEDIUM";
}
public class ToDoAnnotation {
	
	@Todo(task="login",assignedTo="Rohan",priority="High")
	public void login() {
	}
	
	@Todo(task="logout",assignedTo="Ricky")
	public void logout() {
	}
	
	public static void main(String[] args) {
		 Class<ToDoAnnotation> obj = ToDoAnnotation.class;
	        for (Method method : obj.getDeclaredMethods()){
	            if (method.isAnnotationPresent(Todo.class)) {
	                Todo todo = method.getAnnotation(Todo.class);
	                System.out.println("Pending Task in Method: " + method.getName());
	                System.out.println(" → Task: " + todo.task());
	                System.out.println(" → Assigned To: " + todo.assignedTo());
	                System.out.println(" → Priority: " + todo.priority());
	                System.out.println("---------------------------");
	            }
	        }
	}

}

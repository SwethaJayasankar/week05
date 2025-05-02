import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo{
	String priority();
    String assignedTo();
	
}
public class TaskManager {
	@TaskInfo(priority="high",assignedTo="Ben")
	public void display() {
		System.out.println("displaying the task here...");
	}
	 public static void main(String[] args) throws Exception {
	        Class<TaskManager> obj = TaskManager.class;
	        for (Method method : obj.getDeclaredMethods()) {
	            if (method.isAnnotationPresent(TaskInfo.class)) {
	                TaskInfo task = method.getAnnotation(TaskInfo.class);
	                System.out.println("Method: " + method.getName());
	                System.out.println("Priority: " + task.priority());
	                System.out.println("Assigned To: " + task.assignedTo());
	            }
	        }
	        new TaskManager().display();
	 }
}

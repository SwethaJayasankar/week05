import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod{
	String message() default "HIGH";
}

public class ImportantMethodAnnotation {
	
	@ImportantMethod(message="usage 1")
	public void display() {
		System.out.println("Using important method anotation here");
	}
	@ImportantMethod(message="Usage 2")
	public void display_two() {
		System.out.println("Using important method anotation here for the second time. ");
	}
	public static void main(String[] args) {
		Class<ImportantMethodAnnotation> obj = ImportantMethodAnnotation.class ;
        for (Method method : obj.getDeclaredMethods()) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName() + ", Level: " + annotation.message());
            }
        }
	}

}

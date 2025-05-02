import java.lang.annotation.*;
import java.lang.reflect.Method;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
}


public class PerformanceTester {

    @LogExecutionTime
    public void fastMethod() {
        for (int i = 0; i < 1000; i++) {
            int x = i * i;
        }
    }

    @LogExecutionTime
    public void slowMethod() {
        for (int i = 0; i < 1_000_000; i++) {
            int x = i * i;
        }
    }

    public static void main(String[] args) throws Exception {
        PerformanceTester tester = new PerformanceTester();

        Method[] methods = PerformanceTester.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long start = System.nanoTime();
                method.invoke(tester);
                long end = System.nanoTime();
                long duration = end - start;

                System.out.println("Executed: " + method.getName() +
                        " | Time Taken: " + duration + " ns");
            }
        }
    }
}

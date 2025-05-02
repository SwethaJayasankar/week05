import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {}

class ExpensiveCalculator {
    private static Map<Integer, Integer> cache = new HashMap<>();
    
    @CacheResult
    public int computeSquare(int number) {
        if (cache.containsKey(number)) {
            System.out.println("Returning cached result for " + number);
            return cache.get(number);
        }
        System.out.println("Computing square of " + number);
        int result = number * number;
        cache.put(number, result);
        return result;
    }
}

public class CacheAnnotation{
    public static void main(String[] args) throws Exception {
        ExpensiveCalculator calc = new ExpensiveCalculator();
        Method method = calc.getClass().getMethod("computeSquare", int.class);

        if (method.isAnnotationPresent(CacheResult.class)) {
            System.out.println("First call: " + method.invoke(calc, 5));
            System.out.println("Second call: " + method.invoke(calc, 5)); 
            System.out.println("New input: " + method.invoke(calc, 10));        
        }
    }
}

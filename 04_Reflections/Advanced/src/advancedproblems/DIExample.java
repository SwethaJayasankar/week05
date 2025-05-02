package advancedproblems;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {}

class Engine {
    public void start() {
        System.out.println("Engine started.");
    }
}

class Car {
    @Inject
    private Engine engine;

    public void drive() {
        engine.start();
        System.out.println("Car is driving.");
    }
}

class SimpleDIContainer {
    public <T> T createInstance(Class<T> clazz) {
        try {
            T obj = clazz.getDeclaredConstructor().newInstance();

            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(Inject.class)) {
                    Class<?> fieldType = field.getType();
                    Object dependency = createInstance(fieldType);
                    field.setAccessible(true);
                    field.set(obj, dependency);
                }
            }
            return obj;

        } catch (Exception e) {
            throw new RuntimeException("Failed to create instance of: " + clazz.getName(), e);
        }
    }
}

public class DIExample {
    public static void main(String[] args) {
        SimpleDIContainer container = new SimpleDIContainer();
        Car car = container.createInstance(Car.class);
        car.drive();
    }
}

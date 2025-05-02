package advancedproblems;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

class Person {
    private String name;
    private int age;
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

public class ObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            T instance = clazz.getDeclaredConstructor().newInstance(); 

            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                String fieldName = entry.getKey();
                Object value = entry.getValue();

                try {
                    Field field = clazz.getDeclaredField(fieldName); 
                    field.setAccessible(true); 
                    field.set(instance, value);
                } catch (NoSuchFieldException e) {
                    System.out.println("No field named '" + fieldName + "' found.");
                }
            }

            return instance;

        } catch (Exception e) {
            throw new RuntimeException("Error while mapping: " + e.getMessage(), e);
        }
    }

    public static void main(String[] args) {
        Map<String, Object> data = new HashMap<>();
        data.put("name", "Alice");
        data.put("age", 25);
        Person person = toObject(Person.class, data);

        System.out.println(person);
    }
}

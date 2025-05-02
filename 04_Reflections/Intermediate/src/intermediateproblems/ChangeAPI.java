package intermediateproblems;

import java.lang.reflect.Field;

class Configuration {
    private static String API_KEY = "ORIGINAL_KEY";
}
public class ChangeAPI {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Configuration.class;
        Field field = clazz.getDeclaredField("API_KEY");
        field.setAccessible(true);
        System.out.println("Before Modification API_KEY: " + field.get(clazz));
        field.set(clazz, "NEW_API_KEY_12345");
        System.out.println("Modified API_KEY: " + field.get(clazz));
    }
}


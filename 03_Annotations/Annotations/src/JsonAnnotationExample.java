import java.lang.annotation.*;
import java.lang.reflect.*;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class UserClass {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "email_id")
    private String email;

    private int age; 

    public UserClass(String username, String email, int age) {
        this.username = username;
        this.email = email;
        this.age = age;
    }
}

public class JsonAnnotationExample {
    public static String toJson(Object obj) throws IllegalAccessException {
        StringBuilder json = new StringBuilder("{");
        Field[] fields = obj.getClass().getDeclaredFields();
        boolean first = true;

        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                JsonField annotation = field.getAnnotation(JsonField.class);
                if (!first) json.append(", ");
                json.append("\"").append(annotation.name()).append("\": \"")
                    .append(field.get(obj)).append("\"");
                first = false;
            }
        }

        json.append("}");
        return json.toString();
    }

    public static void main(String[] args) throws IllegalAccessException {
        UserClass user = new UserClass("alice123", "alice@example.com", 25);
        String json = toJson(user);
        System.out.println(json);
    }
}

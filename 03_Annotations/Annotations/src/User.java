import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}


public class User {
    @MaxLength(value = 15)
    private String username;

    public User(String name) {
        this.username = name;
        validate();
    }

    public String getUserName() {
        return this.username;
    }

    public void validate() {
        Field[] fields = User.class.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(MaxLength.class)) {
                MaxLength ml = field.getAnnotation(MaxLength.class);
                field.setAccessible(true);
                try {
                    String value = (String) field.get(this); 
                    if (value != null && value.length() > ml.value()) {
                        throw new IllegalArgumentException("Field '" + field.getName() +
                                "' exceeds max length of " + ml.value());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new User("Alice"); 
        new User("PankajGupthaSrivastav899000"); 
    }
}

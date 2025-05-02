package intermediateproblems;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}

@Author(name = "Paxton Yoshide")
class Book {
	
}
public class ReadAnnotationClass {
    public static void main(String[] args) {
        Class<?> c = Book.class;
        if (c.isAnnotationPresent(Author.class)) {
            Author author = c.getAnnotation(Author.class);
            System.out.println("Author: " + author.name());
        }
    }
}



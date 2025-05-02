package basicproblems;

import java.lang.reflect.Constructor;

class Student2 {
    private String name;
    private int age;

    public Student2(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
public class DynamicObjectCreation {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Student2.class;
        Constructor<?> constructor = clazz.getConstructor(String.class, int.class);
        Object studentObj = constructor.newInstance("BEN", 32);
        Student2 student = (Student2) studentObj;
        System.out.println(student);
    }
}


import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}


public class BugTracker {
    @BugReport(description = "NullPointerException when input is null")
    @BugReport(description = "ArrayIndexOutOfBoundsException on empty list")
    public void process() {
        System.out.println("Processing data...");
    }
    public static void main(String[] args) throws Exception {
        Method method = BugTracker.class.getMethod("process");

        if (method.isAnnotationPresent(BugReports.class)) {
            BugReports reports = method.getAnnotation(BugReports.class);
            for (BugReport bug : reports.value()) {
                System.out.println("Bug Description: " + bug.description());
            }
        }


        BugReport[] bugs = method.getAnnotationsByType(BugReport.class);
        for (BugReport bug : bugs) {
            System.out.println("Bug Description (via getAnnotationsByType): " + bug.description());
        }
        new BugTracker().process();
    }
}

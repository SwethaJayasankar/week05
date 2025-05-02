import java.lang.reflect.Method;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class AdminService {

    @RoleAllowed("ADMIN")
    public void deleteUser() {
        System.out.println("User deleted successfully.");
    }

    @RoleAllowed("USER")
    public void viewProfile() {
        System.out.println("User profile viewed.");
    }
}


public class RoleBasedAccess {
    
   
    static String currentUserRole = "USER"; 

    public static void invokeIfAllowed(Object obj, String methodName) {
        try {
            Method method = obj.getClass().getMethod(methodName);
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);
                if (currentUserRole.equals(roleAllowed.value())) {
                    method.invoke(obj); 
                } else {
                    System.out.println("Access Denied!");
                }
            } else {
                method.invoke(obj); 
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        AdminService service = new AdminService();

   
        System.out.print("Trying to view profile: ");
        invokeIfAllowed(service, "viewProfile");

        System.out.print("Trying to delete user: ");
        invokeIfAllowed(service, "deleteUser");
    }
}

package MetaProgramming;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface MenuCategory {
    String name();
    boolean available() default true;
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface OrderAction {
    String handledBy();
    int estimatedMinutes() default 5;
    boolean requiresPayment() default false;
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldValidation{
    int maxLength() default 50;
    boolean nullable() default false;
}

@MenuCategory(name = "Pizza", available = true)
public class PizzaOrder {

    @FieldValidation(maxLength = 30, nullable = false)
    String customerName;
    @FieldValidation(maxLength = 100, nullable = true)
    String specialRequest;
    @FieldValidation(maxLength = 20, nullable = false)
    String itemName;

    @OrderAction(handledBy = "Cashier", estimatedMinutes = 2, requiresPayment = false)
    public void takeOrder(){
        System.out.println("Taking the order...");
    }

    @OrderAction(handledBy = "Chef", estimatedMinutes = 15)
    public void prepareFood(){
        System.out.println("Preparing the pizza...");
    }

    @OrderAction(handledBy = "Cashier", requiresPayment = true)
    public void processPayment(){
        System.out.println("Processing payment...");
    }
}

class MainM{
    public static void main(String[] args) {
        PizzaOrder order = new PizzaOrder();
        Class<?> clas = order.getClass();

        if (clas.isAnnotationPresent(MenuCategory.class)){
            MenuCategory mc = clas.getAnnotation(MenuCategory.class);
            System.out.println("==Menu Category ===");
            System.out.println("Category: " + mc.name());
            System.out.println("Available: " + (mc.available() ? "Yes" : "No"));
        }

        System.out.println("=== Field Validation ===");
        for (Field field : clas.getDeclaredFields()){
            FieldValidation fv = field.getAnnotation(FieldValidation.class);
            System.out.println("Field: " + field.getName());
            System.out.println("Max Len: " + fv.maxLength());
            System.out.println("Nullable: " + (fv.nullable() ? "Yes" : "No"));
            System.out.println();
        }

        for (Method method : clas.getDeclaredMethods()){
            if (method.isAnnotationPresent(OrderAction.class)){
                OrderAction oa = method.getAnnotation(OrderAction.class);
                System.out.println("=== Order Action ===");
                System.out.println("Method: " + method.getName());
                System.out.println("HandledBy: " + oa.handledBy());
                System.out.println("Est. Time: " + oa.estimatedMinutes() + " min(s)");
                System.out.println("Requires Payment: " + (oa.requiresPayment() ? "Yes" : "No"));
                System.out.println();
            }
        }
    }
}
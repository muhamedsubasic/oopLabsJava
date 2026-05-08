package MetaProgramming;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface TrackTask{
    String assignedTo();
    int priority() default 1;
}

public class ProjectTasks {
    @TrackTask(assignedTo = "Bob", priority = 2)
    public void optimizeMemory(){
        System.out.println("Optimizing memory usage...");
    }

    @TrackTask(assignedTo = "Alice", priority = 3)
    public void fixCriticalBug(){
        System.out.println("Fixing critical bug...");
    }

    @TrackTask(assignedTo = "Charlie")
    public void documentCode(){
        System.out.println("Documenting the project...");
    }
}

class Mainpt{
    public static void main(String[] args) {
        ProjectTasks tasks = new ProjectTasks();
        Class<?> c = tasks.getClass();

        for (Method method : c.getDeclaredMethods()){
            if (method.isAnnotationPresent(TrackTask.class)){
                TrackTask tt = method.getAnnotation(TrackTask.class);
                String word = switch (tt.priority()){
                    case 1 -> "Low";
                    case 2 -> "Medium";
                    case 3 -> "High";
                    default -> "Unknown";
                };
                System.out.println("Method: " + method.getName());
                System.out.println("Assigned to: " + tt.assignedTo());
                System.out.println("Priority: " + word);
                System.out.println();
            }
        }
    }
}

package MetaProgramming;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Dog {
    private final String name;
    private int age;

    public Dog(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void bark(){
        System.out.println("Woof!");
    }

    public void say(String message){
        System.out.println("Dof says: " + message);
    }

    private void whisper(){
        System.out.println("Secret bark...");
    }

    public static void info(){
        System.out.println("Static info about dogs.");
    }
}

class MainD {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Dog dog = new Dog("Rex", 3);
        Class<?> clas = dog.getClass();

        System.out.println("Full class name: " + clas.getName() + "\n");

        System.out.println("Fields:");
        for (Field field : clas.getDeclaredFields()){
            String ac = Modifier.toString(field.getModifiers());
            System.out.println(ac + " " + field.getType().getSimpleName() + " " + field.getName());
        }

        System.out.println("\nMethods");
        for (Method m : clas.getDeclaredMethods()){
            String rettype = m.getReturnType().getSimpleName();
            String name = m.getName();
            String params = Arrays.toString(m.getParameterTypes());
            String access = Modifier.toString(m.getModifiers());
            System.out.println(access + " " + rettype + " " + name + params);
        }

        Field nameField = clas.getDeclaredField("name");
        nameField.setAccessible(true);

        Field modifiers = Field.class.getDeclaredField("modifiers");
        modifiers.setAccessible(true);
        modifiers.setInt(nameField, nameField.getModifiers() & ~Modifier.FINAL);

        String oldName = (String) nameField.get(dog);
        nameField.set(dog, "Max");
        String newName = (String) nameField.get(dog);
        System.out.println("\nModified 'name': before = " + oldName + ", after = " + newName);

        Field ageField = clas.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(dog, 5);
        System.out.println("Modified age to: " + ageField.get(dog));

        System.out.println("Invoke Methods:");

        Method barkMethod = clas.getDeclaredMethod("bark");
        barkMethod.invoke(dog);

        Method sayMethod = clas.getDeclaredMethod("say", String.class);
        sayMethod.invoke(dog, "Hello reflection!");

        Method whisperMethod = clas.getDeclaredMethod("whisper");
        whisperMethod.setAccessible(true);
        whisperMethod.invoke(dog);

        Method infoMethod = clas.getDeclaredMethod("info");
        infoMethod.invoke(null);
    }
}

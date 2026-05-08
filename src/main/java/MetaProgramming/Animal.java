package MetaProgramming;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface VeryImportant{}

@VeryImportant
record Lion(String name){}

public class Animal {
    private String name;
    private int age;

    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){ return this.name; }
    public int getAge(){ return this.age; }
    public void setAge(int age){ this.age = age; }

    public void speak(){
        System.out.println("The animal makes a sound.");
    }

    public void say(String message){
        System.out.println("Animal says" + message);
    }
}

class Mainanim{
    public static void main(String[] args) throws Exception {
        Animal animal = new Animal("Leo", 10);
        Class<?> clas = animal.getClass();

        Field nameField = clas.getDeclaredField("name");
        nameField.setAccessible(true);

        Field modifiers = Field.class.getDeclaredField("modifiers");
        modifiers.setAccessible(true);
        modifiers.setInt(nameField, nameField.getModifiers() & ~Modifier.FINAL);

        String before = (String) nameField.get(animal);
        System.out.println("Before: " + before);
        nameField.set(animal, "Nala");
        String after = (String) nameField.get(animal);
        System.out.println("After: " + after);

        System.out.println("Field names:");
        for (Field f : clas.getDeclaredFields()){
            System.out.println(" " + f.getName());
        }
        System.out.println("Method names: ");
        for (Method m : clas.getDeclaredMethods()){
            System.out.println(" " + m.getName());
        }

        Method speak = clas.getDeclaredMethod("speak");
        speak.invoke(animal);

        Method say = clas.getDeclaredMethod("say", String.class);
        say.invoke(animal, "Im a animal");
    }
}
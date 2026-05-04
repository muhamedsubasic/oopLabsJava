package CollectionsAndLambdas;

import java.util.Optional;

record Wolf(String name, int age){}

public class Wolfs {
    static Optional<Wolf> findWolfByName(String name){
        Wolf[] wolves = {
                new Wolf("Fenrir", 5),
                new Wolf("Luna", 3),
                new Wolf("Shadow", 4)
        };
        for (Wolf w: wolves) {
            if (w.name().equalsIgnoreCase(name)) {
                return Optional.of(w);
            }
        }
        return Optional.empty();
    }
    public static void main(String[] args) {

        // ifPresent
        findWolfByName("Luna").ifPresent(w -> System.out.println("Found: " + w));

        // orElse
        Wolf defaultWolf = new Wolf("Unknown", 0);
        Wolf result1 = findWolfByName("Thor").orElse(defaultWolf);
        System.out.println("orElse example: " + result1);

        // orElseThrow
        try {
            Wolf result2 = findWolfByName("Fenrir").orElseThrow(() -> new RuntimeException("Wolf not found!"));
            System.out.println("orElseThrow example: " + result2);
            findWolfByName("Ghost").orElseThrow(() -> new RuntimeException("Wolf not found!"));
        } catch (RuntimeException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}

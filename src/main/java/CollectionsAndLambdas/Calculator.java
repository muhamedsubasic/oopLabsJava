package CollectionsAndLambdas;

@FunctionalInterface
interface Operation{
    int apply(int a, int b);
}

public class Calculator {
    public static int calculate(int a, int b, Operation op){
        return op.apply(a, b);
    }

    public static void main(String[] args) {
        Operation add = (a, b) -> a + b;
        Operation subtract = (a, b) -> a - b;
        Operation multiply = (a, b) -> a * b;
        Operation divide = (a, b) -> a / b;

        int x = 20, y = 10;

        System.out.println("Add: " + calculate(x, y, add));
        System.out.println("Subtract: " + calculate(x, y, subtract));
        System.out.println("Multiply: " + calculate(x, y, multiply));
        System.out.println("Divide: " + calculate(x, y, divide));
    }
}

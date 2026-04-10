package DiamondAndFizzBuzz;

import java.util.Scanner;

public class Main {
        public static void main(String[] args){
            int x;
            int y;
            Scanner input = new Scanner(System.in);
            x = input.nextInt();
            y = input.nextInt();
            fizzBuzz(x, y);
        }
        public static void fizzBuzz(int x, int y) {
            while (x <= y) {
                if (x % 3 == 0) {
                    System.out.print("Fizz");
                } else if (x % 5 == 0) {
                    System.out.print("Buzz");
                } else {
                    System.out.println(x);
                }
                x++;
            }
        }
}
package io;

import java.util.Scanner;

/**
 * Created by lujianyu on 7/28/17.
 */
public class Console {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What's your favorite color?");
        String name = scanner.next();
        System.out.println("You favorite color is " + name);

        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();
        System.out.println("The number is: " + number);

        System.out.print("Enter a boolean value (true or false): ");
        if (scanner.hasNext()) {
            boolean bool = scanner.nextBoolean();
            System.out.println("You entered: " + bool);
        } else {
            System.out.println("no input");
        }
    }
}

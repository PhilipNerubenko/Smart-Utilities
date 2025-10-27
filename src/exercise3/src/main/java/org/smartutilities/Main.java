package org.smartutilities;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int value = readValue();
        try {
            int result = calculateFibonacci(value);
            System.out.println(result);
        } catch (StackOverflowError e) {
            System.out.println("Too large n");
        }
    }

    private static int calculateFibonacci(int value) throws StackOverflowError{
        if (value == 0) {
            return 0;
        }
        if (value == 1) {
            return 1;
        }
        if (value < 0) {
            // Вычисляем по формуле F(-n) = (-1)^(n+1) * F(n)
            return (int) Math.pow(-1, value + 1) * calculateFibonacci(-value);
        } else {
            // Рекурсивное вычисление для положительных чисел
            return calculateFibonacci(value - 1) + calculateFibonacci(value - 2);
        }
    }

    private static int readValue() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input value: ");
        while(true) {
            String line = scanner.hasNextLine() ? scanner.nextLine().trim() : null;
            if (line == null) {
                System.out.println("Could not parse a number. Please, try again");
                continue;
            }

            if (line.isEmpty()) {
                System.out.println("Could not parse a number. Please, try again");
                continue;
            }

            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Could not parse a number. Please, try again");
            } finally {
                scanner.close();
            }
        }
    }

}
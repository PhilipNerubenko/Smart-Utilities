package org.smartutilities;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            System.out.println("Input error");
            scanner.close();
            return;
        }

        int previous = scanner.nextInt();
        int count = 1;
        boolean isOrdered = true;
        int breakingNumber = 0;

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int current = scanner.nextInt();
                count++;

                if (current <= previous) {
                    isOrdered = false;
                    breakingNumber = current;
                    break;
                }
                previous = current;
            } else {
                break;
            }
        }

        scanner.close();

        if (count == 0) {
            System.out.println("Input error");
        } else if (isOrdered) {
            System.out.println("The sequence is in ascending order");
        } else {
            System.out.println("The sequence is not ordered from the ordinal number of " +
                    "the number " + breakingNumber);
        }
    }
}
package org.smartutilities;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = readValue(scanner);
        if (count <= 0) {
            System.out.println("Input error. Size <= 0");
            return;
        }

        int[] array = new int[count];

        for (int i = 0; i < count; i++) {
            array[i] = readValue(scanner);
        }

        int sum = 0;
        int negativeCount = 0;
        for (int i = 0; i < count; i++) {
            if (array[i] < 0) {
                sum += array[i];
                negativeCount++;
            }
        }

        if (negativeCount == 0) {
            System.out.println("There are no negative elements");
        } else {
            double average = (double) sum / negativeCount;

            if (average == (int) average) {
                System.out.println((int) average);
            } else {
                System.out.println(average);
            }
        }
        scanner.close();
    }

    private static int readValue(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Could not parse a number. Please, try again");
                scanner.nextLine();
            }
        }
    }
}
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
        int countResult = 0;
        int i = 0;

        while (i < count) {
            array[i] = readValue(scanner);
            if (firstAndLastDigitMatch(array[i])) {
                countResult++;
            }
            i++;
        }

        if (countResult == 0) {
            System.out.println("There are no such elements");
        } else {
            int[] arrayResult = new int[countResult];
            int resultIndex = 0;
            i = 0;

            while (i < array.length) {
                if (firstAndLastDigitMatch(array[i])) {
                    arrayResult[resultIndex++] = array[i];
                }
                i++;
            }

            i = 0;

            while (i < arrayResult.length) {
                System.out.print(arrayResult[i] + " ");
                i++;
            }
        }

        scanner.close();
    }

    public static boolean firstAndLastDigitMatch(int number) {
        String str = Integer.toString(Math.abs(number));
        char firstDigit = str.charAt(0);
        char lastDigit = str.charAt(str.length() - 1);
        return firstDigit == lastDigit;
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
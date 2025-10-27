package org.smartutilities;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        System.out.println("Input value:");
        Scanner scanner = new Scanner(System.in);

        double x1 = readDouble(scanner);
        double y1 = readDouble(scanner);
        double x2 = readDouble(scanner);
        double y2 = readDouble(scanner);
        double x3 = readDouble(scanner);
        double y3 = readDouble(scanner);

        if (isTriangle(x1, y1, x2, y2, x3, y3)) {
            double sideAB = distance(x1, y1, x2, y2);
            double sideBC = distance(x2, y2, x3, y3);
            double sideCA = distance(x3, y3, x1, y1);
            double perimeter = sideAB + sideBC + sideCA;
            System.out.printf("Perimeter: %.3f%n", perimeter);
        } else {
            System.out.println("It's not a triangle");
        }

        scanner.close();
    }

    private static boolean isTriangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        double result = (Math.abs(x1 * (y2-y3) + x2 * (y3-y1) + x3 * (y1 - y2))) * 1/2;
        return result != 0.0;
    }

    private static double distance(double x1, double y1, double x2, double y2) {
        double dx = x1 - x2;
        double dy = y1 - y2;
        return Math.sqrt(dx * dx + dy * dy);
    }

    private static double readDouble(Scanner scanner) {
        while (true) {
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
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("Could not parse a number. Please, try again");
            }
        }
    }
}
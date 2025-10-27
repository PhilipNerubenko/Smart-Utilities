package org.smartutilities;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int seconds = readSeconds();
        String timeStr = convertToHMS(seconds);
        showOutput(timeStr);
    }

    private static String convertToHMS(int totalSeconds) {
        if (totalSeconds < 0) {
            return "Incorrect time";
        }

        int hours = totalSeconds / 3600;
        int minutes = (totalSeconds % 3600) / 60;
        int seconds = totalSeconds % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    private static int readSeconds() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input seconds: ");
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

    private static void showOutput(String result) {
        System.out.println(result);
    }
}
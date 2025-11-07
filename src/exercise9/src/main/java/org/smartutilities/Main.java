package org.smartutilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<String> filterStrings(List<String> strings, String substring) {
        List<String> result = new ArrayList<>();

        for (String str : strings) {
            if (str.contains(substring)) {
                result.add(str);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> strings = new ArrayList<>();

        try {
            int count = Integer.parseInt(scanner.nextLine());

            if (count <= 0) {
                System.out.println("Input error. Size <= 0");
                return;
            }

            for (int i = 0; i < count; i++) {
                System.out.print("Input string " + (i + 1) + ": ");
                String line = scanner.nextLine();
                strings.add(line);
            }

            System.out.print("Input substring for filter: ");
            String substring = scanner.nextLine();

            List<String> filteredStrings = filterStrings(strings, substring);

            if (filteredStrings.isEmpty()) {
            } else {
                for (int i = 0; i < filteredStrings.size(); i++) {
                    System.out.print(filteredStrings.get(i));
                    if (i < filteredStrings.size() - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println();
            }

        } catch (NumberFormatException e) {
            System.out.println("Input error. Invalid number format");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

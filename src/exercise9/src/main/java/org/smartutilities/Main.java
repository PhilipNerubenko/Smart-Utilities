package org.smartutilities;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            System.out.println("Input error");
            scanner.close();
            return;
        }

        int count = readUserCount(scanner);

        if (count <= 0) {
            System.out.println("Input error. Size <= 0");
            return;
        }

        for (int i = 0; i < count; i++) {
                String name = scanner.nextLine().trim();
                if (name.isEmpty()) {
                    System.out.println("Name cannot be empty. Skipping user.");
                    i--;
                    continue;
                }
                int age = readUserAge(scanner);
                while (age <= 0) {
                    name = scanner.nextLine().trim();
                    if (name.isEmpty()) {
                        System.out.println("Name cannot be empty. Skipping user.");
                        continue;
                    }
                    age = readUserAge(scanner);
                }
                userList.add(new User(name, age));
        }

        String result = userList.stream()
                .filter(user -> user.getAge() >= 18)
                .map(User::getName)
                .collect(Collectors.joining(", "));

        System.out.println(result);

        scanner.close();
    }

    private static int readUserCount(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Could not parse a number. Please, try again");
            }
        }
    }

    private static int readUserAge(Scanner scanner) {
        while (true) {
            try {
                int age = Integer.parseInt(scanner.nextLine());
                if (age <= 0) {
                    System.out.println("Incorrect input. Age <= 0");
                    return age;
                }
                return age;
            } catch (NumberFormatException e) {
                System.out.println("Could not parse a number. Please, try again");
            }
        }
    }
}